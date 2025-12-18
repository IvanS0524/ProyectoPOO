# DOCUMENTO DE DESARROLLO DEL PROYECTO
## Sistema de Gestión de Inventario para Tienda Minorista

---

### INFORMACIÓN DEL PROYECTO

**Integrantes del equipo:**
- Iván Sierra Arrieta (0222420035)
- Carlos Romero Paternina (0222420028)
- Salomón Restrepo Güette (0222410050)

**Institución:** Universidad de Cartagena  
**Asignatura:** Programación Orientada a Objetos  
**Fecha:** Diciembre 2025

---

## TABLA DE CONTENIDOS

1. [Introducción](#1-introducción)
2. [Arquitectura del Sistema](#2-arquitectura-del-sistema)
3. [Diagrama de Clases UML](#3-diagrama-de-clases-uml)
4. [Descripción de Paquetes y Clases](#4-descripción-de-paquetes-y-clases)
5. [Principios SOLID Aplicados](#5-principios-solid-aplicados)
6. [Descripción de Archivos de Persistencia](#6-descripción-de-archivos-de-persistencia)
7. [Funcionalidades del Sistema](#7-funcionalidades-del-sistema)
8. [Capturas de Pantalla](#8-capturas-de-pantalla)
9. [Manual de Usuario](#9-manual-de-usuario)
10. [Conclusiones y Trabajo Futuro](#10-conclusiones-y-trabajo-futuro)

---

## 1. INTRODUCCIÓN

### 1.1 Propósito del Documento

Este documento describe el desarrollo completo del Sistema de Gestión de Inventario, incluyendo decisiones de diseño, implementación técnica, y la aplicación de principios de Programación Orientada a Objetos.

### 1.2 Resumen del Sistema

El sistema desarrollado permite a tiendas minoristas gestionar:
- **Inventario de productos** con control de stock
- **Base de datos de clientes** con información de contacto
- **Registro de proveedores** para compras
- **Transacciones de compra y venta** con actualización automática de inventario
- **Persistencia de datos** mediante archivos binarios
- **Interfaz gráfica intuitiva** usando Swing

---

## 2. ARQUITECTURA DEL SISTEMA

### 2.1 Patrón de Arquitectura

El sistema utiliza una **arquitectura en capas** que separa las responsabilidades:

```
┌─────────────────────────────────────┐
│   CAPA DE PRESENTACIÓN (vista)      │
│   - MiTienda.java (GUI con Swing)   │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│   CAPA DE LÓGICA DE NEGOCIO         │
│   - Tienda, Producto, Cliente       │
│   - Transaccion, TCompra, TVenta    │
│   - Detalle, DetalleCompra/Venta    │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│   CAPA DE PERSISTENCIA              │
│   - IArchivo (interfaz)             │
│   - Archivo (implementación)        │
└─────────────────────────────────────┘
```

### 2.2 Ventajas de la Arquitectura

1. **Separación de Responsabilidades:** Cada capa tiene un propósito específico
2. **Mantenibilidad:** Los cambios en una capa no afectan a las demás
3. **Testabilidad:** Cada componente puede probarse de forma independiente
4. **Escalabilidad:** Fácil agregar nuevas funcionalidades

---

## 3. DIAGRAMA DE CLASES UML

### 3.1 Diagrama Completo

El diagrama de clases completo se encuentra en el archivo `DiagramaClases.puml` y puede visualizarse usando PlantUML.

### 3.2 Vista General de Paquetes

El sistema está organizado en 5 paquetes principales:

1. **logica:** Clases de dominio y lógica de negocio
2. **vista:** Interfaz gráfica de usuario (Swing)
3. **Interfaz:** Interfaces que definen contratos
4. **persistencia:** Implementación de persistencia en archivos
5. **exceptions:** Excepciones personalizadas

### 3.3 Jerarquías de Clases Principales

**Jerarquía de Entidad:**
```
Entidad (abstracta)
├── Producto
├── Cliente
└── Proveedor
```

**Jerarquía de Transacción:**
```
Transaccion (abstracta)
├── TCompra
└── TVenta
```

**Jerarquía de Detalle:**
```
Detalle (abstracta)
├── DetalleCompra
└── DetalleVenta
```

---

## 4. DESCRIPCIÓN DE PAQUETES Y CLASES

### 4.1 Paquete: logica

#### Clase `Entidad` (Abstracta)
- **Propósito:** Clase base para todas las entidades del sistema
- **Atributos:**
  - `nombre: String` - Nombre de la entidad
  - `id: Integer` - Identificador único
- **Métodos importantes:**
  - Getters y setters con validaciones
  - Implementa `Serializable` para persistencia
- **Patrón aplicado:** Template Method

#### Clase `Producto`
- **Propósito:** Representa un producto en el inventario
- **Atributos:**
  - `stock: int` - Cantidad disponible
  - `precioCompra: double` - Precio al que se compra
  - `precioVenta: double` - Precio al que se vende
- **Validaciones:**
  - Stock no puede ser negativo
  - Precios no pueden ser negativos
  - Nombre e ID obligatorios

#### Clase `Cliente`
- **Propósito:** Representa un cliente de la tienda
- **Atributos:**
  - `telefono: String` - Información de contacto
- **Validaciones:**
  - Teléfono no puede ser vacío
  - Hereda validaciones de Entidad

#### Clase `Proveedor`
- **Propósito:** Representa un proveedor de productos
- **Atributos:**
  - `email: String` - Correo electrónico de contacto
- **Validaciones:**
  - Email no puede ser vacío
  - Hereda validaciones de Entidad

#### Clase `Detalle` (Abstracta)
- **Propósito:** Representa un ítem en una transacción
- **Atributos:**
  - `producto: Producto` - Producto involucrado
  - `cantidad: int` - Cantidad del producto
- **Método abstracto:**
  - `calcularSubtotal(): double` - Cálculo polimórfico del subtotal
- **Patrón aplicado:** Strategy (para cálculo de subtotal)

#### Clase `DetalleCompra`
- **Propósito:** Detalle específico para compras
- **Atributos adicionales:**
  - `proveedor: Proveedor` - Proveedor asociado
- **Implementación:**
  - `calcularSubtotal()` usa `precioCompra` del producto

#### Clase `DetalleVenta`
- **Propósito:** Detalle específico para ventas
- **Atributos adicionales:**
  - `cliente: Cliente` - Cliente asociado
- **Implementación:**
  - `calcularSubtotal()` usa `precioVenta` del producto

#### Clase `Transaccion` (Abstracta)
- **Propósito:** Representa una transacción comercial
- **Atributos:**
  - `fecha: LocalDateTime` - Momento de la transacción
  - `detalles: List<Detalle>` - Lista de ítems
  - `id: int` - Identificador único autoincremental
  - `total: double` - Monto total calculado
- **Métodos abstractos:**
  - `generarComprobante(): String`
  - `procesarStock(): void`
- **Patrón aplicado:** Template Method

#### Clase `TCompra`
- **Propósito:** Transacción de compra a proveedor
- **Atributos:**
  - `proveedor: Proveedor`
- **Implementación:**
  - `procesarStock()` **incrementa** el inventario
  - `generarComprobante()` genera comprobante de compra

#### Clase `TVenta`
- **Propósito:** Transacción de venta a cliente
- **Atributos:**
  - `cliente: Cliente`
- **Implementación:**
  - `procesarStock()` **decrementa** el inventario
  - Valida stock disponible antes de procesar
  - `generarComprobante()` genera comprobante de venta

#### Clase `Tienda`
- **Propósito:** Clase principal que orquesta todo el sistema
- **Atributos:**
  - `productos: List<Producto>`
  - `clientes: List<Cliente>`
  - `proveedores: List<Proveedor>`
  - `transacciones: List<Transaccion>`
  - Carritos temporales para compras y ventas
- **Responsabilidades:**
  - CRUD de todas las entidades
  - Gestión de transacciones
  - Lógica de carritos de compra/venta
  - Validaciones de negocio
- **Patrón aplicado:** Facade (simplifica el uso del sistema)

### 4.2 Paquete: Interfaz

#### Interfaz `IArchivo`
- **Propósito:** Define el contrato para persistencia de datos
- **Métodos:**
  - `guardarEnArchivo(tienda: Tienda): void`
  - `cargarDesdeArchivo(): Tienda`
- **Ventaja:** Permite cambiar la implementación de persistencia sin modificar el código cliente

#### Interfaz `ITransaccion`
- **Propósito:** Define operaciones comunes para transacciones
- **Métodos:**
  - `procesarStock(): void`
  - `generarComprobante(): String`
- **Ventaja:** Garantiza que todas las transacciones implementen estas operaciones

### 4.3 Paquete: persistencia

#### Clase `Archivo`
- **Propósito:** Implementación concreta de persistencia en archivos binarios
- **Atributos:**
  - `nombreArchivo: String` - Nombre del archivo de datos
- **Implementación:**
  - Usa `ObjectOutputStream` para serializar objetos
  - Usa `ObjectInputStream` para deserializar objetos
  - Implementa buffering para optimizar I/O
  - Maneja excepciones de I/O y ClassNotFoundException

### 4.4 Paquete: exceptions

#### Clase `IlegalValueException`
- **Propósito:** Excepción personalizada para valores inválidos
- **Uso:** Se lanza cuando se intentan establecer valores que violan reglas de negocio
- **Tipo:** RuntimeException (no verificada)

### 4.5 Paquete: vista

#### Clase `MiTienda`
- **Propósito:** Interfaz gráfica principal del sistema
- **Tecnología:** Swing (javax.swing)
- **Componentes principales:**
  - JTabbedPane para organizar módulos
  - JTable para mostrar listados
  - JTextField, JButton para entrada de datos
  - JTextArea para mostrar comprobantes
- **Responsabilidades:**
  - Capturar entrada del usuario
  - Mostrar información en tablas
  - Invocar métodos de la capa de lógica
  - Guardar datos automáticamente
  - Cargar datos al iniciar

---

## 5. PRINCIPIOS SOLID APLICADOS

### 5.1 Single Responsibility Principle (SRP)

**Principio:** Cada clase debe tener una única responsabilidad.

**Aplicación en el proyecto:**

1. **Clase `Producto`:** Solo gestiona información de productos
2. **Clase `Archivo`:** Solo maneja persistencia de datos
3. **Clase `MiTienda`:** Solo maneja la interfaz gráfica
4. **Clase `Tienda`:** Solo contiene lógica de negocio

**Ejemplo concreto:**
```java
// ✓ CORRECTO: Responsabilidad única
public class Archivo implements IArchivo {
    // Solo maneja lectura/escritura de archivos
    public void guardarEnArchivo(Tienda tienda) { ... }
    public Tienda cargarDesdeArchivo() { ... }
}

// ✗ INCORRECTO: Múltiples responsabilidades
// Si Archivo también tuviera lógica de negocio o UI
```

### 5.2 Open/Closed Principle (OCP)

**Principio:** Las clases deben estar abiertas para extensión, pero cerradas para modificación.

**Aplicación en el proyecto:**

1. **Clase abstracta `Entidad`:**
   - Cerrada para modificación (funcionalidad base estable)
   - Abierta para extensión (nuevas entidades pueden heredar)

2. **Clase abstracta `Transaccion`:**
   - Podemos agregar nuevos tipos de transacciones (ej: `TDevolucion`) sin modificar código existente

**Ejemplo concreto:**
```java
// Clase base cerrada para modificación
public abstract class Transaccion {
    public double calcularTotal() { /* implementación estable */ }
    public abstract void procesarStock(); // abierta para extensión
}

// Extensión sin modificar la clase base
public class TDevolucion extends Transaccion {
    @Override
    public void procesarStock() { /* nueva lógica */ }
}
```

### 5.3 Liskov Substitution Principle (LSP)

**Principio:** Los objetos de una clase derivada deben poder reemplazar objetos de la clase base sin alterar el comportamiento del programa.

**Aplicación en el proyecto:**

1. **Jerarquía de `Detalle`:**
   - `DetalleCompra` y `DetalleVenta` pueden usarse donde se espera un `Detalle`
   - Ambas implementan correctamente `calcularSubtotal()`

2. **Jerarquía de `Transaccion`:**
   - `TCompra` y `TVenta` pueden usarse donde se espera una `Transaccion`

**Ejemplo concreto:**
```java
// En la clase Transaccion
public double calcularTotal() {
    double suma = 0;
    for (Detalle d : detalles) { // Funciona con DetalleCompra o DetalleVenta
        suma += d.calcularSubtotal(); // Polimorfismo
    }
    return suma;
}
```

### 5.4 Interface Segregation Principle (ISP)

**Principio:** Los clientes no deben depender de interfaces que no utilizan.

**Aplicación en el proyecto:**

1. **Interfaz `ITransaccion`:**
   - Solo define métodos esenciales para transacciones
   - No incluye métodos irrelevantes

2. **Interfaz `IArchivo`:**
   - Solo define operaciones de persistencia
   - Separada de lógica de negocio

**Ejemplo concreto:**
```java
// ✓ CORRECTO: Interfaz específica y pequeña
public interface ITransaccion {
    void procesarStock();
    String generarComprobante();
}

// ✗ INCORRECTO: Interfaz muy grande
public interface IOperaciones {
    void procesarStock();
    String generarComprobante();
    void enviarEmail();        // No todas las transacciones necesitan esto
    void imprimirFactura();    // No todas las transacciones necesitan esto
    void calcularImpuestos();  // No todas las transacciones necesitan esto
}
```

### 5.5 Dependency Inversion Principle (DIP)

**Principio:** Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones.

**Aplicación en el proyecto:**

1. **Uso de `IArchivo`:**
   - La clase `MiTienda` depende de la interfaz `IArchivo`, no de la implementación concreta
   - Podemos cambiar de archivos binarios a base de datos sin modificar `MiTienda`

**Ejemplo concreto:**
```java
// En MiTienda
public class MiTienda extends JFrame {
    private Tienda tienda;
    private IArchivo archivo; // Dependencia de abstracción, no de implementación
    
    public MiTienda() {
        archivo = new Archivo("tienda.bin"); // Se puede cambiar fácilmente
    }
}

// Fácil cambiar la implementación
// archivo = new ArchivoJSON("tienda.json");
// archivo = new BaseDatos("jdbc:...");
```

### 5.6 Resumen de Beneficios SOLID en el Proyecto

| Principio | Beneficio Obtenido |
|-----------|-------------------|
| SRP | Código más mantenible y fácil de entender |
| OCP | Fácil agregar nuevos tipos de entidades o transacciones |
| LSP | Polimorfismo funciona correctamente en todo el sistema |
| ISP | Interfaces simples y fáciles de implementar |
| DIP | Sistema flexible y desacoplado, fácil de testear |

---

## 6. DESCRIPCIÓN DE ARCHIVOS DE PERSISTENCIA

### 6.1 Archivo de Datos: `tienda.bin`

**Ubicación:** Directorio raíz del proyecto (mismo nivel que el ejecutable)

**Formato:** Archivo binario serializado de Java

**Contenido:**
- Objeto completo de la clase `Tienda`
- Incluye todas las listas:
  - Lista de productos
  - Lista de clientes
  - Lista de proveedores
  - Lista de transacciones

### 6.2 Mecanismo de Serialización

**Clases Serializables:**
- `Tienda`
- `Entidad` (y todas sus subclases)
- `Detalle` (y todas sus subclases)
- `Transaccion` (y todas sus subclases)

**Proceso de Guardado:**
```java
public void guardarEnArchivo(Tienda tienda) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(
            new BufferedOutputStream(new FileOutputStream(nombreArchivo)))) {
        oos.writeObject(tienda);
    }
}
```

**Proceso de Carga:**
```java
public Tienda cargarDesdeArchivo() throws IOException, ClassNotFoundException {
    File archivo = new File(nombreArchivo);
    if (!archivo.exists()) {
        return new Tienda(); // Tienda nueva si no hay archivo
    }
    try (ObjectInputStream ois = new ObjectInputStream(
            new BufferedInputStream(new FileInputStream(archivo)))) {
        return (Tienda) ois.readObject();
    }
}
```

### 6.3 Manejo de Errores

**Escenarios contemplados:**
1. **Archivo no existe:** Se crea una tienda nueva vacía
2. **Error de lectura:** Se muestra mensaje de error al usuario
3. **Clase no encontrada:** Se captura `ClassNotFoundException`
4. **Archivo corrupto:** Se maneja con try-catch y mensaje informativo

### 6.4 Optimizaciones

1. **Buffering:** Uso de `BufferedInputStream` y `BufferedOutputStream` para mejor rendimiento
2. **Try-with-resources:** Cierre automático de streams para evitar fugas de recursos
3. **Guardado automático:** El sistema guarda después de cada operación que modifica datos

---

## 7. FUNCIONALIDADES DEL SISTEMA

### 7.1 Gestión de Productos

**Operaciones disponibles:**
- ✅ **Registrar producto:** Nombre, ID, stock inicial, precio compra, precio venta
- ✅ **Modificar producto:** Actualizar cualquier campo excepto ID
- ✅ **Eliminar producto:** Borrar del inventario
- ✅ **Listar productos:** Ver todos en tabla con todos los campos
- ✅ **Buscar producto:** Por ID para operaciones

**Validaciones:**
- ID único y obligatorio
- Nombre no vacío
- Stock no negativo
- Precios no negativos
- Precio venta > precio compra (recomendado, warning)

### 7.2 Gestión de Clientes

**Operaciones disponibles:**
- ✅ **Registrar cliente:** Nombre, ID, teléfono
- ✅ **Modificar cliente:** Actualizar nombre o teléfono
- ✅ **Eliminar cliente:** Borrar del sistema
- ✅ **Listar clientes:** Ver todos en tabla

**Validaciones:**
- ID único y obligatorio
- Nombre no vacío
- Teléfono no vacío

### 7.3 Gestión de Proveedores

**Operaciones disponibles:**
- ✅ **Registrar proveedor:** Nombre, ID, email
- ✅ **Modificar proveedor:** Actualizar nombre o email
- ✅ **Eliminar proveedor:** Borrar del sistema
- ✅ **Listar proveedores:** Ver todos en tabla

**Validaciones:**
- ID único y obligatorio
- Nombre no vacío
- Email no vacío

### 7.4 Gestión de Compras (a Proveedores)

**Operaciones disponibles:**
- ✅ **Agregar al carrito:** Seleccionar proveedor, producto, cantidad
- ✅ **Ver carrito:** Visualizar ítems agregados antes de confirmar
- ✅ **Confirmar compra:** Procesar transacción completa
- ✅ **Limpiar carrito:** Cancelar compra en progreso

**Reglas de negocio:**
- ✅ No mezclar proveedores en una misma compra
- ✅ Stock se incrementa al confirmar
- ✅ Se genera comprobante con detalles
- ✅ Se registra fecha y hora automáticamente
- ✅ ID de transacción autoincremental

**Flujo de uso:**
1. Seleccionar proveedor
2. Agregar productos con cantidades
3. Revisar carrito
4. Confirmar compra
5. Ver comprobante generado
6. Stock actualizado automáticamente

### 7.5 Gestión de Ventas (a Clientes)

**Operaciones disponibles:**
- ✅ **Agregar al carrito:** Seleccionar cliente, producto, cantidad
- ✅ **Ver carrito:** Visualizar ítems agregados antes de confirmar
- ✅ **Confirmar venta:** Procesar transacción completa
- ✅ **Limpiar carrito:** Cancelar venta en progreso

**Reglas de negocio:**
- ✅ No mezclar clientes en una misma venta
- ✅ Validar stock disponible (incluyendo lo que hay en carrito)
- ✅ Stock se decrementa al confirmar
- ✅ Se genera comprobante con detalles
- ✅ Se registra fecha y hora automáticamente
- ✅ ID de transacción autoincremental

**Validaciones especiales:**
- ⚠️ No permitir venta si stock insuficiente
- ⚠️ Considerar productos ya en carrito para validar stock
- ⚠️ Mensaje claro de error con stock disponible y en carrito

### 7.6 Historial de Transacciones

**Información mostrada:**
- ID de transacción
- Tipo (Compra / Venta)
- Fecha y hora
- Participante (Cliente o Proveedor)
- Productos involucrados
- Total de la transacción

**Funcionalidades:**
- Ver todas las transacciones históricas
- Ordenadas por fecha (más reciente primero)
- Ver comprobante detallado de cualquier transacción

### 7.7 Persistencia Automática

**Características:**
- ✅ Guardado automático después de cada operación
- ✅ Carga automática al iniciar la aplicación
- ✅ Mensajes informativos de éxito/error
- ✅ Manejo robusto de errores de I/O

---

## 8. CAPTURAS DE PANTALLA

### 8.1 Pantalla Principal

**[INSTRUCCIONES PARA COMPLETAR]**
- Incluir captura de la ventana principal al iniciar
- Mostrar el JTabbedPane con todas las pestañas visibles
- Incluir descripción de cada pestaña

### 8.2 Módulo de Productos

**[INSTRUCCIONES PARA COMPLETAR]**
- Captura del formulario de registro de producto
- Captura de la tabla de productos con datos de ejemplo
- Captura del proceso de modificación de un producto
- Captura del mensaje de confirmación al eliminar

### 8.3 Módulo de Clientes

**[INSTRUCCIONES PARA COMPLETAR]**
- Captura del formulario de registro de cliente
- Captura de la tabla de clientes con datos de ejemplo
- Mostrar validación de campos obligatorios

### 8.4 Módulo de Proveedores

**[INSTRUCCIONES PARA COMPLETAR]**
- Captura del formulario de registro de proveedor
- Captura de la tabla de proveedores con datos

### 8.5 Módulo de Compras

**[INSTRUCCIONES PARA COMPLETAR]**
- Captura del proceso de agregar productos al carrito
- Captura del carrito con múltiples productos
- Captura del comprobante generado
- Captura de la actualización del stock después de compra

### 8.6 Módulo de Ventas

**[INSTRUCCIONES PARA COMPLETAR]**
- Captura del proceso de venta
- Captura de validación de stock insuficiente
- Captura del comprobante de venta
- Captura de actualización de inventario después de venta

### 8.7 Módulo de Transacciones

**[INSTRUCCIONES PARA COMPLETAR]**
- Captura de la tabla de transacciones
- Mostrar diferentes tipos de transacciones
- Captura de comprobante detallado

### 8.8 Persistencia de Datos

**[INSTRUCCIONES PARA COMPLETAR]**
- Captura del mensaje de carga exitosa al iniciar
- Captura del mensaje de guardado automático
- Mostrar que los datos persisten después de cerrar y reabrir

---

## 9. MANUAL DE USUARIO

### 9.1 Requisitos Previos

- Java JRE 8 o superior instalado
- Resolución de pantalla mínima: 1024x768

### 9.2 Instalación

1. Descargar la carpeta del proyecto
2. Navegar a la carpeta `dist`
3. Ejecutar el archivo `proTienda.jar`

### 9.3 Primer Uso

1. Al iniciar por primera vez, verá un mensaje indicando que no hay archivo previo
2. Se creará una tienda vacía
3. Comience registrando productos, clientes y proveedores

### 9.4 Flujo de Trabajo Recomendado

**Paso 1: Configuración Inicial**
1. Registrar proveedores con los que trabajará
2. Registrar clientes frecuentes
3. Registrar productos del inventario con stock inicial

**Paso 2: Operación Diaria**
1. **Para compras:** Agregar productos al carrito de compra, confirmar
2. **Para ventas:** Agregar productos al carrito de venta, confirmar
3. **Revisar transacciones** en el módulo de historial

**Paso 3: Gestión**
1. Modificar productos cuando cambien precios
2. Actualizar información de clientes/proveedores según sea necesario
3. Revisar stock antes de realizar ventas

### 9.5 Solución de Problemas Comunes

**Problema:** "Error al cargar archivo"
- **Solución:** El archivo puede estar corrupto. Eliminar `tienda.bin` y comenzar de nuevo.

**Problema:** "Stock insuficiente"
- **Solución:** Realizar una compra para reponer inventario antes de vender.

**Problema:** "No puede mezclar proveedores"
- **Solución:** Confirmar o limpiar el carrito actual antes de cambiar de proveedor.

---

## 10. CONCLUSIONES Y TRABAJO FUTURO

### 10.1 Logros del Proyecto

✅ **Cumplimiento de Requisitos:**
- Sistema funcional completo con todas las operaciones CRUD
- Persistencia de datos mediante archivos binarios
- Interfaz gráfica desarrollada con Swing
- Aplicación de principios SOLID en el diseño
- Código documentado y estructurado profesionalmente

✅ **Aplicación de Conceptos POO:**
- Herencia (Entidad, Transaccion, Detalle)
- Polimorfismo (calcularSubtotal, procesarStock)
- Encapsulamiento (validaciones en setters)
- Abstracción (clases e interfaces abstractas)

✅ **Buenas Prácticas:**
- Separación de responsabilidades en capas
- Validaciones robustas de datos
- Manejo de excepciones apropiado
- Código limpio y legible

### 10.2 Impacto de la Solución

**Beneficios para el Usuario:**
1. **Organización:** Toda la información centralizada y accesible
2. **Confiabilidad:** Los datos no se pierden gracias a la persistencia
3. **Eficiencia:** Operaciones rápidas y automatización de cálculos
4. **Control:** Visibilidad completa del inventario y transacciones
5. **Profesionalismo:** Comprobantes generados automáticamente

**Valor Empresarial:**
- Reduce errores humanos en el manejo de inventario
- Ahorra tiempo en operaciones diarias
- Proporciona historial completo para auditorías
- Facilita la toma de decisiones basada en datos

### 10.3 Escalabilidad - Mejoras Futuras

**Funcionalidades Adicionales:**
1. **Reportes y Estadísticas:**
   - Gráficos de ventas por período
   - Productos más vendidos
   - Análisis de rentabilidad (margen de ganancia)
   - Alertas de stock bajo

2. **Gestión Avanzada:**
   - Categorías de productos
   - Descuentos y promociones
   - Devoluciones de compra/venta
   - Control de múltiples sucursales

3. **Mejoras en Persistencia:**
   - Migración a base de datos (MySQL, PostgreSQL)
   - Respaldo automático en la nube
   - Exportación a Excel/PDF
   - Importación masiva de datos

4. **Interfaz y UX:**
   - Búsqueda y filtrado avanzado en tablas
   - Impresión directa de comprobantes
   - Temas visuales personalizables
   - Atajos de teclado para operaciones frecuentes

5. **Seguridad:**
   - Sistema de usuarios y roles
   - Autenticación y autorización
   - Registro de auditoría de cambios
   - Encriptación de datos sensibles

6. **Integración:**
   - Lectura de códigos de barras
   - Integración con sistemas de pago
   - Sincronización con facturación electrónica
   - API REST para integración con otras aplicaciones

**Arquitectura Escalable:**
- Migrar a arquitectura cliente-servidor para múltiples usuarios
- Implementar patrón Repository para abstraer persistencia
- Usar inyección de dependencias para mayor flexibilidad
- Agregar capa de servicios para lógica de negocio compleja

### 10.4 Lecciones Aprendidas

1. **Importancia del Diseño:** Un buen diseño orientado a objetos facilita mucho el desarrollo y mantenimiento
2. **SOLID es fundamental:** Seguir estos principios hace el código más flexible y mantenible
3. **Validaciones tempranas:** Validar datos en los setters previene muchos errores
4. **Persistencia es crucial:** Los usuarios valoran que sus datos no se pierdan
5. **UX simple:** Una interfaz intuitiva es tan importante como la funcionalidad

### 10.5 Conclusión Final

El Sistema de Gestión de Inventario desarrollado cumple exitosamente con todos los objetivos planteados y demuestra la aplicación práctica de conceptos de Programación Orientada a Objetos. El proyecto no solo es funcional, sino que está construido sobre una base sólida que permite su crecimiento y evolución futura.

La arquitectura basada en principios SOLID garantiza que el sistema sea:
- **Mantenible:** Fácil de modificar y corregir
- **Extensible:** Fácil agregar nuevas funcionalidades
- **Testeable:** Fácil de probar cada componente
- **Profesional:** Sigue estándares de la industria

Este proyecto representa una solución real a un problema real, con potencial de ser utilizado en tiendas minoristas reales con las mejoras propuestas.

---

**FIN DEL DOCUMENTO**

---

## ANEXOS

### Anexo A: Estructura de Directorios del Proyecto

```
proTienda/
├── src/
│   ├── exceptions/
│   │   └── IlegalValueException.java
│   ├── Interfaz/
│   │   ├── IArchivo.java
│   │   └── ITransaccion.java
│   ├── logica/
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
│   ├── persistencia/
│   │   └── Archivo.java
│   └── vista/
│       ├── MiTienda.java
│       └── MiTienda.form
├── docs/
│   ├── 1_Contexto_del_Proyecto.md
│   ├── 2_Desarrollo_del_Proyecto.md
│   ├── DiagramaClases.puml
│   └── Presentacion.md
├── build/
├── dist/
│   └── proTienda.jar
├── nbproject/
├── build.xml
├── manifest.mf
├── tienda.bin (generado en tiempo de ejecución)
└── README.md
```

### Anexo B: Comandos de Compilación

**Compilar desde línea de comandos:**
```bash
# Compilar
javac -d build/classes src/**/*.java

# Crear JAR
jar cvfm dist/proTienda.jar manifest.mf -C build/classes .

# Ejecutar
java -jar dist/proTienda.jar
```

**Compilar con NetBeans:**
1. Abrir el proyecto en NetBeans
2. Clic derecho en el proyecto > Clean and Build
3. El JAR se generará en la carpeta `dist/`

### Anexo C: Glosario de Términos

- **CRUD:** Create, Read, Update, Delete (operaciones básicas de datos)
- **SOLID:** Cinco principios de diseño orientado a objetos
- **Swing:** Biblioteca de Java para crear interfaces gráficas
- **Serialización:** Proceso de convertir objetos en flujo de bytes
- **Persistencia:** Capacidad de mantener datos después de cerrar la aplicación
- **Polimorfismo:** Capacidad de objetos de diferentes clases de responder al mismo mensaje
- **Herencia:** Mecanismo para crear nuevas clases basadas en clases existentes

---

**Documento preparado por:**
- Iván Sierra Arrieta (0222420035)
- Carlos Romero Paternina (0222420028)
- Salomón Restrepo Güette (0222410050)

**Fecha de elaboración:** Diciembre 2025
