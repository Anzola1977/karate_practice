Feature: Testing get requests

  Background:
    * url 'https://api.restful-api.dev/'

  Scenario: Testing get list of all objects
    Given path '/objects'
    When method get
    Then status 200
    And match $..id == '#[13]'

  Scenario: Testing get list of all objects by IDs
    Given path '/objects/12'
    When method get
    Then status 200
    And match $..data.Capacity == ["64 GB"]
    And match $..data.Price == ["419.99"]
    And match $..[?(@.id==12)].name == ["Apple iPad Air"]

  Scenario: Contract testing by objects ID
    Given path '/objects/12'
    When method get
    Then status 200
    And match response == { "id": "#string", "name": "#string", "data": {"Generation": "#string","Price": "#string","Capacity":"#string" }}

