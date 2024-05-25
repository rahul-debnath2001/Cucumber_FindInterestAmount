Feature: Loan Amount Calculator Section under Loan Calculator

  Scenario Outline: Textbox & Slider check for Loan Amount Calculator Section
    Given user click on Calculators Section in home page for Third test scenario
    When click on Loan Calculator
    And user click on loan amount calculator scetion
    Then validate all the textboxes present in this section
    And validate year to month calculation in the loan tenure textbox
    And validate all the sliders present in this section
