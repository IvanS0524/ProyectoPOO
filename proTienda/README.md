# Sistema de Gestión de Inventario - Tienda Minorista

![Java](https://img.shields.io/badge/Java-8%2B-orange)
![Swing](https://img.shields.io/badge/GUI-Swing-blue)
![License](https://img.shields.io/badge/License-Educational-green)

## 📋 Descripción

Sistema completo de gestión de inventario desarrollado en Java que permite a tiendas minoristas controlar productos, clientes, proveedores y transacciones comerciales. Implementa principios SOLID, utiliza persistencia mediante archivos binarios y cuenta con una interfaz gráfica construida con Swing.

## 👥 Equipo de Desarrollo

- **Iván Sierra Arrieta** - 0222420035
- **Carlos Romero Paternina** - 0222420028
- **Salomón Restrepo Güette** - 0222410050

**Universidad del Norte**  
**Asignatura:** Programación Orientada a Objetos  
**Período:** Diciembre 2025

## ✨ Características Principales

### Gestión de Inventario
- ✅ Registro, modificación y eliminación de productos
- ✅ Control automático de stock
- ✅ Precios de compra y venta diferenciados
- ✅ Validaciones de datos robustas

### Gestión de Participantes
- ✅ Base de datos de clientes con información de contacto
- ✅ Registro de proveedores con datos empresariales
- ✅ Operaciones CRUD completas

### Transacciones Comerciales
- ✅ **Compras a proveedores:** Carrito temporal, incremento de stock, comprobantes
- ✅ **Ventas a clientes:** Carrito temporal, decremento de stock, validación de disponibilidad
- ✅ Historial completo de transacciones
- ✅ Generación automática de comprobantes

### Persistencia de Datos
- ✅ Guardado automático en archivos binarios
- ✅ Carga automática al iniciar la aplicación
- ✅ Datos persistentes entre sesiones
- ✅ Manejo robusto de errores de I/O

### Interfaz Gráfica
- ✅ Interfaz intuitiva desarrollada con Swing
- ✅ Organización por pestañas (JTabbedPane)
- ✅ Tablas para visualización de datos
- ✅ Formularios de entrada validados

## 🏗️ Arquitectura del Sistema

### Arquitectura en Capas

```
┌─────────────────────────────────────┐
│   CAPA DE PRESENTACIÓN              │
│   vista/MiTienda.java               │
│   (Interfaz gráfica con Swing)      │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│   CAPA DE LÓGICA DE NEGOCIO         │
│   logica/                           │
│   - Tienda                          │
│   - Entidad (Producto, Cliente...)  │
│   - Transaccion (TCompra, TVenta)   │
│   - Detalle (DetalleCompra/Venta)   │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│   CAPA DE PERSISTENCIA              │
│   persistencia/Archivo.java         │
│   Interfaz/IArchivo.java            │
└─────────────────────────────────────┘
```

### Paquetes del Sistema

| Paquete | Descripción |
|---------|-------------|
| `logica` | Clases de dominio y lógica de negocio |
| `vista` | Interfaz gráfica de usuario (Swing) |
| `Interfaz` | Interfaces que definen contratos |
| `persistencia` | Implementación de persistencia en archivos |
| `exceptions` | Excepciones personalizadas |

## 🎨 Diagrama de Clases

El diagrama de clases completo se encuentra en [`docs/DiagramaClases.puml`](docs/DiagramaClases.puml) y puede visualizarse usando PlantUML.

### Jerarquías Principales

```
Entidad (abstracta)
├── Producto
├── Cliente
└── Proveedor

Transaccion (abstracta)
├── TCompra
└── TVenta

Detalle (abstracta)
├── DetalleCompra
└── DetalleVenta
```

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 8 o superior)
- **Interfaz Gráfica:** Swing (javax.swing)
- **IDE:** Apache NetBeans
- **Persistencia:** Serialización de objetos Java
- **Control de Versiones:** Git
- **Documentación:** Markdown, PlantUML

## 📦 Requisitos del Sistema

### Software
- Java Runtime Environment (JRE) 8 o superior
- Sistema Operativo: Windows, Linux o macOS

### Hardware
- Procesador: 1 GHz o superior
- RAM: 512 MB mínimo (1 GB recomendado)
- Espacio en Disco: 50 MB mínimo
- Resolución: 1024x768 o superior

## 🚀 Instalación y Ejecución

### Opción 1: Ejecutar el JAR (Recomendado)

1. Asegúrate de tener Java instalado:
   ```bash
   java -version
   ```

2. Descarga el archivo `proTienda.jar` de la carpeta `dist/`

3. Ejecuta el archivo:
   ```bash
   java -jar proTienda.jar
   ```

   O simplemente haz doble clic en el archivo JAR

### Opción 2: Compilar desde el Código Fuente

1. Clona el repositorio:
   ```bash
   git clone https://github.com/IvanS0524/ProyectoPOO.git
   cd ProyectoPOO/proTienda
   ```

2. Compila el proyecto con NetBeans:
   - Abre el proyecto en NetBeans
   - Clic derecho en el proyecto → Clean and Build
   - El JAR se generará en `dist/proTienda.jar`

3. O compila desde línea de comandos:
   ```bash
   # Compilar
   javac -d build/classes src/**/*.java
   
   # Crear JAR
   jar cvfm dist/proTienda.jar manifest.mf -C build/classes .
   
   # Ejecutar
   java -jar dist/proTienda.jar
   ```

## 📚 Estructura del Proyecto

```
proTienda/
├── src/                          # Código fuente
│   ├── exceptions/               # Excepciones personalizadas
│   │   └── IlegalValueException.java
│   ├── Interfaz/                 # Interfaces del sistema
│   │   ├── IArchivo.java
│   │   └── ITransaccion.java
│   ├── logica/                   # Lógica de negocio
│   │   ├── Cliente.java
│   │   ├── Detalle.java
│   │   ├── DetalleCompra.java
│   │   ├── DetalleVenta.java
│   │   ├── Entidad.java
│   │   ├── Producto.java
│   │   ├── Proveedor.java
│   │   ├── TCompra.java
│   │   ├── Tienda.java
│   │   ├── Transaccion.java
│   │   └── TVenta.java
│   ├── persistencia/             # Capa de persistencia
│   │   └── Archivo.java
│   └── vista/                    # Interfaz gráfica
│       ├── MiTienda.java
│       └── MiTienda.form
├── docs/                         # Documentación
│   ├── 1_Contexto_del_Proyecto.md
│   ├── 2_Desarrollo_del_Proyecto.md
│   ├── DiagramaClases.puml
│   └── Presentacion.md
├── build/                        # Archivos compilados
├── dist/                         # Ejecutable JAR
│   └── proTienda.jar
├── nbproject/                    # Configuración NetBeans
├── build.xml                     # Script de construcción Ant
├── manifest.mf                   # Manifiesto del JAR
├── tienda.bin                    # Archivo de datos (generado en ejecución)
└── README.md                     # Este archivo
```

## 📖 Manual de Usuario

### Primer Uso

1. Al iniciar por primera vez, verás un mensaje indicando que no hay archivo previo
2. Se creará una tienda vacía automáticamente
3. Comienza registrando productos, clientes y proveedores

### Flujo de Trabajo Típico

#### 1. Configuración Inicial
- Registrar productos del inventario
- Registrar clientes frecuentes
- Registrar proveedores con los que trabajas

#### 2. Realizar Compras
1. Ve a la pestaña "Compras"
2. Selecciona un proveedor
3. Agrega productos con sus cantidades al carrito
4. Confirma la compra
5. El stock se incrementará automáticamente

#### 3. Realizar Ventas
1. Ve a la pestaña "Ventas"
2. Selecciona un cliente
3. Agrega productos con cantidades (valida stock disponible)
4. Confirma la venta
5. El stock se decrementará automáticamente

#### 4. Consultar Historial
- Ve a la pestaña "Transacciones"
- Visualiza todas las operaciones realizadas
- Consulta comprobantes detallados

## 🎯 Principios SOLID Aplicados

| Principio | Aplicación en el Proyecto |
|-----------|---------------------------|
| **S**ingle Responsibility | Cada clase tiene una única responsabilidad claramente definida |
| **O**pen/Closed | Clases abstractas permiten extensión sin modificación |
| **L**iskov Substitution | Objetos derivados sustituyen correctamente a sus bases |
| **I**nterface Segregation | Interfaces pequeñas y específicas (IArchivo, ITransaccion) |
| **D**ependency Inversion | Dependencia de abstracciones, no de implementaciones concretas |

### Ejemplos Concretos

**SRP:** `Archivo` solo maneja persistencia, `Tienda` solo lógica de negocio, `MiTienda` solo UI

**OCP:** Nuevas entidades o transacciones se agregan extendiendo clases base sin modificarlas

**LSP:** `DetalleCompra` y `DetalleVenta` funcionan donde se espera `Detalle`

**ISP:** `ITransaccion` solo define métodos esenciales para transacciones

**DIP:** `MiTienda` depende de `IArchivo`, no de `Archivo` directamente

## 🔍 Conceptos POO Implementados

### Encapsulamiento
- Atributos privados/protegidos
- Validaciones en setters
- Acceso controlado mediante getters

### Herencia
- `Entidad` → `Producto`, `Cliente`, `Proveedor`
- `Transaccion` → `TCompra`, `TVenta`
- `Detalle` → `DetalleCompra`, `DetalleVenta`

### Polimorfismo
- `calcularSubtotal()` implementado diferente en cada tipo de detalle
- `procesarStock()` funciona distinto para compras vs ventas
- `generarComprobante()` personalizado por tipo de transacción

### Abstracción
- Clases abstractas: `Entidad`, `Transaccion`, `Detalle`
- Interfaces: `IArchivo`, `ITransaccion`
- Oculta complejidad interna del sistema

## 📊 Funcionalidades Detalladas

### Módulo de Productos
- ✅ Registrar: Nombre, ID, Stock, Precio Compra, Precio Venta
- ✅ Modificar cualquier campo excepto ID
- ✅ Eliminar productos del sistema
- ✅ Visualizar en tabla con todos los campos
- ✅ Validación de datos (no negativos, únicos, obligatorios)

### Módulo de Clientes
- ✅ Registrar: Nombre, ID, Teléfono
- ✅ Modificar información
- ✅ Eliminar clientes
- ✅ Visualizar lista completa

### Módulo de Proveedores
- ✅ Registrar: Nombre, ID, Email
- ✅ Modificar información
- ✅ Eliminar proveedores
- ✅ Visualizar lista completa

### Módulo de Compras
- ✅ Carrito temporal para múltiples productos
- ✅ Validación: No mezclar proveedores
- ✅ Incremento automático de stock
- ✅ Generación de comprobante
- ✅ Registro con ID autoincremental y fecha/hora

### Módulo de Ventas
- ✅ Carrito temporal para múltiples productos
- ✅ Validación: No mezclar clientes
- ✅ Validación de stock disponible
- ✅ Decremento automático de stock
- ✅ Generación de comprobante
- ✅ Registro con ID autoincremental y fecha/hora

### Módulo de Transacciones
- ✅ Historial completo de operaciones
- ✅ Visualización de detalles: ID, Tipo, Fecha, Participante, Productos, Total
- ✅ Comprobantes detallados

## 💾 Persistencia de Datos

### Archivo: `tienda.bin`

**Formato:** Archivo binario con serialización de objetos Java

**Contenido:**
- Objeto completo de la clase `Tienda`
- Todas las listas: productos, clientes, proveedores, transacciones

**Operaciones:**
- ✅ Guardado automático después de cada operación
- ✅ Carga automática al iniciar
- ✅ Manejo de errores robusto
- ✅ Optimización con buffering

### Clases Serializables
Todas las clases del dominio implementan `Serializable`:
- `Tienda`, `Entidad`, `Producto`, `Cliente`, `Proveedor`
- `Transaccion`, `TCompra`, `TVenta`
- `Detalle`, `DetalleCompra`, `DetalleVenta`

## ⚠️ Solución de Problemas

### Error al cargar archivo
**Síntoma:** Mensaje "Error al cargar archivo" al iniciar

**Solución:** El archivo `tienda.bin` puede estar corrupto. Elimínalo y la aplicación creará uno nuevo.

### Stock insuficiente
**Síntoma:** No se puede completar una venta

**Solución:** Realiza una compra para reponer el inventario antes de vender.

### No puede mezclar proveedores/clientes
**Síntoma:** Error al agregar al carrito

**Solución:** Confirma o limpia el carrito actual antes de cambiar de participante.

### Aplicación no inicia
**Síntoma:** Error al ejecutar el JAR

**Solución:** 
1. Verifica que Java esté instalado: `java -version`
2. Intenta ejecutar desde terminal: `java -jar proTienda.jar`
3. Revisa mensajes de error en la consola

## 🔮 Trabajo Futuro y Escalabilidad

### Funcionalidades Planeadas
- 📊 Reportes y gráficos estadísticos
- 💰 Análisis de rentabilidad
- 🏷️ Categorías de productos
- 💸 Sistema de descuentos
- 🔄 Gestión de devoluciones
- ⚠️ Alertas de stock bajo

### Mejoras Técnicas
- 🗄️ Migración a base de datos SQL
- ☁️ Respaldo en la nube
- 📄 Exportación a Excel/PDF
- 👤 Sistema de usuarios y roles
- 🔐 Autenticación y seguridad
- 📱 Versión web/móvil

### Arquitectura Futura
- Migrar a arquitectura cliente-servidor
- API REST para integraciones
- Soporte multi-sucursal
- Sincronización en tiempo real

## 📄 Licencia

Este proyecto es con fines educativos para la asignatura de Programación Orientada a Objetos de la Universidad del Norte.

## 📞 Contacto

**Equipo de Desarrollo:**
- Iván Sierra Arrieta - 0222420035
- Carlos Romero Paternina - 0222420028
- Salomón Restrepo Güette - 0222410050

**Repositorio:** [https://github.com/IvanS0524/ProyectoPOO](https://github.com/IvanS0524/ProyectoPOO)

## 🙏 Agradecimientos

- Universidad del Norte - Departamento de Ingeniería de Sistemas
- Docente de Programación Orientada a Objetos
- Comunidad de Java y NetBeans

---

**Universidad del Norte**  
**Ingeniería de Sistemas y Computación**  
**Programación Orientada a Objetos**  
**Diciembre 2025**

---

## 📚 Documentación Adicional

Para más información detallada, consulta los siguientes documentos en la carpeta `docs/`:

- [`1_Contexto_del_Proyecto.md`](docs/1_Contexto_del_Proyecto.md) - Contexto y problemática del proyecto
- [`2_Desarrollo_del_Proyecto.md`](docs/2_Desarrollo_del_Proyecto.md) - Desarrollo técnico completo, principios SOLID, capturas
- [`DiagramaClases.puml`](docs/DiagramaClases.puml) - Diagrama de clases UML completo
- [`Presentacion.md`](docs/Presentacion.md) - Presentación para sustentación

---

**Desarrollado con ❤️ por el equipo de ProyectoPOO**
