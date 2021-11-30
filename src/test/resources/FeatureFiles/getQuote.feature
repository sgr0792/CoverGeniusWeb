Feature: Verify if User is able to get an estimation for any 4*4 vehicle type on any future day.
  @TestCase01
  Scenario: Verify if user is able to get the instant quote for a future date for 4*4 vehicle type.
    Given I launch the browser and open the Cover Genius portal
    And I fill the form country field with "United States"
    And I enter the From Date "30/November/2021" and To Date "15/December/2021"
    When I Verify the Vehicle Type and select 4*4 if it is available
    Then I Click on Get Instant Quote Button and Verify the policy information page