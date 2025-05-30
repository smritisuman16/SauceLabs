Feature: Verify if the login properties are working fine


  @AllLogin
  Scenario Outline: Verify that user can login or not
    Given Navigate to url
    And Provide "<Username>" and "<Password>" to login
    And User logout from the website
    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
