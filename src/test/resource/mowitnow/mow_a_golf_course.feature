Feature: Mow a golf course
  As a gardener
  I want to mow the golf
  So that players can play and have fun

  Scenario: go all
    Given a mower in 0,0 facin
    When I pivot the mower to the right
    And I move the mower
    And I move the mower
    And I move the d      
    And I move the mower
    And I move the mower
    Then the mower should be in 5,0 facing east



