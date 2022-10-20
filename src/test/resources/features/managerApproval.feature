Feature: Manager Approval

  Scenario: T-10 Manager Approves Request
    Given the manager is logged in on the home page
    When the manager clicks "details" for a test case
    Then the manager should be on a request page populated with the correct information
    Then the manager should have access to the manager-only tools
    When the manager updates the request status to "Approved -- Pending Grade"
    When the manager clicks the Confirm Changes button
    Then the request should update with the new information



  Scenario: T-11 Manager Alters Request Amount Beyond Maximum
    Given the manager is logged in on the home page
    When the manager clicks "details" for a test case
    When the manager enters "100000" into the new Requested Funds input
    When the manager clicks the Confirm Changes button
    Then an alert with the text "This new amount exceeds the employee's allotted funds. Continue?" should appear
    When the employee confirms the alert
    Then the request should update with the new amount, and the Exceeds Funds box should be checked




  Scenario: T-12 Requester is Notified When Request Amount Altered
    Given the employee is logged in on the home page
    When the manager clicks "details" for a test case
    Then an alert should appear notifying the employee of the altered request