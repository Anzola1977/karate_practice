Feature: Post requests

  Background:
    * url 'https://api.restful-api.dev/'

  Scenario: Testing post object
    Given path '/objects'
    * def helper = Java.type('org.example.DataHelper')
    * def entity = helper.createEntityData()

    And header Content-Type = 'application/json'
    And request entity
    When method post
    Then status 200

    * def entity = helper.getEntityPostMap(entity)
    * def entityResponse = helper.getEntityCreatedMap()

  * def message = helper.printMessage(response)

    #получаем id сущности
    * def entityID = helper.getEntityCreatedMap().getId()

    And match response contains entityResponse
    And match $.name == entity.name
    And match $.data == entity.data

    * def realResponse = response

    And call read('@getEntities') realResponse, entity

    Scenario: Testing put object
      Given path '/objects/{id}'
      #пытаемся безуспешно использовать полученный выше id)
      And pathParam ("id", entityID)
      * def helper = Java.type('org.example.DataHelper')
      * def entity = helper.updateEntityData()

      And header Content-Type = 'application/json'
      And request entity
      When method put
      Then status 200

      * def entity = helper.getEntityPostMap(entity)
      * def entityResponse = helper.getEntityCreatedMap()

      And match response contains entityResponse
      And match $.name == entity.name
      And match $.data == entity.data