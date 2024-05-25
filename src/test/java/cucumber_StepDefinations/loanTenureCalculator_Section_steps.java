package cucumber_StepDefinations;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import cucumber_Factory.cucumber_BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loanTenureCalculator_Section_steps {

	WebDriver driver = cucumber_BaseClass.getDriver();
	HomePage hp = new HomePage(driver);

	SoftAssertions softAssertions = new SoftAssertions(); // soft assertion for junit

	@Given("user click on Calculators Section in home page for fourth test scenario")
	public void user_click_on_calculators_section_in_home_page_for_fourth_test_scenario() {
		cucumber_BaseClass.getLogger().info("----------------- Test scenario 4 Started ----------------------");
		try {
			hp.click_calculators();
			cucumber_BaseClass.getLogger().info("click on calculators");

		}catch(Exception e) {
			cucumber_BaseClass.getLogger().info("click is not done on calculators");
			Assert.fail();
		}
	}

	@When("Click on Loan Calculator")
	public void click_on_loan_calculator() {
		try {
			hp.loan_Calculator();
			cucumber_BaseClass.getLogger().info("click on loan calculator");

		}catch(Exception e) {
			cucumber_BaseClass.getLogger().info("click on loan calculators is not done");
			Assert.fail();
		}
	}

	@When("User click on loan tenure calculator scetion")
	public void user_click_on_loan_tenure_calculator_scetion() {
		try {
			hp.loanTenureCalculatorClick();
			cucumber_BaseClass.getLogger().info("click on loan tenure calculator window");

		}catch(Exception e) {
			cucumber_BaseClass.getLogger().info("click on loan tenure calculator window is not clicked");
			Assert.fail();
		}
	}

	@Then("Validate all the textboxes present in this section")
	public void validate_all_the_textboxes_present_in_this_section() {
		
		
		try {
			boolean t3=hp.loan_amount();
			softAssertions.assertThat(t3).as("Loan Amount TextBox is not Working").isEqualTo(true);
			cucumber_BaseClass.getLogger().info("Loan Amount TextBox is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("Loan Amount TextBox is not Checked");
		}
		
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
			boolean t4=hp.loanFeesBox();
			softAssertions.assertThat(t4).as("Fees And Charges TextBox is not Working").isEqualTo(true);
			cucumber_BaseClass.getLogger().info("Fees And Charges TextBox is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("Fees And Charges TextBox is not checked");
		}
	}

	@Then("Validate all the sliders present in this section")
	public void validate_all_the_sliders_present_in_this_section() {
		
		try {
			boolean s3=hp.loanAmount_slider_check();
			softAssertions.assertThat(s3).as("LoanAmount Slider is not Working").isEqualTo(false);
			cucumber_BaseClass.getLogger().info("LoanAmount Slider is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("LoanAmount Slider is not checked");
		}
		
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
			boolean s4=hp.loanFeesCalculatorLoanAmountSliderCheck();
			softAssertions.assertThat(s4).as("LoanFees Slider is not Working").isEqualTo(false);
			cucumber_BaseClass.getLogger().info("LoanFees Slider is checked");
		} catch (Exception e) {
			cucumber_BaseClass.getLogger().info("LoanFees Slider is not checked");
		}
		finally {
			cucumber_BaseClass.getLogger().info("-------------- Test scenario 4 is Completed--------------------->>>>>>>>>>>>");
			softAssertions.assertAll();
		}
	}



}
