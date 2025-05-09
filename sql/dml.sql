USE soluciones_eficientes;

INSERT INTO cliente (id, nombre, representante, correo, telefono, direccion, sector)
VALUES (1, 'TecnoGlobal', 'Laura Martínez', 'laura@tecnoglobal.com', '3001234567', 'Calle 123, Bogotá', 'TECNOLOGIA'),
       (2, 'Clínica Vida', 'Carlos Ruiz', 'carlos@clinicavida.com', '3007654321', 'Carrera 45, Medellín', 'SALUD');

INSERT INTO servicio (id, nombre, descripcion, precioPorHora, categoria)
VALUES (1, 'Desarrollo de Software', 'Desarrollo de aplicaciones a medida', 120000, 'TI'),
       (2, 'Limpieza Industrial', 'Limpieza de instalaciones industriales', 30000, 'LIMPIEZA');

INSERT INTO empleado (id, nombre, cargo, salario, especialidad, idProyecto)
VALUES (1, 'Juan Pérez', 'Analista de Sistemas', 3000000, 'TI', NULL),
       (2, 'Marta Gómez', 'Supervisora', 1500000, 'LIMPIEZA', NULL);