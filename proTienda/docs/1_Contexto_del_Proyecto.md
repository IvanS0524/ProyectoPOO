# PROYECTO FINAL - PROGRAMACIÓN ORIENTADA A OBJETOS
## Sistema de Gestión de Inventario para Tienda Minorista

---

### INFORMACIÓN DEL PROYECTO

**Institución:** Universidad del Norte  
**Asignatura:** Programación Orientada a Objetos  
**Fecha de entrega:** Diciembre 2025

**Integrantes del equipo:**
- Iván Sierra Arrieta (0222420035)
- Carlos Romero Paternina (0222420028)
- Salomón Restrepo Güette (0222410050)

---

## 1. CONTEXTO Y PROBLEMA A RESOLVER

### 1.1 Descripción del Problema

Las tiendas minoristas pequeñas y medianas enfrentan desafíos significativos en la gestión manual de su inventario, ventas y compras. La falta de un sistema automatizado genera:

- **Pérdida de información** sobre productos, clientes y proveedores
- **Errores en el control de stock** que resultan en faltantes o excesos de inventario
- **Dificultad para rastrear transacciones** comerciales (compras y ventas)
- **Imposibilidad de generar reportes** y análisis de operaciones
- **Pérdida de datos** al no existir persistencia de información

### 1.2 Solución Propuesta

Se desarrolló un **Sistema de Gestión de Inventario** que permite a los propietarios de tiendas minoristas:

1. **Gestionar Productos:** Registrar, modificar, eliminar y consultar productos con información de precios y stock
2. **Gestionar Clientes:** Mantener un registro de clientes con sus datos de contacto
3. **Gestionar Proveedores:** Administrar información de proveedores de mercancía
4. **Procesar Transacciones:** 
   - Registrar compras a proveedores (incrementan el inventario)
   - Registrar ventas a clientes (decrementan el inventario)
   - Implementar carritos de compra/venta para operaciones con múltiples productos
5. **Persistencia de Datos:** Guardar y recuperar toda la información en archivos binarios
6. **Interfaz Gráfica Intuitiva:** Utilizar Swing de Java para una experiencia de usuario amigable

---

## 2. OBJETIVOS DEL PROYECTO

### 2.1 Objetivo General

Desarrollar un sistema de gestión de inventario robusto y funcional que aplique los principios de Programación Orientada a Objetos, utilizando persistencia de datos mediante archivos y una interfaz gráfica construida con Swing.

### 2.2 Objetivos Específicos

1. Implementar una arquitectura orientada a objetos que siga los principios SOLID
2. Desarrollar un sistema de persistencia de datos utilizando serialización de objetos
3. Crear una interfaz gráfica de usuario intuitiva usando el paquete Swing de Java
4. Implementar validaciones de datos para garantizar la integridad de la información
5. Desarrollar funcionalidades de carrito de compras/ventas para mejorar la experiencia de usuario
6. Generar comprobantes de transacciones para llevar registro de operaciones
7. Documentar el código y el proceso de desarrollo de manera profesional

---

## 3. ALCANCE DEL PROYECTO

### 3.1 Funcionalidades Incluidas

**Módulo de Productos:**
- Registro de nuevos productos (nombre, ID, precio de compra, precio de venta, stock inicial)
- Modificación de información de productos existentes
- Eliminación de productos
- Visualización de listado completo de productos
- Actualización automática de stock según transacciones

**Módulo de Clientes:**
- Registro de nuevos clientes (nombre, ID, teléfono)
- Modificación de información de clientes
- Eliminación de clientes
- Visualización de listado completo de clientes

**Módulo de Proveedores:**
- Registro de nuevos proveedores (nombre, ID, email)
- Modificación de información de proveedores
- Eliminación de proveedores
- Visualización de listado completo de proveedores

**Módulo de Transacciones:**
- **Compras:**
  - Carrito temporal para agregar múltiples productos de un mismo proveedor
  - Validación de proveedor único por transacción
  - Actualización automática de stock (incremento)
  - Generación de comprobante de compra
  
- **Ventas:**
  - Carrito temporal para agregar múltiples productos para un mismo cliente
  - Validación de cliente único por transacción
  - Validación de stock disponible
  - Actualización automática de stock (decremento)
  - Generación de comprobante de venta

- **Historial:**
  - Visualización de todas las transacciones realizadas
  - Información detallada de cada transacción (fecha, tipo, participante, total, productos)

**Módulo de Persistencia:**
- Guardado automático de datos en archivo binario
- Carga automática de datos al iniciar la aplicación
- Manejo de errores en operaciones de I/O

### 3.2 Funcionalidades NO Incluidas (Fuera del Alcance)

- Sistema de autenticación y usuarios múltiples
- Reportes estadísticos avanzados o gráficos
- Conexión a base de datos relacional
- Sincronización en la nube
- Sistema de facturación fiscal
- Integración con sistemas de pago

---

## 4. TECNOLOGÍAS UTILIZADAS

- **Lenguaje de Programación:** Java (JDK 8 o superior)
- **Interfaz Gráfica:** Swing (paquete javax.swing)
- **IDE de Desarrollo:** Apache NetBeans
- **Persistencia:** Serialización de objetos Java (archivos .bin)
- **Control de Versiones:** Git / GitHub
- **Documentación:** Markdown, PlantUML

---

## 5. REQUISITOS DEL SISTEMA

### 5.1 Requisitos de Software

- Java Runtime Environment (JRE) 8 o superior
- Sistema Operativo: Windows, Linux o macOS

### 5.2 Requisitos de Hardware

- Procesador: 1 GHz o superior
- Memoria RAM: 512 MB mínimo (1 GB recomendado)
- Espacio en Disco: 50 MB mínimo
- Resolución de Pantalla: 1024x768 o superior

---

## 6. JUSTIFICACIÓN DEL PROYECTO

Este proyecto aborda una necesidad real del sector comercial minorista y demuestra la aplicación práctica de conceptos fundamentales de Programación Orientada a Objetos:

1. **Relevancia Práctica:** El sistema resuelve problemas reales de negocios pequeños
2. **Aplicación de Conceptos POO:** Herencia, polimorfismo, encapsulamiento, abstracción
3. **Principios SOLID:** Código mantenible, escalable y profesional
4. **Persistencia de Datos:** Uso de archivos para guardar información de forma permanente
5. **Interfaz Gráfica:** Experiencia de usuario mejorada mediante Swing
6. **Validaciones y Manejo de Errores:** Sistema robusto que previene datos inconsistentes

---

## 7. METODOLOGÍA DE DESARROLLO

El proyecto se desarrolló siguiendo una metodología iterativa:

1. **Análisis de Requisitos:** Identificación de funcionalidades necesarias
2. **Diseño de Clases:** Creación del diagrama UML y estructura del sistema
3. **Implementación:** Desarrollo del código siguiendo principios SOLID
4. **Pruebas:** Validación de funcionalidades y manejo de errores
5. **Documentación:** Comentarios en código y documentos de soporte
6. **Refinamiento:** Mejoras en interfaz y experiencia de usuario

---

**Nota:** Este documento forma parte de la documentación oficial del proyecto y debe ser leído en conjunto con el documento de desarrollo y los archivos de código fuente.
