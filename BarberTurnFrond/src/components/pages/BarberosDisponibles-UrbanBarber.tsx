import React, { useState, useEffect } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';
import { Star, Scissors, ArrowLeft } from 'lucide-react';
import axiosInstance from '../../axiosConfig';

interface Barber {
  id: string;
  nombre: string;
  local: string;
  email?: string;
}

const BarberosDisponibles: React.FC = () => {
  const [barbers, setBarbers] = useState<Barber[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const { nombreBarberia } = useParams<{ nombreBarberia: string }>();
  const navigate = useNavigate();

  useEffect(() => {
    const fetchBarbers = async () => {
      try {
        const response = await axiosInstance.get<Barber[]>('/barberos');
        const decodedNombreBarberia = decodeURIComponent(nombreBarberia || '');
        const filteredBarbers = response.data.filter(barber => barber.local === decodedNombreBarberia);
        setBarbers(filteredBarbers);
        setLoading(false);
      } catch (err) {
        console.error('Error fetching barbers:', err);
        setError('Error al cargar los barberos. Por favor, intente nuevamente.');
        setLoading(false);
      }
    };

    fetchBarbers();
  }, [nombreBarberia]);

  const handleBarberSelect = (barber: Barber) => {
    localStorage.setItem('selectedBarberName', barber.nombre);
    localStorage.setItem('selectedBarberEmail', barber.email || '');
    localStorage.setItem('selectedBarberId', barber.id);
    navigate('/Galeria-Seleccionable');
  };

  if (loading) {
    return <div style={styles.loading}>Cargando barberos...</div>;
  }

  if (error) {
    return <div style={styles.error}>{error}</div>;
  }

  return (
    <div style={styles.container}>
      <Link to="/barberias-disponibles" style={styles.backButton}>
        <ArrowLeft size={24} color="white" />
      </Link>
      <div style={styles.content}>
        <h1 style={styles.title}>BarberTurn</h1>
        <h2 style={styles.subtitle}>Barberos de {decodeURIComponent(nombreBarberia || '')}</h2>
        {barbers.length === 0 ? (
          <div style={styles.noResults}>No se encontraron barberos en esta barbería.</div>
        ) : (
          <div style={styles.barberList}>
            {barbers.map((barber) => (
              <div
                key={barber.id}
                onClick={() => handleBarberSelect(barber)}
                style={styles.barberItem}
              >
                <div style={styles.profilePicture}>
                  <Scissors size={30} color="white" />
                </div>
                <div style={styles.barberInfo}>
                  <h3 style={styles.barberName}>{barber.nombre}</h3>
                </div>
              </div>
            ))}
          </div>
        )}
        <div style={styles.footer}>
          © 2024 BarberTurn. Todos los derechos reservados.
        </div>
      </div>
    </div>
  );
};

const styles = {
  container: {
    minHeight: '100vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundImage: `linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), url('https://hebbkx1anhila5yf.public.blob.vercel-storage.com/background-gallery-Q7o6O7FB8cgz1SLHAEc9d2u9QM5Lsr.jpg')`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
    position: 'relative' as const,
  },
  backButton: {
    position: 'absolute' as const,
    top: '20px',
    left: '20px',
    padding: '10px',
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
    borderRadius: '50%',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    cursor: 'pointer',
    transition: 'background-color 0.3s ease',
  },
  content: {
    width: '90%',
    maxWidth: '600px',
    padding: '20px',
    backgroundColor: 'rgba(0, 0, 0, 0.8)',
    borderRadius: '10px',
    boxShadow: '0 0 10px rgba(255,255,255,0.1)',
  },
  title: {
    fontSize: '2.5em',
    textAlign: 'center' as const,
    marginBottom: '10px',
    color: 'white',
  },
  subtitle: {
    fontSize: '1.5em',
    textAlign: 'center' as const,
    marginBottom: '20px',
    color: '#ccc',
  },
  barberList: {
    display: 'flex',
    flexDirection: 'column' as const,
    gap: '15px',
  },
  barberItem: {
    display: 'flex',
    alignItems: 'center',
    padding: '15px',
    backgroundColor: 'rgba(255, 255, 255, 0.1)',
    borderRadius: '8px',
    transition: 'all 0.3s ease',
    cursor: 'pointer',
  },
  profilePicture: {
    width: '60px',
    height: '60px',
    borderRadius: '50%',
    backgroundColor: '#444',
    marginRight: '15px',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  barberInfo: {
    flex: 1,
  },
  barberName: {
    fontSize: '1.2em',
    fontWeight: 'bold' as const,
    marginBottom: '5px',
    color: 'white',
  },
  footer: {
    marginTop: '30px',
    textAlign: 'center' as const,
    fontSize: '0.9em',
    color: '#ccc',
  },
  error: {
    color: 'red',
    textAlign: 'center' as const,
    fontSize: '1em',
    padding: '10px',
    marginBottom: '15px',
    backgroundColor: 'rgba(255, 0, 0, 0.1)',
    borderRadius: '5px',
  },
  noResults: {
    color: 'white',
    textAlign: 'center' as const,
    marginTop: '20px',
  },
  loading: {
    color: 'white',
    fontSize: '1.2em',
    textAlign: 'center' as const,
    padding: '20px',
  },
};

export default BarberosDisponibles;