# PRESENTACIÓN DEL PROYECTO
## Sistema de Gestión de Inventario para Tienda Minorista

---

## DIAPOSITIVA 1: PORTADA

### Sistema de Gestión de Inventario
#### Tienda Minorista

**Integrantes:**
- Iván Sierra Arrieta (0222420035)
- Carlos Romero Paternina (0222420028)
- Salomón Restrepo Güette (0222410050)

**Asignatura:** Programación Orientada a Objetos  
**Universidad de Cartagena**  
**Diciembre 2025**

---

## DIAPOSITIVA 2: AGENDA

### Contenido de la Presentación

1. **Contexto y Problema**
2. **Objetivos del Proyecto**
3. **Arquitectura del Sistema**
4. **Diagrama de Clases UML**
5. **Principios SOLID Aplicados**
6. **Demostración del Sistema**
7. **Funcionalidades Principales**
8. **Persistencia de Datos**
9. **Conclusiones**
10. **Escalabilidad y Trabajo Futuro**

---

## DIAPOSITIVA 3: CONTEXTO Y PROBLEMA

### ¿Qué problema resolvemos?

**Problemática de las tiendas minoristas:**
- 📝 Gestión manual de inventario propensa a errores
- 📊 Falta de control de stock en tiempo real
- 💾 Pérdida de información de clientes y proveedores
- 📉 Dificultad para rastrear transacciones
- ⚠️ Sin respaldo de datos

### Impacto
- Pérdidas económicas por descontrol de inventario
- Tiempo perdido en procesos manuales
- Imposibilidad de análisis de negocio

---

## DIAPOSITIVA 4: NUESTRA SOLUCIÓN

### Sistema Integral de Gestión

**✓ Gestión de Inventario**
- Control completo de productos y stock

**✓ Base de Datos**
- Clientes, proveedores y transacciones

**✓ Procesamiento Automatizado**
- Compras y ventas con actualización automática

**✓ Persistencia**
- Datos guardados permanentemente

**✓ Interfaz Amigable**
- Desarrollada con Swing (Java)

---

## DIAPOSITIVA 5: OBJETIVOS DEL PROYECTO

### Objetivo General
Desarrollar un sistema robusto de gestión de inventario aplicando principios de POO y utilizando persistencia de datos.

### Objetivos Específicos
1. ✅ Implementar arquitectura orientada a objetos con principios SOLID
2. ✅ Desarrollar sistema de persistencia mediante archivos
3. ✅ Crear interfaz gráfica intuitiva con Swing
4. ✅ Implementar validaciones robustas de datos
5. ✅ Desarrollar funcionalidad de carritos de compra/venta
6. ✅ Generar comprobantes de transacciones

---

## DIAPOSITIVA 6: TECNOLOGÍAS UTILIZADAS

### Stack Tecnológico

**Lenguaje:** Java (JDK 8+)

**Interfaz Gráfica:** Swing (javax.swing)

**Persistencia:** Serialización de objetos (archivos .bin)

**IDE:** Apache NetBeans

**Control de Versiones:** Git / GitHub

**Documentación:** Markdown, PlantUML

---

## DIAPOSITIVA 7: ARQUITECTURA DEL SISTEMA

### Arquitectura en Capas

```
┌─────────────────────────────────┐
│  CAPA DE PRESENTACIÓN           │
│  (vista)                        │
│  MiTienda.java - Swing          │
└───────────┬─────────────────────┘
            │
┌───────────▼─────────────────────┐
│  CAPA DE LÓGICA DE NEGOCIO      │
│  (logica)                       │
│  Tienda, Producto, Cliente      │
│  Transaccion, TCompra, TVenta   │
└───────────┬─────────────────────┘
            │
┌───────────▼─────────────────────┐
│  CAPA DE PERSISTENCIA           │
│  (persistencia)                 │
│  IArchivo, Archivo              │
└─────────────────────────────────┘
```

**Beneficios:**
- Separación de responsabilidades
- Mantenibilidad
- Testabilidad

---

## DIAPOSITIVA 8: DIAGRAMA DE CLASES - VISTA GENERAL

### Estructura de Paquetes

**📦 logica** - Clases de dominio
- Entidad (abstracta): Producto, Cliente, Proveedor
- Transaccion (abstracta): TCompra, TVenta
- Detalle (abstracta): DetalleCompra, DetalleVenta
- Tienda

