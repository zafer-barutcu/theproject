Feature: dfsdf
  Background:
    Given the user in on the page
  @smoke @ersin @regression
    Scenario:
      Then user accept cookies
      Then user clicks login button
      Then enters username and password