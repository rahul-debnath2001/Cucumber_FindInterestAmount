Feature: Car Loan Section

  Scenario Outline: Fetch EMI for One Month
    Given User click on Car Loan Section in home page
    When user enter car loan amount "<amount>" and interest rate "<roi>" and loan tenure "<tenure>"
    Then user fetch the principal amount and interest amount for one month
    And emi data should fetch in excel file

    Examples: 
      | amount | roi | tenure |
      | 500000 |   5 |     10 |
