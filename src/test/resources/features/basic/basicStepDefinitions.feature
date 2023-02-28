Feature: As a user, i should be able to navigate to dashboard page and check if the buttons are working well respectively

  Background:
    Given the user navigates to elyt website
   @ddt @regression
  Scenario Outline: After navigation to website, checking whether the buttons are working respectively
    Then user clicks on cookies popup
    When user clicks "<headers>"
    Then user verifies that landed on "<headers>" page
   Examples:
    |headers|
    |influencers|
    |explore |
    |home |









