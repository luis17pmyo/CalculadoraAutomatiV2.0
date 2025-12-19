# Prueba Técnica: Implementación de Step Definitions con Cucumber BDD

## Objetivo
Implementar los step definitions necesarios para que las pruebas del feature `calculadora.feature` funcionen correctamente usando Cucumber con Java y Maven.

## Contexto del Proyecto
Este es un proyecto de pruebas BDD (Behavior Driven Development) que utiliza:
- **Java 8+**
- **Maven** como build tool
- **Cucumber** para BDD testing
- **AssertJ** para assertions
- **JUnit** como test runner

## Estructura del Proyecto
```
src/
├── main/java/com/pruebatecnica/
│   └── Calculadora.java          # Clase ya implementada
└── test/
    ├── java/com/pruebatecnica/
    │   ├── runners/
    │   │   └── TestRunner.java    # Runner ya configurado
    │   └── stepdefinitions/
    │       └── CalculadoraSteps.java  # ¡TU TAREA!
    └── resources/
        └── features/
            └── calculadora.feature    # Feature con scenarios
```

## Tu Tarea

### 1. Implementar Step Definitions (70 puntos)
Scenario Outline con múltiples ejemplos (variables a usar numero1,numero2,operacion,resultado_esperado)
Completa la clase `CalculadoraSteps.java` implementando todos los métodos necesarios para que pasen las pruebas definidas en `calculadora.feature`.

### 2. Casos de Prueba a Cubrir (30 puntos)
Tu implementación debe manejar:

- ✅ Operaciones básicas: suma, resta, multiplicación
- ✅ Validación de resultados esperados

### 3. Para compilar 
- mvn compile test-compile

### 4 . Para ejecutar los test

- mvn test -Dtest=CalculadoraTestRunner