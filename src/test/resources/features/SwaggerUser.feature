Feature: Pruebas de servicio de la API Swagger User

  @crearPrimero
  Scenario: Crear un usuario con metodo POST
    Given que tengo un usuario con los siguientes datos 1091, "jperez", "Juan", "Perez", "jperez@gmail.com", "123456", "1234567890", 0
    When envio una peticion POST al endpoint users
    When envio una peticion GET al endpoint users
    Then la respuesta es 200
