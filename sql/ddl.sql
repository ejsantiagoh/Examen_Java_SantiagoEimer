CREATE DATABASE soluciones_eficientes;
USE soluciones_eficientes;

CREATE TABLE cliente (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    representante VARCHAR(100),
    correo VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    sector VARCHAR(50)
);

CREATE TABLE servicio (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    precioPorHora INT,
    categoria VARCHAR(50)
);

CREATE TABLE contrato (
    id INT PRIMARY KEY,
    idCliente INT,
    idServicio INT,
    fechaInicio DATE,
    fechaFin DATE,
    costoTotal INT,
    estado VARCHAR(50),
    horasTrabajadas INT,
    FOREIGN KEY (idCliente) REFERENCES cliente(id),
    FOREIGN KEY (idServicio) REFERENCES servicio(id)
);

CREATE TABLE proyecto (
    id INT PRIMARY KEY,
    idCliente INT,
    nombre VARCHAR(100),
    fechaInicio DATE,
    fechaFin DATE,
    estado VARCHAR(50),
    FOREIGN KEY (idCliente) REFERENCES cliente(id)
);

CREATE TABLE empleado (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    cargo VARCHAR(100),
    salario INT,
    especialidad VARCHAR(50),
    idProyecto INT,
    FOREIGN KEY (idProyecto) REFERENCES proyecto(id)
);

CREATE TABLE asignacion (
    idEmpleado INT,
    idProyecto INT,
    horasTrabajadas INT,
    fechaAsignacion DATE,
    PRIMARY KEY (idEmpleado, idProyecto, fechaAsignacion),
    FOREIGN KEY (idEmpleado) REFERENCES empleado(id),
    FOREIGN KEY (idProyecto) REFERENCES proyecto(id)
);