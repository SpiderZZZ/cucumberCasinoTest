Feature: Casino login
  Check casino login page

Scenario: Login at casino cabinet
   Given I am at casino login page with title "Dashboard - Casino"
   When I fill the field "username" with value "admin1"
   And I fill the field "password" with value "[9k<k8^z!+$$GkuP"
   And I click the login button
   Then User "admin1" is authorized
   And I should see admin navigation panel
