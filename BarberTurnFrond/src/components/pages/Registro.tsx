import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { api } from '../../axiosConfig';

interface FormData {
  nombre: string;
  apellido: string;
  telefono: string;
  email: string;
  local?: string;
  rol: 'barbero' | 'cliente' | '';
}

export default function Registro() {
  const [formData, setFormData] = useState<FormData>({
    nombre: '',
    apellido: '',
    telefono: '',
    email: '',
    local: '',
    rol: '',
  });
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleRolSelect = (rol: 'barbero' | 'cliente') => {
    setFormData(prevState => ({
      ...prevState,
      rol: rol,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    if (!formData.rol) {
      setError('Por favor, seleccione un tipo de registro');
      return;
    }

    try {
      let response;
      const dataToSend = {
        nombre: formData.nombre,
        apellido: formData.apellido,
        telefono: formData.telefono,
        email: formData.email,
        rol: formData.rol, // Añadimos el rol a los datos que se envían
        ...(formData.rol === 'barbero' && { local: formData.local }),
      };

      if (formData.rol === 'barbero') {
        response = await api.post('/barberos/post', dataToSend);
      } else {
        response = await api.post('/cliente/post', dataToSend);
      }

      // Asumiendo que el ID se devuelve en la respuesta como 'id'
      const userId = response.data.id;

      // Guardar el rol y el ID en localStorage
      localStorage.setItem('userId', userId);
      localStorage.setItem('rol', formData.rol);

      // Guardar toda la información del formulario en localStorage
      localStorage.setItem('registroTemporal', JSON.stringify({
        ...formData,
        id: userId,
      }));

      // Redirigir a la siguiente vista
      navigate('/Registro-Credenciales');
    } catch (err) {
      console.error('Error al guardar los datos:', err);
      if (err.response) {
        console.error('Error data:', err.response.data);
        console.error('Error status:', err.response.status);
        console.error('Error headers:', err.response.headers);
        setError(`Error del servidor: ${err.response.status}`);
      } else if (err.request) {
        console.error('Error request:', err.request);
        setError('No se recibió respuesta del servidor');
      } else {
        console.error('Error message:', err.message);
        setError('Error al configurar la solicitud');
      }
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.formContainer}>
        <h1 style={styles.title}>BarberTurn</h1>
        <h2 style={styles.subtitle}>Registrarse</h2>
        <form onSubmit={handleSubmit} style={styles.form}>
          <div style={styles.formGroup}>
            <label style={styles.label}>Tipo de Registro</label>
            <div style={styles.buttonGroup}>
              <button
                type="button"
                style={formData.rol === 'barbero' ? styles.activeButton : styles.button}
                onClick={() => handleRolSelect('barbero')}
              >
                Barbero
              </button>
              <button
                type="button"
                style={formData.rol === 'cliente' ? styles.activeButton : styles.button}
                onClick={() => handleRolSelect('cliente')}
              >
                Cliente
              </button>
            </div>
          </div>
          <input
            type="text"
            name="nombre"
            placeholder="Nombre"
            required
            style={styles.input}
            onChange={handleInputChange}
          />
          <input
            type="text"
            name="apellido"
            placeholder="Apellido"
            required
            style={styles.input}
            onChange={handleInputChange}
          />
          <input
            type="tel"
            name="telefono"
            placeholder="Teléfono"
            required
            style={styles.input}
            onChange={handleInputChange}
          />
          <input
            type="email"
            name="email"
            placeholder="Correo electrónico"
            required
            style={styles.input}
            onChange={handleInputChange}
          />
          {formData.rol === 'barbero' && (
            <input
              type="text"
              name="local"
              placeholder="Local"
              required
              style={styles.input}
              onChange={handleInputChange}
            />
          )}
          <button type="submit" style={styles.submitButton}>
            Continuar con el registro
          </button>
        </form>
        {error && <p style={styles.error}>{error}</p>}
        <p style={styles.loginLink}>
          ¿Ya tienes una cuenta?{' '}
          <Link to="/iniciar-sesion" style={styles.link}>
            Iniciar sesión
          </Link>
        </p>
        <div style={styles.footer}>
          © 2024 BarberTurn. Todos los derechos reservados.
        </div>
      </div>
    </div>
  );
}

const styles = {
  container: {
    minHeight: '100vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundImage: `url('https://hebbkx1anhila5yf.public.blob.vercel-storage.com/background-gallery-tVsfhFLAU6Jg8Wx0HZ0WN8YsxgZbMP.jpg')`,
    backgroundSize: 'cover',
  },
  formContainer: {
    width: '400px',
    padding: '40px',
    backgroundColor: 'rgba(0, 0, 0, 0.7)',
    borderRadius: '10px',
    color: 'white',
  },
  title: {
    fontSize: '2.5em',
    textAlign: 'center' as const,
    marginBottom: '10px',
  },
  subtitle: {
    fontSize: '1.5em',
    textAlign: 'center' as const,
    marginBottom: '20px',
  },
  form: {
    display: 'flex',
    flexDirection: 'column' as const,
    gap: '15px',
  },
  formGroup: {
    display: 'flex',
    flexDirection: 'column' as const,
    gap: '5px',
  },
  label: {
    fontSize: '0.9em',
  },
  buttonGroup: {
    display: 'flex',
    gap: '10px',
  },
  button: {
    flex: 1,
    padding: '10px',
    border: 'none',
    borderRadius: '5px',
    background: 'rgba(255, 255, 255, 0.1)',
    color: 'white',
    cursor: 'pointer',
  },
  activeButton: {
    flex: 1,
    padding: '10px',
    border: 'none',
    borderRadius: '5px',
    background: 'white',
    color: 'black',
    cursor: 'pointer',
  },
  input: {
    padding: '10px',
    borderRadius: '5px',
    border: 'none',
    background: 'rgba(255, 255, 255, 0.1)',
    color: 'white',
  },
  submitButton: {
    padding: '10px',
    borderRadius: '5px',
    border: 'none',
    background: 'white',
    color: 'black',
    cursor: 'pointer',
    fontWeight: 'bold' as const,
  },
  error: {
    color: 'red',
    textAlign: 'center' as const,
    marginTop: '10px',
  },
  loginLink: {
    textAlign: 'center' as const,
    marginTop: '20px',
  },
  link: {
    color: '#3498db',
    textDecoration: 'none',
  },
  footer: {
    marginTop: '20px',
    fontSize: '0.8em',
    textAlign: 'center' as const,
  },
};