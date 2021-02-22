#cucumber frame Work

Feature: Search Flights

# Scenario Outline: kayak Flight Search and select the nth flight
  Scenario Outline: kayak Flight Search and select the nth flight
    Given user is already on Kayak flights page
    When user enters  "<origin>" and  "<destination>" and "<startdate>" and "<returndate>" and user clicks on search
    Then user is shown search results
    And  Verify the origin and  destination of the "<n>" th result
    Then Close the browser

    Examples:
      | origin | destination | startdate | returndate | n |
      | San Francisco | Las Vegas McCarran | 05/08/2021 | 08/08/2021| 4 |
      | San Francisco | San Diego | 04/08/2021 | 07/08/2021| 3 |
