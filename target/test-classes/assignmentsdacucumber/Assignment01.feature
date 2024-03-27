Feature: User Registration

  Scenario Outline: Register a new user using fluent page object approach
    Given I am on the registration page "https://ecommerce-playground.lambdatest.io/index.php?route=account/register"
    When I enter the following details:
      | Field         | Value                                           |
      | ------------- | ----------------------------------------------- |
      | First Name    | Jaz                                             |
      | Last Name     | Sul                                             |
      | Email         | jazsul@hotmail.com                              |
      | Telephone     | +966555555                                      |
      | Password      | Password                                        |
      | Confirm Pwd   | Password                                        |
    And I submit the registration form
    Then I should see a success message confirming registration

    Examples:
      | Field         | Value                                           |
      | ------------- | ----------------------------------------------- |
      | First Name    | Sara                                            |
      | Last Name     | Sul                                             |
      | Email         | sarasul@hotmail.com                             |
      | Telephone     | +966555055                                      |
      | Password      | Apassword                                       |
      | Confirm Pwd   | Apassword                                       |