**📦 Interfaz** - Contratos
- IArchivo
- ITransaccion

**📦 persistencia** - Persistencia
- Archivo

**📦 vista** - Interfaz gráfica
- MiTienda

---

## DIAPOSITIVA 9: JERARQUÍA DE CLASES

### Herencia en el Sistema

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
├── TCompra (incrementa stock)
└── TVenta (decrementa stock)
```

**Jerarquía de Detalle:**
```
Detalle (abstracta)
├── DetalleCompra (precio compra)
└── DetalleVenta (precio venta)
```

---

## DIAPOSITIVA 10: PRINCIPIOS SOLID (1/3)

### S - Single Responsibility Principle

**Cada clase tiene una única responsabilidad**

✓ `Producto` → Solo gestiona datos de productos  
✓ `Archivo` → Solo maneja persistencia  
✓ `MiTienda` → Solo maneja interfaz gráfica  
✓ `Tienda` → Solo contiene lógica de negocio

**Beneficio:** Código más mantenible y fácil de entender

---

### O - Open/Closed Principle

**Abierto para extensión, cerrado para modificación**

✓ `Entidad` → Podemos crear nuevas entidades sin modificar la clase base  
✓ `Transaccion` → Nuevos tipos de transacciones sin cambiar código existente

**Ejemplo:** Podríamos agregar `TDevolucion` sin tocar `TCompra` o `TVenta`

**Beneficio:** Sistema flexible y extensible

---

## DIAPOSITIVA 11: PRINCIPIOS SOLID (2/3)

### L - Liskov Substitution Principle

**Los objetos derivados deben poder sustituir a los base**

✓ `DetalleCompra` y `DetalleVenta` funcionan donde se espera `Detalle`  
✓ `TCompra` y `TVenta` funcionan donde se espera `Transaccion`

```java
// Polimorfismo en acción
for (Detalle d : detalles) {
    suma += d.calcularSubtotal(); // ✓ Funciona con ambos tipos
}
```

**Beneficio:** Polimorfismo correcto y predecible

---

### I - Interface Segregation Principle

**Interfaces específicas y pequeñas**

✓ `ITransaccion` → Solo métodos esenciales de transacciones  
✓ `IArchivo` → Solo operaciones de persistencia

❌ No tenemos interfaces gigantes con métodos innecesarios

**Beneficio:** Interfaces fáciles de implementar

---

## DIAPOSITIVA 12: PRINCIPIOS SOLID (3/3)

### D - Dependency Inversion Principle

**Depender de abstracciones, no de implementaciones**

```java
// MiTienda depende de la interfaz, no de la implementación
private IArchivo archivo;

