-- =====================================================
-- BASE DE DATOS: Almacenes Libertad
-- =====================================================

DROP DATABASE IF EXISTS almacenes_libertad;
CREATE DATABASE almacenes_libertad;
USE almacenes_libertad;

-- =====================================================
-- 1. TABLA: TIPO DE MOVIMIENTO
-- =====================================================
CREATE TABLE tipo_movimiento (
    id_tipo_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO tipo_movimiento (nombre) VALUES
('ENTRADA'),
('SALIDA'),
('TRASLADO');

-- =====================================================
-- 2. TABLAS MAESTRAS
-- =====================================================

-- PRODUCTOS
CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio_compra DECIMAL(10,2),
    precio_venta DECIMAL(10,2),
    estado TINYINT DEFAULT 1,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- ALMACENES
CREATE TABLE almacenes (
    id_almacen INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    tipo ENUM('Central', 'Sucursal') NOT NULL,
    estado TINYINT DEFAULT 1,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- EMPLEADOS
CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cargo VARCHAR(50),
    estado TINYINT DEFAULT 1,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- PROVEEDORES
CREATE TABLE proveedores (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    ubicacion VARCHAR(200),
    representante VARCHAR(100),
    estado TINYINT DEFAULT 1,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- 3. TABLA CENTRAL: MOVIMIENTOS (KARDEX)
-- =====================================================
CREATE TABLE movimientos (
    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_movimiento INT NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    id_almacen_origen INT NULL,
    id_almacen_destino INT NULL,
    id_empleado INT NOT NULL,
    id_proveedor INT NULL,
    referencia VARCHAR(100),

    FOREIGN KEY (id_tipo_movimiento) REFERENCES tipo_movimiento(id_tipo_movimiento),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    FOREIGN KEY (id_almacen_origen) REFERENCES almacenes(id_almacen),
    FOREIGN KEY (id_almacen_destino) REFERENCES almacenes(id_almacen),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

-- =====================================================
-- 4. ÍNDICES RECOMENDADOS (performance API)
-- =====================================================
CREATE INDEX idx_mov_producto ON movimientos(id_producto);
CREATE INDEX idx_mov_fecha ON movimientos(fecha);
CREATE INDEX idx_mov_origen ON movimientos(id_almacen_origen);
CREATE INDEX idx_mov_destino ON movimientos(id_almacen_destino);
CREATE INDEX idx_mov_tipo ON movimientos(id_tipo_movimiento);

-- =====================================================
-- 5. VISTA: STOCK ACTUAL POR PRODUCTO Y ALMACÉN
-- =====================================================
CREATE VIEW vw_stock_actual AS
SELECT
    p.id_producto,
    p.nombre AS producto,
    a.id_almacen,
    a.nombre AS almacen,
    SUM(
        CASE
            WHEN tm.nombre = 'ENTRADA' AND m.id_almacen_destino = a.id_almacen THEN m.cantidad
            WHEN tm.nombre = 'SALIDA' AND m.id_almacen_origen = a.id_almacen THEN -m.cantidad
            WHEN tm.nombre = 'TRASLADO' AND m.id_almacen_destino = a.id_almacen THEN m.cantidad
            WHEN tm.nombre = 'TRASLADO' AND m.id_almacen_origen = a.id_almacen THEN -m.cantidad
            ELSE 0
        END
    ) AS stock_actual
FROM movimientos m
JOIN tipo_movimiento tm ON m.id_tipo_movimiento = tm.id_tipo_movimiento
JOIN productos p ON m.id_producto = p.id_producto
JOIN almacenes a 
    ON a.id_almacen = m.id_almacen_origen 
    OR a.id_almacen = m.id_almacen_destino
GROUP BY p.id_producto, a.id_almacen;

-- =====================================================
-- FIN DEL SCRIPT
-- =====================================================

USE almacenes_libertad;

-- =====================================================
-- 1. PRODUCTOS (5)
-- =====================================================
INSERT INTO productos (nombre, descripcion, precio_compra, precio_venta) VALUES
('Laptop Lenovo ThinkPad', 'Intel i5, 16GB RAM, 512GB SSD', 2800, 3600),
('Laptop HP Pavilion', 'Intel i7, 16GB RAM, 1TB SSD', 3200, 4100),
('Memoria USB 64GB', 'USB 3.1 Alta velocidad', 30, 55),
('Disco SSD 1TB', 'SSD NVMe 1TB', 140, 220),
('Mouse Inalámbrico Logitech', 'Mouse ergonómico inalámbrico', 65, 110);

-- =====================================================
-- 2. ALMACENES (5)
-- =====================================================
INSERT INTO almacenes (nombre, direccion, tipo) VALUES
('Almacén Central', 'Av. Central 123 - Lima', 'Central'),
('Sucursal Norte', 'Av. Universitaria 456 - Lima', 'Sucursal'),
('Sucursal Sur', 'Av. Los Próceres 789 - Lima', 'Sucursal'),
('Sucursal Este', 'Av. Aviación 321 - Lima', 'Sucursal'),
('Sucursal Oeste', 'Av. La Marina 654 - Lima', 'Sucursal');

-- =====================================================
-- 3. EMPLEADOS (5)
-- =====================================================
INSERT INTO empleados (nombre, cargo) VALUES
('Juan Pérez', 'Jefe de Almacén'),
('María López', 'Auxiliar de Inventario'),
('Carlos Ramírez', 'Encargado de Traslados'),
('Ana Torres', 'Asistente Logístico'),
('Luis Fernández', 'Supervisor de Compras');

-- =====================================================
-- 4. PROVEEDORES (5)
-- =====================================================
INSERT INTO proveedores (nombre, contacto, ubicacion, representante) VALUES
('TechWorld SAC', 'ventas@techworld.pe', 'Lima', 'Carlos Méndez'),
('CompuGlobal', 'contacto@compuglobal.pe', 'Lima', 'María Ruiz'),
('InnovaTech', 'ventas@innovatech.pe', 'Lima', 'Luis Soto'),
('MegaBytes Perú', 'info@megabytes.pe', 'Lima', 'Paola Ramos'),
('DataLine SAC', 'soporte@dataline.pe', 'Lima', 'Ricardo Vega');

-- =====================================================
-- 5. MOVIMIENTOS (KARDEX)
-- =====================================================

-- ENTRADAS AL ALMACÉN CENTRAL
INSERT INTO movimientos (
    id_tipo_movimiento, id_producto, cantidad,
    id_almacen_destino, id_empleado, id_proveedor, referencia
) VALUES
(1, 1, 10, 1, 5, 1, 'Compra inicial Lenovo'),
(1, 2, 8, 1, 5, 2, 'Compra HP Pavilion'),
(1, 3, 50, 1, 5, 3, 'Compra memorias USB'),
(1, 4, 20, 1, 5, 4, 'Compra SSD 1TB'),
(1, 5, 30, 1, 5, 5, 'Compra mouse Logitech');

-- TRASLADOS A SUCURSALES
INSERT INTO movimientos (
    id_tipo_movimiento, id_producto, cantidad,
    id_almacen_origen, id_almacen_destino, id_empleado, referencia
) VALUES
(3, 1, 3, 1, 2, 3, 'Abastecimiento Sucursal Norte'),
(3, 2, 2, 1, 3, 3, 'Abastecimiento Sucursal Sur'),
(3, 3, 15, 1, 4, 3, 'Abastecimiento Sucursal Este'),
(3, 4, 5, 1, 5, 3, 'Abastecimiento Sucursal Oeste');

-- SALIDAS (VENTAS)
INSERT INTO movimientos (
    id_tipo_movimiento, id_producto, cantidad,
    id_almacen_origen, id_empleado, referencia
) VALUES
(2, 1, 1, 2, 4, 'Venta cliente final'),
(2, 3, 5, 4, 4, 'Venta memorias USB'),
(2, 5, 2, 5, 4, 'Venta mouse Logitech');

-- =====================================================
-- CONSULTAS BÁSICAS
-- =====================================================
select * from almacenes;
select * from empleados;
select * from movimientos;
select * from productos;
select * from proveedores;
select * from tipo_movimiento;
-- Consultar Stock
SELECT * FROM vw_stock_actual;
-- Consultar Kardex
SELECT * FROM movimientos
WHERE id_producto = 1
ORDER BY fecha;
-- consultar Movimientos
SELECT * FROM movimientos
WHERE id_almacen_origen = 1 OR id_almacen_destino = 1
ORDER BY fecha;

