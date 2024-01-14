Feature: As a user I want to test the reservation functionality in the booking app

  Scenario: Successful reservation test
    Given I enter the booking app without logging in
    When I look for accommodation with the following information
      | Destination | Checkin       | Checkout        | Rooms Number | Adults Number | Children Number | Children age |
      | Cusco       | 20 enero 2024 | 03 febrero 2024 | 1            | 2             | 1               | 5 años       |
    And select item 2 And I choose the first room
    And Diligence of personal information
      | Firtsname | Lastname | Email            | Address         | Zip code | City     | Country  | Mobile        | Trip reason |
      | Emilia    | Molina   | pruebas@yape.com | Calle falsa 123 | 050001   | Medellin | Colombia | +573214785123 | Negocios    |
    And Enter payment information
      | Card name     | Card number      | Due date |
      | Emilia Molina | 4000000000001000 | 0525     |
    Then The reservation will be created correctly