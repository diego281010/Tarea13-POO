# Sistema de Gestión de Personal para Clínica Privada

## Descripción

Sistema desarrollado en Java utilizando Programación Orientada a Objetos (POO) para gestionar médicos y administrativos de una clínica privada.

El sistema permite:
- Registrar empleados
- Mostrar registros
- Buscar por cédula
- Eliminar registros
- Calcular pagos
- Mostrar estadísticas
- Aplicar excepciones y validaciones

---

# Tecnologías usadas

- Java
- POO
- ArrayList
- Excepciones
- CRUD

---

# Estructura del proyecto

src/

├── modelo/

├── servicio/

├── util/

└── app/

---

# Conceptos aplicados

## Herencia

Las clases `Medico` y `Administrativo` heredan de la clase padre `Empleado`.

---

## Encapsulamiento

Los atributos son privados y se acceden mediante getters y setters.

---

## Polimorfismo

Se utiliza:

```
ArrayList<Empleado>
```

Para almacenar diferentes tipos de empleados.

---

## Excepciones

Se aplicó:
- try-catch
- NumberFormatException
- Exception

Para controlar errores en:
- menú
- conversiones
- entradas numéricas

---

## Conversiones

Se utilizaron:
```
Integer.parseInt()
Double.parseDouble()
```

---

## Validaciones

Se validó:
- correo
- teléfono
- edad
- cédula duplicada
- campos vacíos

---

# Funcionalidades

Registrar médicos

Registrar administrativos

Mostrar empleados

Buscar por cédula

Eliminar registros

Calcular pagos

Mostrar estadísticas

---

# Estadísticas implementadas

- Total médicos
- Total administrativos
- Total empleados
- Pago total médicos
- Pago total administrativos
- Empleado con mayor ingreso

---

# Autor

Diego Almeida