// Fácil cambiar la implementación
archivo = new Archivo("tienda.bin");
// Futuro: archivo = new BaseDatos("jdbc:...");
```

**Beneficio:** Sistema desacoplado y flexible

---

## DIAPOSITIVA 13: CONCEPTOS POO APLICADOS

### Los 4 Pilares de POO

**1. Encapsulamiento**
- Atributos privados/protegidos
- Validaciones en setters
- Getters para acceso controlado

**2. Herencia**
- `Entidad` → `Producto`, `Cliente`, `Proveedor`
- `Transaccion` → `TCompra`, `TVenta`
- Reutilización de código

**3. Polimorfismo**
- `calcularSubtotal()` en `Detalle`
- `procesarStock()` en `Transaccion`
- Comportamiento dinámico

**4. Abstracción**
- Clases abstractas: `Entidad`, `Transaccion`, `Detalle`
- Interfaces: `IArchivo`, `ITransaccion`
- Ocultar complejidad

---

## DIAPOSITIVA 14: FUNCIONALIDADES - MÓDULO PRODUCTOS

### Gestión Completa de Inventario

**Operaciones:**
- ✅ Registrar producto (nombre, ID, stock, precios)
- ✅ Modificar información de productos
- ✅ Eliminar productos
- ✅ Visualizar listado completo en tabla
- ✅ Actualización automática de stock

**Validaciones:**
- ID único y obligatorio
- Stock no negativo
- Precios válidos
- Nombre no vacío

---

## DIAPOSITIVA 15: FUNCIONALIDADES - MÓDULO CLIENTES/PROVEEDORES

### Gestión de Participantes

**Clientes:**
- Registro: Nombre, ID, Teléfono
- Modificación de datos
- Eliminación
- Listado completo

**Proveedores:**
- Registro: Nombre, ID, Email
- Modificación de datos
- Eliminación
- Listado completo

**Ambos:**
- Validación de unicidad de ID
- Campos obligatorios verificados

---

## DIAPOSITIVA 16: FUNCIONALIDADES - TRANSACCIONES (1/2)

### Compras a Proveedores

**Proceso:**
1. Seleccionar proveedor
2. Agregar productos al carrito
3. Revisar carrito temporal
4. Confirmar compra

**Características:**
- ✅ Carrito temporal para múltiples productos
- ✅ No mezclar proveedores
- ✅ **Stock se incrementa** automáticamente
- ✅ Generación de comprobante
- ✅ Registro con fecha/hora

---

## DIAPOSITIVA 17: FUNCIONALIDADES - TRANSACCIONES (2/2)

### Ventas a Clientes

**Proceso:**
1. Seleccionar cliente
2. Agregar productos al carrito
3. Revisar carrito temporal
4. Confirmar venta

**Características:**
- ✅ Carrito temporal para múltiples productos
- ✅ No mezclar clientes
- ✅ **Validación de stock** disponible
- ✅ **Stock se decrementa** automáticamente
- ✅ Generación de comprobante
- ✅ Registro con fecha/hora

---

## DIAPOSITIVA 18: PERSISTENCIA DE DATOS

### Sistema de Archivos Binarios

**Archivo:** `tienda.bin`

**Contenido Serializado:**
- Objeto completo de clase `Tienda`
- Todas las listas: productos, clientes, proveedores, transacciones

**Características:**
- 💾 Guardado automático después de cada operación
- 🔄 Carga automática al iniciar aplicación
- ✅ Manejo robusto de errores
- ⚡ Optimización con buffering

**Ventajas:**
- Datos nunca se pierden
- No requiere instalación de base de datos
- Portabilidad del archivo

---

## DIAPOSITIVA 19: VALIDACIONES Y ROBUSTEZ

### Sistema de Validaciones Implementado

**Validaciones de Datos:**
- ✓ IDs únicos para todas las entidades
- ✓ Campos obligatorios no vacíos
- ✓ Valores numéricos no negativos
- ✓ Stock suficiente antes de vender

**Reglas de Negocio:**
- ✓ No mezclar proveedores en una compra
- ✓ No mezclar clientes en una venta
- ✓ Validar stock disponible incluyendo carrito

**Manejo de Errores:**
- ✓ Mensajes claros al usuario
- ✓ Excepciones personalizadas
- ✓ Try-catch apropiados
- ✓ Prevención de estados inconsistentes

---

## DIAPOSITIVA 20: DEMOSTRACIÓN EN VIVO

### 🖥️ Demo del Sistema

**Escenario a demostrar:**

1. **Iniciar aplicación** → Cargar datos
2. **Registrar producto** → Laptop, ID: 101
3. **Registrar cliente** → Juan Pérez
4. **Registrar proveedor** → TechSupply
5. **Realizar compra** → 10 laptops de TechSupply
6. **Verificar stock** → Stock actualizado a 10
7. **Realizar venta** → 3 laptops a Juan
8. **Verificar stock** → Stock actualizado a 7
9. **Ver historial** → Transacciones registradas
10. **Cerrar y reabrir** → Datos persisten

---

## DIAPOSITIVA 21: RESULTADOS OBTENIDOS

### ✅ Cumplimiento de Objetivos

**Requisitos Técnicos:**
- ✅ Uso de archivos para persistencia
- ✅ Interfaz gráfica con Swing
- ✅ Aplicación completa de conceptos POO
- ✅ Principios SOLID implementados

**Funcionalidades:**
- ✅ CRUD completo de todas las entidades
- ✅ Transacciones de compra y venta
- ✅ Carritos temporales funcionales
- ✅ Actualización automática de stock
- ✅ Generación de comprobantes
- ✅ Historial de transacciones

**Calidad de Código:**
- ✅ Código documentado
- ✅ Validaciones robustas
- ✅ Manejo de excepciones
- ✅ Arquitectura limpia

---

## DIAPOSITIVA 22: IMPACTO DE LA SOLUCIÓN

### Beneficios para el Usuario

**Organización:**
- Toda la información centralizada
- Fácil acceso a datos históricos

**Confiabilidad:**
- Datos persistentes y seguros
- Respaldo automático

**Eficiencia:**
- Automatización de cálculos
- Operaciones rápidas y simples

**Control:**
- Visibilidad total del inventario
- Seguimiento de todas las operaciones

**Profesionalismo:**
- Comprobantes automáticos
- Registro detallado de transacciones

---

## DIAPOSITIVA 23: LECCIONES APRENDIDAS

### Conocimientos Adquiridos

**Diseño:**
- Importancia de planificar antes de programar
- SOLID hace el código más profesional
- Arquitectura en capas facilita el desarrollo

**Implementación:**
- Validaciones tempranas previenen muchos bugs
- Persistencia es crucial para aplicaciones reales
- Swing permite crear UIs funcionales

**Trabajo en Equipo:**
- Comunicación constante es clave
- Revisión de código mejora la calidad
- Documentación ayuda a todo el equipo

---

## DIAPOSITIVA 24: ESCALABILIDAD - MEJORAS FUTURAS (1/2)

### Funcionalidades Adicionales

**Reportes y Análisis:**
- 📊 Gráficos de ventas por período
- 📈 Productos más vendidos
- 💰 Análisis de rentabilidad
- ⚠️ Alertas de stock bajo

**Gestión Avanzada:**
- 🏷️ Categorías de productos
- 💸 Descuentos y promociones
- 🔄 Devoluciones de compra/venta
- 🏪 Control de múltiples sucursales

---

## DIAPOSITIVA 25: ESCALABILIDAD - MEJORAS FUTURAS (2/2)

### Mejoras Técnicas

**Persistencia:**
- 🗄️ Migración a base de datos (MySQL/PostgreSQL)
- ☁️ Respaldo automático en la nube
- 📄 Exportación a Excel/PDF

**Interfaz:**
- 🔍 Búsqueda y filtrado avanzado
- 🖨️ Impresión directa de comprobantes
- 🎨 Temas visuales personalizables

**Seguridad:**
- 👤 Sistema de usuarios y roles
- 🔐 Autenticación y autorización
- 📝 Registro de auditoría

**Integración:**
- 📷 Lectura de códigos de barras
- 💳 Sistemas de pago
- 🧾 Facturación electrónica

---

## DIAPOSITIVA 26: ARQUITECTURA FUTURA

### Evolución del Sistema

**De Aplicación Local a Sistema Distribuido:**

```
Actual: Aplicación Desktop
Tienda.bin → Aplicación Java + Swing

