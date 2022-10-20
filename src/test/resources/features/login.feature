Feature: Login

  Scenario Outline: T-01 Login/Privacy with Valid Credentials
    Given the user is on the login page
    When the user types "<email>" into the email field
    When the user types "<pass>" into the password field
    When the user clicks the login button
    Then the <role> should see the cases they have access to

    Examples:
      | email             | pass           | role     | id     |
      | bigboss@corpo.org | hunter2        | Manager  | 1      |
      | john@corpo.org    | john1234       | Employee | 2      |
      | secure@corpo.org  | Z34w!o&(4Hbwe4 | Employee | 3      |

  Scenario: T-02 Failed Login with Invalid Credentials
    Given the user is on the login page
    When the user types 'asd123' into the email field
    When the user types 'passpass' into the password field
    When the user clicks the login button
    Then the user should receive an alert prompting them to try again




