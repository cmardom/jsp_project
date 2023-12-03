-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS info;

-- Seleccionar la base de datos para usar
USE info;

-- Crear una tabla con dos columnas: nombre y contrasena
CREATE TABLE IF NOT EXISTS usuario (
                                       nombre VARCHAR(255) UNIQUE,
                                       contrasena VARCHAR(255)
);

INSERT INTO usuario VALUES ('admin', 'admin');
