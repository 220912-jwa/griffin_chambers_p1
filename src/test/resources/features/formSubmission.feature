Feature: Form Submission
  Scenario: T-07 Form Submits Successfully
    Given the employee is logged in on the home page
    When the employee clicks "Submit a New Request"
    When the employee enters "10252022" into the Event Date field
    When the employee enters "CS101 @ City College" into the Event Description field
    When the employee selects "University Course -- 80% Covered" from the Event Type dropdown
    When the employee enters "300.00" into the Event Amount field
    When the employee selects "Letter Grade (C to Pass) from the dropdown
    When the employee clicks the "Submit Request" button
    Then an alert describing success should appear


  Scenario: T-04 Employee Warned of Insufficient Funds
    Given there is no alert open
    Given the employee is logged in on the home page
    When the employee clicks "Submit a New Request"
    When the employee enters "11292022" into the Event Date field
    When the employee enters "New Car" into the Event Description field
    When the employee selects "Certification -- 100% Covered" from the Event Type dropdown
    When the employee enters "10000" into the Event Amount field
    When the employee clicks the Check If Enough Funds button
    Then the employee should receive an alert stating that their allotted funds are insufficient to fully fulfill the request

  Scenario: T-08 Form Collects Required Information
    ##this could be much more complicated, with a table that submits one null/inappropriate value per test
    Given the employee is logged in on the home page
    When the employee clicks "Submit a New Request"
    When the employee enters "11292022" into the Event Date field
    When the employee clicks the "Submit Request" button
    Then the employee should receive an alert and be prompted to fill in more information

