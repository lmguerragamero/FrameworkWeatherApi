Feature: Consultar clima de una ciudad por su ID
  As un usuario
  I want consultar el clima de una ciudad por su id

  Scenario Outline: Consulta exitosa
    Given un usuario conoce la url para realizar la peticion a la api
    When quiere consultar el clima de una ciudad con <id> y key validos
    Then podra ver toda la informacion sobre el clima actual de la ciudad correspondiente

    Examples:
    |id     |
    |2172797|
    |3172797|
    |3172796|
    |18918  |
    |5574999|
