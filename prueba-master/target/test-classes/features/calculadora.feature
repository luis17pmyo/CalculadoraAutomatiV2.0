# language: en
Feature: Calculadora Básica
  Como usuario de la calculadora
  Quiero realizar operaciones matemáticas básicas
  Para obtener resultados correctos
 
  Background:
    Given que tengo una calculadora disponible
 
  Scenario: Suma de dos números
    Given que ingreso el número 5
    And que ingreso el número 3
    When realizo la operación suma
    Then el resultado debe ser 8
 
  
