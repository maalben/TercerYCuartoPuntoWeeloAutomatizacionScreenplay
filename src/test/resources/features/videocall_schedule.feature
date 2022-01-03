Feature: Realizar programacion de videollamadas en millionandup.com

  Description:
  Yo como automatizador de pruebas
  Necesito automatizar el flujo de programacion de videollamadas
  Para validar que se realice de manera exitosa

  Background:
    Given Yo Ingreso a la pagina de programacion de videollamadas millionandup


  @CP001
  Scenario Outline: Validar agendamiento exitoso de videollamada
    And Yo cargo los datos del estudiante
      | dateVideocall   | timeVideocall   | email   | name   | mobilePhone   |
      | <dateVideocall> | <timeVideocall> | <email> | <name> | <mobilePhone> |
    When Yo diligencio toda la informacion para la programacion de la videollamada
    Then Yo verifico que se muestre el mensaje "Your Project presentation was scheduled successfully. One of our agents will contact you shortly to provide details."

    Examples:
      | dateVideocall | timeVideocall | email            | name        | mobilePhone |
      | 22-03-2022    | 1 PM          | pedro@correo.com | Pedro Pablo | 3003121223  |


  @CP002
  Scenario Outline: Validar mensaje de error al seleccionar fecha antes de la actual para agendar videollamada
    And Yo cargo los datos del estudiante
      | dateVideocall   | email   | name   | mobilePhone   |
      | <dateVideocall> | <email> | <name> | <mobilePhone> |
    When Yo diligencio informacion de programacion de la videollamada sin hora
    Then Yo deberia ver el mensaje de error "Tour time is required"

    Examples:
      | dateVideocall | email            | name        | mobilePhone |
      | 10-12-2021    | pedro@correo.com | Pedro Pablo | 3003121223  |


  @CP003
  Scenario Outline: Validar mensaje de error cuando no se diligencie el email para agendar videollamada
    And Yo cargo los datos del estudiante
      | dateVideocall   | timeVideocall   | name   | mobilePhone   |
      | <dateVideocall> | <timeVideocall> | <name> | <mobilePhone> |
    When Yo diligencio informacion de programacion de la videollamada sin email
    Then Yo deberia ver el mensaje de error referente al email "Register to enter site"

    Examples:
      | dateVideocall | timeVideocall | name        | mobilePhone |
      | 10-12-2021    | 1 PM          | Pedro Pablo | 3003121223  |