Futuro: Arquitectura Cliente-Servidor
Clientes Desktop/Web/Móvil ←→ Servidor API ←→ Base de Datos
```

**Ventajas:**
- Múltiples usuarios simultáneos
- Acceso desde cualquier dispositivo
- Sincronización en tiempo real
- Mayor seguridad y respaldo

**Tecnologías Propuestas:**
- Backend: Spring Boot
- Base de Datos: PostgreSQL
- Frontend Web: React
- API: REST/GraphQL

---

## DIAPOSITIVA 27: CONCLUSIONES (1/2)

### Logros del Proyecto

**Técnicos:**
- Sistema funcional y completo
- Código limpio y bien estructurado
- Aplicación correcta de POO y SOLID
- Persistencia confiable implementada

**Académicos:**
- Aplicación práctica de conceptos teóricos
- Desarrollo de habilidades de diseño
- Experiencia con herramientas profesionales
- Trabajo en equipo efectivo

**Prácticos:**
- Solución a problema real
- Sistema usable por negocios reales
- Base sólida para escalabilidad

---

## DIAPOSITIVA 28: CONCLUSIONES (2/2)

### Reflexión Final

> "Este proyecto no es solo código, es la aplicación práctica de principios fundamentales de ingeniería de software para resolver problemas reales."

**El sistema demuestra:**
- 🎯 Aplicación correcta de Programación Orientada a Objetos
- 🏗️ Diseño arquitectónico sólido con principios SOLID
- 💾 Implementación efectiva de persistencia de datos
- 🖥️ Desarrollo de interfaz gráfica funcional con Swing
- 📝 Documentación profesional completa

**Valor del proyecto:**
- Solución práctica para tiendas minoristas
- Base para crecimiento futuro
- Evidencia de competencias en POO

---

## DIAPOSITIVA 29: AGRADECIMIENTOS

### Gracias por su atención

**Equipo de Desarrollo:**
- Iván Sierra Arrieta (0222420035)
- Carlos Romero Paternina (0222420028)
- Salomón Restrepo Güette (0222410050)

**Contacto:**
- GitHub: [IvanS0524/ProyectoPOO]
- Repositorio: ProyectoPOO/proTienda

---

**Universidad de Cartagena**  
**Programación Orientada a Objetos**  
**Diciembre 2025**

---

## DIAPOSITIVA 30: PREGUNTAS Y RESPUESTAS

### ❓ Ronda de Preguntas

**Estamos listos para responder sus preguntas sobre:**

- 🏗️ Arquitectura y diseño del sistema
- 💻 Implementación técnica
- 🎨 Decisiones de diseño
- 🔧 Funcionalidades específicas
- 📊 Principios SOLID aplicados
- 🚀 Escalabilidad futura
- 🤔 Cualquier otro aspecto del proyecto

---

**¡Muchas gracias!**

---

## DIAPOSITIVAS DE RESPALDO (Para preguntas específicas)

### RESPALDO 1: Complejidad del Proyecto

**Métricas del Código:**
- **Clases:** 15+ clases Java
- **Paquetes:** 5 paquetes organizados
- **Líneas de código:** ~2000+ LOC
- **Interfaces:** 2 interfaces definidas
- **Jerarquías:** 3 jerarquías de herencia

**Complejidad:**
- Patrón Template Method
- Patrón Facade
- Patrón Strategy
- Polimorfismo en múltiples niveles

---

### RESPALDO 2: Comparación con Alternativas

**¿Por qué no usar Excel?**
- ❌ Sin validaciones automáticas
- ❌ Propenso a errores humanos
- ❌ No tiene lógica de negocio
- ❌ Difícil de mantener

**¿Por qué no usar software existente?**
- 💰 Software comercial es costoso
- 🎓 Propósito educativo
- 🎯 Personalización específica
- 🔧 Control total del código

---

### RESPALDO 3: Desafíos Enfrentados

**Retos Técnicos:**
1. Diseño de la arquitectura en capas
2. Implementación de carritos temporales
3. Sincronización de stock entre carrito y producto
4. Validación de reglas de negocio complejas
5. Manejo de serialización de objetos

**Soluciones:**
- Planificación detallada del diagrama UML
- Uso de listas temporales y banderas
- Validaciones en múltiples niveles
- Testing exhaustivo de casos de uso

---

### RESPALDO 4: Testing y Validación

**Pruebas Realizadas:**

**Casos de Prueba Exitosos:**
- ✅ Registro de todas las entidades
- ✅ Transacciones con múltiples productos
- ✅ Validación de stock insuficiente
- ✅ Persistencia y recuperación de datos
- ✅ Comprobantes generados correctamente

**Casos de Prueba de Error:**
- ✅ IDs duplicados rechazados
- ✅ Mezcla de proveedores/clientes prevenida
- ✅ Campos vacíos validados
- ✅ Valores negativos rechazados

---

### RESPALDO 5: Comparación Antes/Después

**Antes del Sistema:**
- 📝 Registro manual en cuadernos
- ⏰ ~30 minutos por transacción
- ❌ Errores frecuentes en stock
- 💸 Pérdidas por descontrol

**Después del Sistema:**
- 💻 Registro digital automatizado
- ⚡ ~2 minutos por transacción
- ✅ Stock siempre preciso
- 📊 Control total de operaciones

**Mejora:** ~93% reducción en tiempo de proceso

---

## NOTAS PARA LA PRESENTACIÓN

### Tiempo Estimado: 20-25 minutos

**Distribución:**
- Introducción (3 min)
- Contexto y objetivos (2 min)
- Arquitectura y diseño (5 min)
- Principios SOLID (4 min)
- Demostración en vivo (6 min)
- Conclusiones y futuro (3 min)
- Preguntas (5-10 min)

### Tips de Presentación:

1. **Inicio:** Captar atención con el problema real
2. **Desarrollo:** Mostrar código específico en diapositivas clave
3. **Demo:** Preparar datos de prueba previamente
4. **Cierre:** Enfatizar logros y aprendizajes

### Preparación para Demo:

- Tener datos de prueba listos
- Backup del archivo tienda.bin
- NetBeans abierto con el código
- Terminal lista para mostrar estructura
