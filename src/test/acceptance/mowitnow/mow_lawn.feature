Feature: Mow a lawn
  As a gardener
  I want to mow the lawn
  So that I can keep my garden tidy

  Scenario: go east twice
    Given a mower in 0,0 facing north
    When I pivot the mower to the right
    And I move the mower
    And I move the mower
    Then the mower should be in 2,0 facing east

  Scenario: go north once
    Given a mower in 0,0 facing north
    When I move the mower
    Then the mower should be in 0,1 facing North

  Scenario: pivot left and move
    Given a mower in 1,2 facing north
    When I pivot the mower to the left
    And I move the mower
    Then the mower should be in 0,2 facing west

  Scenario: first expectation given by client
    Given a mower in 1,2 facing north
    When I pivot the mower to the left
    And I move the mower
    And  I pivot the mower to the left
    And I move the mower
    And  I pivot the mower to the left
    And I move the mower
    And  I pivot the mower to the left
    And I move the mower
    And I move the mower
    Then the mower should be in 1,3 facing north

  Scenario: second expectation given by client
    Given a mower in 3,3 facing east
    When I move the mower
    And I move the mower
    And I pivot the mower to the right
    And I move the mower
    And I move the mower
    And I pivot the mower to the right
    And I move the mower
    And I pivot the mower to the right
    And I pivot the mower to the right
    And I move the mower
    Then the mower should be in 5,1 facing east


