Feature: get a specific actor via ID

  Scenario Outline: Specific actor is fetched by ID
    Given the actor with id <actorID> exists
    When a get request is made to actor <actorID>
    Then the returned actor should have name "<firstName>" "<lastName>"
    Examples:
     | actorID  | firstName | lastName      |
     | 1        | PENELOPE  | GUINESS       |
     | 5        | JOHNNY    | LOLLOBRIGIDA  |
     | 13       | UMA       | WOOD          |
     | 53       | MENA      | TEMPLE        |
     | 79       | MAE       | HOFFMAN       |