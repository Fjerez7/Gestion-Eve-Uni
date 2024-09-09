# Gestion de Eventos de Uniciencia
### Proyecto de la materia de Programación Web

## Descripción

Esta es una aplicación web desarrollada en Spring Boot para gestionar eventos universitarios. 
Permite crear, gestionar y asistir a eventos universitarios.
Los usuarios pueden registrarse como estudiantes por defecto, mientras que los profesores tienen un flujo de registro diferente.
Además, el administrador del sistema puede asignar roles especiales como el de profesor.
Esta es la primera version del proyecto, por lo que se iran añadiendo nuevas funcionalidades y mejoras de refactorizacion de codigo en el futuro .

## Características

- Registro de usuarios.
- Sistema de roles: `ADMIN`, `STUDENT`, `TEACHER`.
- Creación y gestión de eventos universitarios.
- Autenticación por tokens.
- Almacenamiento de datos en una base de datos MySQL.
- Crud de todas la entidades.

## Requisitos previos

Asegúrate de tener las siguientes herramientas instaladas en tu máquina:

- Java 17+
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/installer/)
- [Git](https://git-scm.com/) (opcional, para clonar el repositorio)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (o cualquier otro IDE compatible con Spring Boot)

## Instalación

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/Fjerez7/Gestion-Eve-Uni.git