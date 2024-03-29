Feature: Post requests

  Background:
    * url 'https://api.restful-api.dev/'
    Given header Content-Type = 'application/json'
    * def helper = Java.type('org.example.DataHelper')

  Scenario: Testing post object
    Given path '/objects'
    * def entity = helper.createEntityData()
    And request entity
    When method post
    Then status 200

    * def entity = helper.getEntityPostMap(entity)
    * def entityResponse = helper.getEntityCreatedMap()

    * def message = helper.printMessage(response)

    And match response contains entity
    And match $.name == entity.name
    And match $.data == entity.data
    And match response contains entityResponse
    And match $.id == entityResponse.id
    And match $.createdAt == entityResponse.createdAt

    * def realResponse = response

    And call read('@getEntity') realResponse, entity

  @ignore @getEntity
  Scenario: Testing put object
    Given path '/objects/' + realResponse.id
    * def entity = helper.updateEntityData()
    And request entity
    When method put
    Then status 200

    * def entity = helper.getEntityPostMap(entity)
    * def entityResponse = helper.getEntityUpdatedMap()

    And match response contains entity
    And match $.name == entity.name
    And match $.data == entity.data
    And match response contains entityResponse
    And match $.id == entityResponse.id
    And match $.updatedAt == entityResponse.updatedAt

  @ignore @getEntity
  Scenario: Testing patch object
    Given path '/objects/' + realResponse.id
    * def entity = helper.patchEntityData()
    And request entity
    When method patch
    Then status 200

    * def entity = helper.getEntityPostMap(entity)
    * def entityResponse = helper.getEntityUpdatedMap()

    And match response contains entity
    And match $.name == entity.name
    And match $.data == entity.data
    And match response contains entityResponse
    And match $.id == entityResponse.id
    And match $.updatedAt == entityResponse.updatedAt

  @ignore @getEntity
  Scenario: Testing delete object
    Given path '/objects/' + realResponse.id
    And request entity
    When method delete
    Then status 200
    And match $.message == "Object with id = " + realResponse.id + " has been deleted."