Feature: registration
  In order to join the community I need to create an account


  Scenario Outline: Create user
    Given User have navigated to signup page at mailchimp
    * User has typed the mailaddress <mailAddress>
    * User has typed the username <username>
    * User has chosen a password
    * User has rejected cookies
    When User has pressed the Sign Up Button
    Then User should be shown appropriate <message>
    Examples:
      | mailAddress | username         | message            |
      | ValidEmail  | UserName         | Welcome            |
      | ValidEmail  | LongUserName<100 | ToLongErrorMessage |
      | NoEmail     | UserName         | EnterValueMessage  |
      | ValidEmail  | ExistingUserName | AlreadyUsedMessage |

