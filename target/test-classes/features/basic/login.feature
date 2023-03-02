Feature: As a user, i should be able to login with different ways

  Background:
    Given the user navigates to elyt website
    Then user clicks on cookies popup
  @regression
  Scenario: login with metamask
    And user clicks on connect button
    Then clicks on show more button
    Then clicks on show less button
    #When clicks on Metamask option
    #Then lands on metamask page



   #@smoke
   #Scenario: Positive login scenario
    # Given the user on login page
     #Then enters user name and password
     #When click on login button
     #Then user lands on product page