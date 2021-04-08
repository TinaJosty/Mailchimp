Feature: registration
  In order to join the community I need to create an account



  Scenario: Create user
    Given User have navigated to signup page at mailchimp
    And User has typed the <mailAddress>
    And User has typed the <username>
    And User has chosen a <password>
    And User has rejected <cookies>
    When User has pressed the <Sign Up Button>
    Then Account should be created and <Verified>



    Scenario: Create user with long username(<100)

      Scenario: Create users with username already existing
        Scenario: Create users without an email