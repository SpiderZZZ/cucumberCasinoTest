Feature: Players list
  Check players list page

   Background:
      Given I am at casino login page with title "Dashboard - Casino"
      Given I fill the field "username" with value "admin1"
      Given I fill the field "password" with value "[9k<k8^z!+$$GkuP"
      Given I click the login button
      Then I should see admin navigation panel

   Scenario: Open players page and check it
      When I click to the menu "Users"
      And I click to the submenu "Players" in menu "Users"
      Then Players management page loaded

  Scenario: Players table sorting by registration date
      When I click to the menu "Users"
      And I click to the submenu "Players" in menu "Users"
      And Players management page loaded
      And Click on registration date column name
      Then Players table sorted by registration date completed correctly