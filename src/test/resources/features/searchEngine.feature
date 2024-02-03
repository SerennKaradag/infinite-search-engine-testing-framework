Feature: As a user, User should be able to search youtube in search engine

  Scenario Outline: Search for a item in different search engines
    Given User open the browser
    When user search for "<searchItem>" on "<searchEngine>"
    Then first result should contain "<expectedResult>" on "<searchEngine>"
    Examples:
      | searchItem | searchEngine | expectedResult |
      | youtube    | google       | YouTube        |
      | youtube    | bing         | YouTube        |
      | youtube    | yahoo        | YouTube        |

