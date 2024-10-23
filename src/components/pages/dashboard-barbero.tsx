import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { LogOut, Calendar, Scissors, Check, X, AlertTriangle } from 'lucide-react';
import axiosInstance from '../../axiosConfig';

interface User {
  id: string;
  email: string;
  nombre: string;
  apellido: string;
}

interface Turno {
  id: string;
  fecha: string;
  hora: string;
  emailBarbero: string;
  corte: string;
  adicional: string;
  estado: string;
  local: string;
  emailCliente: string;
}

const BarberDashboard: React.FC = () => {
  const [allTurnos, setAllTurnos] = useState<Turno[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [user, setUser] = useState<User | null>(null);
  const [activeTab, setActiveTab] = useState<'pendientes' | 'completados' | 'cancelados'>('pendientes');
  const navigate = useNavigate();

  useEffect(() => {
    const userData = localStorage.getItem('user');
    if (!userData) {
      navigate('/iniciar-sesion');
      return;
    }

    const parsedUser = JSON.parse(userData);
    setUser(parsedUser);

    const fetchTurnos = async () => {
      try {
        const response = await axiosInstance.get("http://localhost:8090/api/turno");
        console.log("Respuesta de la API:", response.data); // Log de la respuesta completa

        const fetchedTurnos = response.data;

        if (!Array.isArray(fetchedTurnos)) {
          console.error("La respuesta de la API no es un array:", fetchedTurnos);
          setError('Error: Los datos recibidos no tienen el formato esperado.');
          setLoading(false);
          return;
        }

        // Filtrar los turnos para mostrar solo los del barbero que ha iniciado sesión
        const barberTurnos = fetchedTurnos.filter((turno: Turno) => {
          if (!turno || typeof turno !== 'object') {
            console.warn("Turno inválido encontrado:", turno);
            return false;
          }
          return turno.emailBarbero === parsedUser.email;
        });

        console.log("Turnos filtrados del barbero:", barberTurnos); // Log de los turnos filtrados

        setAllTurnos(barberTurnos);
        setLoading(false);
      } catch (err) {
        console.error('Error al obtener los turnos:', err);
        setError('Error al cargar los turnos. Por favor, intente nuevamente.');
        setLoading(false);
      }
    };

    fetchTurnos();
  }, [navigate]);

  const handleLogout = () => {
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    navigate('/iniciar-sesion');
  };
  const handleUpdateTurnoStatus = async (id: string, newStatus: string) => {
    try {
      // Encuentra el turno actual que se va a actualizar
      const turnoToUpdate = allTurnos.find(turno => turno.id === id);
      
      if (!turnoToUpdate) {
        console.error("No se encontró el turno a actualizar");
        return;
      }
  
      // Crea un nuevo objeto con todos los datos del turno y actualiza solo el estado
      const updatedTurno = { ...turnoToUpdate, estado: newStatus };
  
      // Realiza la solicitud PUT enviando todo el turno actualizado
      await axiosInstance.put(`http://localhost:8090/api/turno/${id}`, updatedTurno);
  
      // Actualiza el estado local con el nuevo estado
      setAllTurnos(allTurnos.map(turno => 
        turno.id === id ? { ...turno, estado: newStatus } : turno
      ));
    } catch (err) {
      console.error(`Error al actualizar el turno a ${newStatus}:`, err);
      setError(`Error al actualizar el turno a ${newStatus}. Por favor, intente nuevamente.`);
    }
  };
  
  const filteredTurnos = allTurnos.filter(turno => {
    if (activeTab === 'pendientes') return turno.estado.toLowerCase() === 'pendiente';
    if (activeTab === 'completados') return turno.estado.toLowerCase() === 'completado';
    if (activeTab === 'cancelados') return turno.estado.toLowerCase() === 'cancelado';
    return false;
  });

  if (loading) {
    return <div style={styles.loading}>Cargando tus turnos...</div>;
  }

  if (error) {
    return (
      <div style={styles.error}>
        <AlertTriangle size={24} />
        <p>{error}</p>
        <button onClick={() => window.location.reload()} style={styles.reloadButton}>
          Intentar de nuevo
        </button>
      </div>
    );
  }

  return (
    <div style={styles.container}>
      <div style={styles.header}>
        <h1 style={styles.title}>BarberTurn - Dashboard de Barbero</h1>
        <button onClick={handleLogout} style={styles.logoutButton}>
          <LogOut size={20} />
          Cerrar Sesión
        </button>
      </div>
      <div style={styles.content}>
        {user && <p style={styles.welcomeMessage}>Bienvenido, {user.nombre} {user.apellido}</p>}
        
        <div style={styles.tabContainer}>
          <button 
            style={activeTab === 'pendientes' ? {...styles.tabButton, ...styles.activeTab} : styles.tabButton} 
            onClick={() => setActiveTab('pendientes')}
          >
            Turnos Pendientes ({allTurnos.filter(t => t.estado.toLowerCase() === 'pendiente').length})
          </button>
          <button 
            style={activeTab === 'completados' ? {...styles.tabButton, ...styles.activeTab} : styles.tabButton} 
            onClick={() => setActiveTab('completados')}
          >
            Turnos Completados ({allTurnos.filter(t => t.estado.toLowerCase() === 'completado').length})
          </button>
          <button 
            style={activeTab === 'cancelados' ? {...styles.tabButton, ...styles.activeTab} : styles.tabButton} 
            onClick={() => setActiveTab('cancelados')}
          >
            Turnos Cancelados ({allTurnos.filter(t => t.estado.toLowerCase() === 'cancelado').length})
          </button>
        </div>

        <h2 style={styles.subtitle}>
          {activeTab === 'pendientes' && 'Turnos Pendientes'}
          {activeTab === 'completados' && 'Turnos Completados'}
          {activeTab === 'cancelados' && 'Turnos Cancelados'}
        </h2>

        <div style={styles.turnosList}>
          {filteredTurnos.map((turno) => (
            <div key={turno.id} style={styles.turnoItem}>
              <div style={styles.turnoHeader}>
                <Calendar size={20} />
                <span style={styles.turnoFecha}>{turno.fecha} - {turno.hora}</span>
              </div>
              <div style={styles.turnoDetails}>
                <p><strong>Cliente:</strong> {turno.emailCliente}</p>
                <p><strong>Corte:</strong> {turno.corte}</p>
                <p><strong>Servicios adicionales:</strong> {turno.adicional || 'Ninguno'}</p>
                <p><strong>Local:</strong> {turno.local}</p>
                <p><strong>Estado:</strong> {turno.estado}</p>
              </div>
              {activeTab === 'pendientes' && (
                <div style={styles.turnoActions}>
                  <button 
                    onClick={() => handleUpdateTurnoStatus(turno.id, 'Completado')} 
                    style={styles.completeButton}
                  >
                    <Check size={20} />
                    Completar
                  </button>
                  <button 
                    onClick={() => handleUpdateTurnoStatus(turno.id, 'Cancelado')} 
                    style={styles.cancelButton}
                  >
                    <X size={20} />
                    Cancelar
                  </button>
                </div>
              )}
            </div>
          ))}
          {filteredTurnos.length === 0 && (
            <p style={styles.noTurnos}>No hay turnos {activeTab} para mostrar.</p>
          )}
        </div>
      </div>
    </div>
  );
};

const styles = {
  container: {
    minHeight: '100vh',
    display: 'flex',
    flexDirection: 'column' as const,
    backgroundImage: `linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), url('https://hebbkx1anhila5yf.public.blob.vercel-storage.com/background-gallery-Q7o6O7FB8cgz1SLHAEc9d2u9QM5Lsr.jpg')`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    color: 'white',
  },
  header: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '20px',
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
  },
  title: {
    fontSize: '2em',
    margin: 0,
  },
  logoutButton: {
    display: 'flex',
    alignItems: 'center',
    gap: '5px',
    padding: '10px 15px',
    backgroundColor: '#ff4d4d',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  },
  content: {
    flex: 1,
    display: 'flex',
    flexDirection: 'column' as const,
    alignItems: 'center',
    padding: '20px',
  },
  welcomeMessage: {
    fontSize: '1.2em',
    marginBottom: '20px',
  },
  tabContainer: {
    display: 'flex',
    justifyContent: 'center',
    marginBottom: '20px',
  },
  tabButton: {
    padding: '10px 20px',
    backgroundColor: 'rgba(255, 255, 255, 0.1)',
    color: 'white',
    border: 'none',
    cursor: 'pointer',
    margin: '0 5px',
    borderRadius: '5px',
  },
  activeTab: {
    backgroundColor: 'rgba(255, 255, 255, 0.3)',
  },
  subtitle: {
    fontSize: '1.5em',
    marginBottom: '20px',
  },
  turnosList: {
    width: '100%',
    maxWidth: '800px',
  },
  turnoItem: {
    backgroundColor: 'rgba(255, 255, 255, 0.1)',
    borderRadius: '10px',
    padding: '15px',
    marginBottom: '15px',
  },
  turnoHeader: {
    display: 'flex',
    alignItems: 'center',
    marginBottom: '10px',
  },
  turnoFecha: {
    marginLeft: '10px',
    fontSize: '1.1em',
    fontWeight: 'bold' as const,
  },
  turnoDetails: {
    fontSize: '0.9em',
  },
  turnoActions: {
    display: 'flex',
    justifyContent: 'flex-end',
    marginTop: '10px',
    gap: '10px',
  },
  completeButton: {
    display: 'flex',
    alignItems: 'center',
    gap: '5px',
    padding: '5px 10px',
    backgroundColor: '#4CAF50',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  },
  cancelButton: {
    display: 'flex',
    alignItems: 'center',
    gap: '5px',
    padding: '5px 10px',
    backgroundColor: '#ff4d4d',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  },
  noTurnos: {
    textAlign: 'center' as const,
    fontSize: '1.1em',
    marginTop: '20px',
  },
  loading: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '100vh',
    fontSize: '1.2em',
    color: 'white',
    backgroundColor: 'rgba(0, 0, 0, 0.7)',
  },
  error: {
    display: 'flex',
    flexDirection: 'column' as const,
    justifyContent: 'center',
    alignItems: 'center',
    height: '100vh',
    fontSize: '1.2em',
    color: 'white',
    backgroundColor: 'rgba(0, 0, 0, 0.7)',
    textAlign: 'center' as const,
  },
  reloadButton: {
    marginTop: '20px',
    padding: '10px 20px',
    backgroundColor: '#4CAF50',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    fontSize: '1em',
  },
};

export default BarberDashboard;