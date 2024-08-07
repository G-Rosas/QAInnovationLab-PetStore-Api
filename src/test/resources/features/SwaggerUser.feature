Feature: Pruebas de servicio de la API Swagger User

  @crearPrimero
  Scenario: Crear un usuario con metodo POST
    Given que tengo un usuario con los siguientes datos 1091, "jperez", "Juan", "Perez", "jperez@gmail.com", "123456", "1234567890", 0
    When envio una peticion POST al endpoint users
    Then la respuesta es 200

  @crearVarios
  Scenario Outline: Crear un usuario con metodo POST
    Given que tengo los datos "<id>", "<username>", "<firstname>", "<lastName>", "<email>", "<password>", "<phone>", "<status>"
    When envio una peticion POST al endpoint users
    Then la respuesta es 200
    Examples:
      | id   | username  | firstname | lastname | email               | password | phone        | status |
      | 1092 | "jperez2" | "Juan"    | "Perez"  | "jperez2@gmail.com" | "123456" | "1234567890" | 0      |
      | 1093 | "jperez3" | "Juan"    | "Perez"  | "jperez3@gmail.com" | "123456" | "1234567890" | 0      |
