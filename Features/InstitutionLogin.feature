Feature: feature to test login functionality
  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    When user is on login page
    And user enters <username> and <password>
    When clicks on login button
    Then user is navigated to the home page
    Examples:
      | username | password |
      | preade@enovacom.fr | Operations2022# |
      | enovacome@enovacom.fr | Qualification2022# |
