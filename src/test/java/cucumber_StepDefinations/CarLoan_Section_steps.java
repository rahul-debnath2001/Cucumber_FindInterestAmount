package cucumber_StepDefinations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import PageObjects.HomePage;
import Utilities.ExcelUtility;
import cucumber_Factory.cucumber_BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarLoan_Section_steps {
	
	WebDriver driver = cucumber_BaseClass.getDriver();
	
	HomePage hp;
	String p_amount = "";
	String rate = "";
	String tenure = "";
	
	@Given("User click on Car Loan Section in home page")
	public void user_click_on_car_loan_section_in_home_page() {    
		hp = new HomePage(driver);
		
		cucumber_BaseClass.getLogger().info("--------------- Start Test Scenario 1 ---------------");
		
		try {
			hp= new HomePage(driver);
			//click on carloan
			hp.clickCarLoan();
			cucumber_BaseClass.getLogger().info("Car loan button clicked");
		}
		catch(Exception e) {
			cucumber_BaseClass.getLogger().info("Car loan button is not clicked");
			Assert.fail();
		}
	}
	

	@When("user enter car loan amount {string} and interest rate {string} and loan tenure {string}")
	public void user_enter_car_loan_amount_amount_and_interest_rate_roi_and_loan_tenure_year(String amount, String roi, String year) {	    
		p_amount = amount;
		rate = roi;
		tenure = year;		
		try {
			hp.setLoanAmount(amount);
			cucumber_BaseClass.getLogger().info("Loan Amount is set");

			
			hp.setInterest(roi);
			cucumber_BaseClass.getLogger().info("rate of interest is set");

			
			hp.setLoanTenure(year);
			cucumber_BaseClass.getLogger().info("loan tenure is set");
			}
			catch(Exception e)
			{
				cucumber_BaseClass.getLogger().info("all entity is not set properly");
				Assert.fail();
			}		
	}

	@Then("user fetch the principal amount and interest amount for one month")
	public void user_fetch_the_principal_amount_and_interest_amount_for_one_month() {	
		try {
			if(hp.fetch_emiData(p_amount, tenure))
			{
				Assert.assertTrue(true);
				cucumber_BaseClass.getLogger().info("emi data fetched");
			}
			else
			{
				cucumber_BaseClass.getLogger().info("emi data is not fetched");
				Assert.fail();
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Then("emi data should fetch in excel file")
	public void emi_data_should_fetch_in_excel_file() throws IOException {	
		ExcelUtility eu = new ExcelUtility();
		if(eu.getCellData("sheet1", 1, 0).equals("") && eu.getCellData("sheet1", 1, 1).equals("") && eu.getCellData("sheet1", 1, 2).equals("")){
			cucumber_BaseClass.getLogger().info("data is not fetched in excel file");
			cucumber_BaseClass.getLogger().info("--------------- Test Scenario 1 completed ---------------");
			Assert.fail();
		}
		else {
			Assert.assertTrue(true);
			cucumber_BaseClass.getLogger().info("data fetched in excel file");
			cucumber_BaseClass.getLogger().info("--------------- Test Scenario 1 completed ---------------");
		}
	}
}