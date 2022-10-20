Feature: Grade Upload
  Scenario: T-16 Employee Uploads Grade
    Given the employee is logged in on the home page
    When the manager clicks "details" for a test case
    When the employee inputs "Pass" into the grade field
    When the employee clicks the Confirm Grade button
    Then the status of the case should change


  Scenario: T-17 Manager Confirms Passing
    Given the manager is logged in on the home page
    When the manager clicks "details" for a test case
    When the manager updates the request status to "Approved -- Funds Dispersed"
    When the manager clicks the Confirm Changes button
    Then the request should update with the new information
