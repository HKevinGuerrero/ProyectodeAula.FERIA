# BarberTurn
**BarberTurn** es una aplicación de gestión de turnos para barberías que permite a los usuarios (clientes) reservar citas a diferentes locales con multiples barberos vinculados a la aplicacion. Este sistema implementa autenticación con JWT (Aún en proceso) y maneja diferentes roles de usuario (cliente, barbero y admin).

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Tecnologías](#tecnologías)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contribuciones](#contribuciones)

## Descripción

BarberTurn facilita la gestión de turnos para barberías, proporcionando una interfaz fácil de usar tanto para los barberos como para los clientes. Los Barberos y clientes pueden crear su usuario, los barberos se vinculan a su local contratado para trabajar, mientras que los clientes pueden reservar sus citas en función de la disponibilidad del barbero y las barberias.

## Características

- **Autenticación JWT**: Proporciona seguridad y manejo de roles de usuario (cliente, barbero, admin). (Aún en proceso)
- **Gestión de barberos y clientes**: Los clientes y barberos pueden crear su propio perfil e ingresar a su dashboard correspondiente.
- **Reserva de turnos**: Los clientes pueden reservar turnos en función de la disponibilidad de barberos y locales.
- **Notificaciones por email**: Los usuarios reciben notificaciones por correo electrónico confirmando sus turnos y recordando hora del turno.
- **CRUD completo**: Soporte para operaciones de creación, lectura, actualización y eliminación para todas las entidades del sistema (clientes, barberos, turnos, etc.).

## Tecnologías

- **Backend**: Java, Spring Boot, Spring Security (JWT (Aún en proceso)).
- **Frontend**: React, JavaScript, CSS.
- **Base de datos**: PostgreSQL.
- **Control de versiones**: Git, GitHub.

## Instalación

Sigue estos pasos para ejecutar el proyecto localmente:

1. Clona el repositorio:

   \`\`\`bash
   git clone https://github.com/HKevinGuerrero/ProyectodeAula.FERIA.git
   \`\`\`

2. Navega al directorio del proyecto:

   \`\`\`bash
   cd ProyectodeAula.FERIA
   \`\`\`

3. Instala las dependencias y configura el entorno de desarrollo. Asegúrate de tener [Java](https://www.java.com/) y [Maven](https://maven.apache.org/) instalados:

   \`\`\`bash
   mvn clean install
   \`\`\`

4. Configura la base de datos PostgreSQL y actualiza el archivo \`application.properties\` con tus credenciales.

5. Ejecuta el proyecto:

   \`\`\`bash
   mvn spring-boot:run
   \`\`\`

## Uso

### Endpoints principales

- **POST /auth/register**: Registrar nuevos usuarios (clientes).
- **POST /auth/login**: Autenticarse y obtener un JWT (Aún en proceso).
- **GET /turnos**: Ver turnos disponibles (clientes autenticados).
- **POST /turnos**: Reservar un turno (clientes).
- **Admin**: (En planeacion).

### Roles de usuario

1. **Cliente**: Puede registrarse, iniciar sesión y reservar turnos.
2. **Barbero**: Puede registrarse conociendo ID del local el cual lo contrato, iniciar sesión, ver turnos asignados, confirmar y cancelar turno.
3. **Admin**: (En planeacion).

## Contribuciones

1. Kevin Jose Guerrero Hincapie.
2. Daniel Eduardo Barrios. 
3. Ricardo Arango.
4. Derek Mendoza Chica.
5. 
