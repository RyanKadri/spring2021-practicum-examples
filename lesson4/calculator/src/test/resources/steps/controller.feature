Feature: Math Controller
  Scenario: I can parse an expression
  Given that my server is started
  When a user passes the expression "1 + 2"
  Then the result should be 3