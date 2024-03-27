
Feature: Web Page Navigation and Title Verification

  Scenario Outline: Navigate to a website and verify title

    Given the user navigates to "<page_url>"
    When the user waits for the page to load (5 seconds)
    Then the page title should contain the word "<title>"
    And the user closes the browser window

    Examples:
      | page_url                                       | title                               |
      | https://www.google.com                           | Google                                 |
      | https://www.amazon.com                           | Amazon                                |
      | https://www.youtube.com                          | YouTube                               |
      | https://www.wikipedia.org                        | Wikipedia