package cucumber_StepDefinations;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import cucumber_Factory.cucumber_BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanAmountCalculator_Section_steps {

	WebDriver driver = cucumber_BaseClass.getDriver();
	HomePage hp = new HomePage(driver);

	SoftAssertions softAssertions = new SoftAssertions(); // soft assertion for junit


	@Given("user click on Calculators Section in home page for Third test scenario")
	public void user_click_on_calculators_section_in_home_page_for_third_test_scenario() {

		cucumber_BaseClass.getLogger().info("----------------- Test Case 3 Started ----------------------");
		try {
			hp.click_calculators();
			cucumber_BaseClass.getLogger().info("click on calculators");

		}catch(Exception e) {
			cucumber_BaseClass.getLogger().info("click is not done on calculators");
			Assert.fail();
		}
	}

	@When("click on Loan Calculator")
	public void click_on_loan_calculator() {
		try {
			hp.loan_Calculator();
			cucumber_BaseClass.getLogger().info("click on loan calculator");

		}catch(Exception e) {
			cucumber_BaseClass.getLogger().info("click on loan calculators is not done");
			Assert.fail();
		}
	}

	@When("user click on loan amount calculator scetion")
	public void user_click_on_loan_amount_calculator_scetion() {
		try {
			hp.loanAmountCalculatorClick();
			cucumber_BaseClass.getLogger().info("click on loan Amount calculator window");

		}catch(Exception e) {
			Assert.fail();
			cucumber_BaseClass.getLogger().info("click on loan Amount calculator window is not done");
		}
	}

	@Then("validate all the textboxes present in this section")
	public void validate_all_the_textboxes_present_in_this_section() {
		try {
			boolean t1=hp.amountBox();
			softAssertions.assertThat(t1).as("Emi TextBox is not Working").isEqualTo(false);
			cucumber_BaseClass.getLogger().info("Emi TextBox is checked");
		}
		catch(Exception e){
			cucumber_BaseClass.getLogger().info("Emi TextBox is not checked");
		}

		try {
			boolean t2=hp.interestBox();
			softAssertions.assertThat(t2).as("Interest Rate TextBox is not Working").isEqualTo(true);
			cucumber_BaseClass.getLogger().info("Interest Rate TextBox is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("Interest Rate TextBox is not checked");
		}

		try {
			boolean t3=hp.loanTenureBox();
			softAssertions.assertThat(t3).as("Loan Tenure TextBox is not Working").isEqualTo(true);
			cucumber_BaseClass.getLogger().info("Loan Tenure TextBox is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("Loan Tenure TextBox is not checked");
		}

		try {
			boolean t4=hp.loanFeesBox();
			softAssertions.assertThat(t4).as("Fees And Charges TextBox is not Working").isEqualTo(true);
			cucumber_BaseClass.getLogger().info("Fees And Charges TextBox is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("Fees And Charges TextBox is not checked");
		}

//		finally {
//			softAssertions.assertAll();
//		}
	}

	@Then("validate year to month calculation in the loan tenure textbox")
	public void validate_year_to_month_calculation_in_the_loan_tenure_textbox() {
		int cal=hp.Tenure()*12; // convert year into month
		hp.Months(); // click on month
		//System.out.println(cal);
		int exp=hp.Tenure(); // again fetching the same text box but this time it is month
		//System.out.println(exp);
		try {
			assertEquals("Calculated Tenure Months And Expected Months Mismatched", exp, cal);  // aasert equals method for junit	
			cucumber_BaseClass.getLogger().info("year and month is checked");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("year and month mismatched");
			Assert.fail();
		}	
	}

	@Then("validate all the sliders present in this section")
	public void validate_all_the_sliders_present_in_this_section() {
		try {
			boolean s1=hp.emiCalculatorLoanAmountSliderCheck();
			softAssertions.assertThat(s1).as("EMI Slider is not Working").isEqualTo(false);
			cucumber_BaseClass.getLogger().info("Emi Slider is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("Emi Slider is not checked");
		}


		try {
			boolean s2=hp.interestCalculatorLoanAmountSliderCheck();
			softAssertions.assertThat(s2).as("Interest Slider is not Working").isEqualTo(true);
			cucumber_BaseClass.getLogger().info("Interest Slider is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("Interest Slider is not checked");
		}


		try {
			boolean s3=hp.loanTenureCalculatorLoanAmountSliderCheck();
			softAssertions.assertThat(s3).as("LoanTenure Slider is not Working").isEqualTo(false);
			cucumber_BaseClass.getLogger().info("LoanTenure Slider is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("LoanTenure Slider is not checked");
		}


		try {
			boolean s4=hp.loanFeesCalculatorLoanAmountSliderCheck();
			softAssertions.assertThat(s4).as("LoanFees Slider is not Working").isEqualTo(false);
			cucumber_BaseClass.getLogger().info("LoanFees Slider is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("LoanFees Slider is not checked");
		}
		finally {
			cucumber_BaseClass.getLogger().info("-------------- Test Case 3 is Completed--------------------->>>>>>>>>>>>");
			softAssertions.assertAll();
		}

	}

}

