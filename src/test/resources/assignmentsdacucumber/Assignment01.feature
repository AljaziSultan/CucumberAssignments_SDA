Feature: User Registration

  Scenario: Register a new user using fluent page object approach
    Given I am on the registration page
    When I enter valid registration details
    And I submit the registration form
    Then I should see a successful registration message
#
#    Examples:
#      | Field         | Value                                           |
#      | ------------- | ----------------------------------------------- |
#      | First Name    | Sara                                            |
#      | Last Name     | Sul                                             |
#      | Email         | sarasul@hotmail.com                             |
#      | Telephone     | +966555055                                      |
#      | Password      | Apassword                                       |
#      | Confirm Pwd   | Apassword                                       |
