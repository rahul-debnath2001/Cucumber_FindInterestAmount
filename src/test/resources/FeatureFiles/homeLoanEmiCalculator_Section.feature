Feature: Home Loan Emi Calculator

  Scenario Outline: Fetch The Whole Tabular data Based on HOMELOAN emi data
    Given user click on Calculators Section in home page
    And click on Home Loan Emi calculator
    When user enter the home loan details "<Home Value>" "<Down Payment>" "<Loan Insurance>" "<Interest Rate>" "<Loan Tenure>" "<Loan fees&charges>" "<Start Month>" "<Start Year>"
    And user enter home owner expences "<One time Expence>" "<Property Tax>" "<Home Insurance>" "<Maintainance Expences>"
    Then user fetch the table in the excel file

    Examples: 
      | Home Value | Down Payment | Loan Insurance | Interest Rate | Loan Tenure | Start Month | Start Year | Loan fees&charges | One time Expence | Property Tax | Home Insurance | Maintainance Expences |
      |    5000000 |           50 |              0 |            10 |          10 | january     |       2027 |                 0 |                0 |            0 |              0 |                     0 |
