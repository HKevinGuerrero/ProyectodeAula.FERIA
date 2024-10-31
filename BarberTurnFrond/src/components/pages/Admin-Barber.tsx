import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { api } from '../../axiosConfig';

interface Barber {
  id: string;
  nombre: string;
  especialidad: string;
  local: string;
}

interface Turno {
  id: string;
  cliente: string;
  fecha: string;
  hora: string;
  estado: 'pendiente' | 'completado' | 'cancelado';
  emailBarbero: string;
  local: string;
}

interface UserData {
  id: string;
  correo: string;
  nombre: string;
  apellido: string;
  local: string;
}

const AdminBarber: React.FC = () => {
  const [barbers, setBarbers] = useState<Barber[]>([]);
  const [turnos, setTurnos] = useState<Turno[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [userData, setUserData] = useState<UserData | null>(null);
  const [showCompleted, setShowCompleted] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const storedUserData = localStorage.getItem('user');
    if (!storedUserData) {
      setError('No se encontró información de usuario. Por favor, inicia sesión nuevamente.');
      setLoading(false);
      return;
    }

    try {
      const parsedUserData: UserData = JSON.parse(storedUserData);
      setUserData(parsedUserData);
      fetchData(parsedUserData);
    } catch (error) {
      console.error('Error al parsear los datos del usuario:', error);
      setError('Error al cargar los datos del usuario. Por favor, inicia sesión nuevamente.');
      setLoading(false);
    }
  }, []);

  const fetchData = async (userData: UserData) => {
    try {
      const [barbersResponse, turnosResponse] = await Promise.all([
        api.get('/barberos'),
        api.get('/turno')
      ]);

      const filteredBarbers = barbersResponse.data.filter(
        (barber: Barber) => barber.local.toLowerCase() === userData.local.toLowerCase()
      );
      setBarbers(filteredBarbers);

      const filteredTurnos = turnosResponse.data.filter(
        (turno: Turno) => turno.local.toLowerCase() === userData.local.toLowerCase()
      );
      setTurnos(filteredTurnos);

      setLoading(false);
    } catch (err) {
      console.error('Error al obtener datos:', err);
      setError('Error al cargar los datos. Por favor, intenta de nuevo.');
      setLoading(false);
    }
  };

  const handleTicketTurnosClick = () => {
    navigate('/ticket-turnos');
  };

  const handleLogout = () => {
    localStorage.removeItem('user');
    navigate('/iniciar-sesion-barberia'); // Ajusta la ruta según tu estructura de rutas
  };

  const toggleCompletedTurnos = () => {
    setShowCompleted(!showCompleted);
  };

  if (loading) return <div style={styles.loading}>Cargando...</div>;
  if (error) return <div style={styles.error}>{error}</div>;
  if (!userData) return <div style={styles.error}>No se pudo cargar la información del usuario.</div>;

  const pendingTurnos = turnos.filter(turno => turno.estado === 'pendiente');
  const completedTurnos = turnos.filter(turno => turno.estado === 'completado');

  return (
    <div style={styles.container}>
      <button onClick={handleLogout} style={styles.logoutButton}>
        Cerrar Sesión
      </button>
      
      <div style={styles.panel}>
        <h1 style={styles.title}>Panel de Administración - {userData.local}</h1>

        <section style={styles.section}>
          <h2 style={styles.sectionTitle}>Barberos</h2>
          <ul style={styles.list}>
            {barbers.map(barber => (
              <li key={barber.id} style={styles.listItem}>
                {barber.nombre} - {barber.especialidad}
              </li>
            ))}
          </ul>
        </section>

        <section style={styles.section}>
          <h2 style={styles.sectionTitle}>Turnos</h2>
          <div style={styles.columns}>
            <div style={styles.column}>
              <h3 style={styles.columnTitle}>Pendientes</h3>
              <ul style={styles.list}>
                {pendingTurnos.map(turno => (
                  <li key={turno.id} style={styles.listItem}>
                    <div>Hora: {turno.hora}</div>
                    <div>Cliente: {turno.cliente}</div>
                    <div>Barbero: {turno.emailBarbero}</div>
                  </li>
                ))}
              </ul>
            </div>
            <div style={styles.column}>
              <h3 style={styles.columnTitle} onClick={toggleCompletedTurnos}>
                Completados {showCompleted ? '▲' : '▼'}
              </h3>
              {showCompleted && (
                <ul style={styles.list}>
                  {completedTurnos.map(turno => (
                    <li key={turno.id} style={styles.listItem}>
                      <div>Fecha: {turno.fecha}</div>
                      <div>Hora: {turno.hora}</div>
                      <div>Cliente: {turno.cliente}</div>
                      <div>Barbero: {turno.emailBarbero}</div>
                    </li>
                  ))}
                </ul>
              )}
            </div>
          </div>
        </section>

        <button onClick={handleTicketTurnosClick} style={styles.button}>
          Ir a Ticket-Turnos
        </button>
      </div>
    </div>
  );
};

const styles = {
  container: {
    backgroundImage: 'url("/assets/imgs/background-gallery.jpg")',
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
    minHeight: '100vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    padding: '20px',
    position: 'relative' as const,
  },
  logoutButton: {
    position: 'absolute' as const,
    top: '20px',
    right: '20px',
    backgroundColor: '#FF4C4C',
    color: 'white',
    border: 'none',
    padding: '10px 20px',
    fontSize: '14px',
    cursor: 'pointer',
    borderRadius: '4px',
  },
  panel: {
    backgroundColor: 'rgba(255, 255, 255, 0.9)',
    borderRadius: '8px',
    padding: '20px',
    maxWidth: '800px',
    width: '100%',
    boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
  },
  title: {
    fontSize: '24px',
    fontWeight: 'bold' as const,
    marginBottom: '20px',
    textAlign: 'center' as const,
    color: '#333',
  },
  section: {
    marginBottom: '30px',
  },
  sectionTitle: {
    fontSize: '20px',
    fontWeight: 'bold' as const,
    marginBottom: '10px',
    color: '#444',
  },
  list: {
    listStyleType: 'none',
    padding: 0,
  },
  listItem: {
    padding: '8px 0',
    borderBottom: '1px solid #eee',
  },
  columns: {
    display: 'flex',
    justifyContent: 'space-between',
  },
  column: {
    flex: 1,
    margin: '0 10px',
  },
  columnTitle: {
    fontSize: '18px',
    fontWeight: 'bold' as const,
    marginBottom: '10px',
    color: '#555',
    cursor: 'pointer',
  },
  loading: {
    textAlign: 'center' as const,
    padding: '20px',
    color: '#333',
  },
  error: {
    color: 'red',
    textAlign: 'center' as const,
    padding: '20px',
    backgroundColor: 'rgba(255, 255, 255, 0.9)',
    borderRadius: '8px',
    margin: '20px',
  },
  button: {
    backgroundColor: '#4CAF50',
    border: 'none',
    color: 'white',
    padding: '15px 32px',
    textAlign: 'center' as const,
    textDecoration: 'none',
    display: 'inline-block',
    fontSize: '16px',
    margin: '4px 2px',
    cursor: 'pointer',
    borderRadius: '4px',
  },
};

export default AdminBarber;
