Feature: Integridad del API de Store

  @crearYConsultar
  Scenario Outline: Creación de una nueva Order
    Given el endpoint POST order está disponible
    When se envía una solicitud POST al endpoint order con los siguientes datos:
      | orderId  | quantity | status  | shipDate                | complete |
      | <orderId> | <quantity> | <status> | <shipDate>              | <complete> |
    Then la respuesta debe tener un código de estado 200
    And la respuesta debe contener una Order con los mismos datos enviados

  Scenario Outline: Consulta de una Order existente
    Given el endpoint GET order está disponible
    And se ha creado una Order con id <orderId>
    When se envía una solicitud GET al endpoint order <orderId>
    Then la respuesta debe tener un código de estado 200
    And la respuesta debe contener la Order con id <orderId>
    And la Order debe tener los siguientes datos:
      | orderId  | quantity | status  | shipDate                | complete |
      | <orderId> | <quantity> | <status> | <shipDate>              | <complete> |

    Examples:
      | orderId | quantity | status  | shipDate                | complete |
      | 11793   | 2        | placed  | 2024-06-07T23:25:31.024Z | true     |
      | 11794   | 3        | placed  | 2024-07-07T23:25:31.024Z | true     |
      | 11795   | 4        | placed  | 2024-08-07T23:25:31.024Z | true     |
