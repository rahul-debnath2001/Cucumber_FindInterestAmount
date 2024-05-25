package cucumber_StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import cucumber_Factory.cucumber_BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeLoanEmiCalculator_Section_steps {

	WebDriver driver = cucumber_BaseClass.getDriver();
	HomePage hp;
	
	String homeValue = "";
	String homeDownPayment = "";
	String loanInsurance = "";
	String homeLoaninterest = "";
	String homeLoanTenure = "";
	String Loan_Fees = "";
	String oneTimeExpenses = "";
	String propertyTax = "";
	String HomeInsurance = "";
	String maintainance_expenses = "";
	String startMonth = "";
	String startYear = "";


	@Given("user click on Calculators Section in home page")
	public void user_click_on_calculators_section_in_home_page() {
		hp = new HomePage(driver);
		cucumber_BaseClass.getLogger().info("--------------- Start Test Scenario 2 ---------------");

		try {
			hp.click_calculators();
			cucumber_BaseClass.getLogger().info("click on calculators");
			Thread.sleep(1000);
		}
		catch(Exception e) {
			cucumber_BaseClass.getLogger().info("click on calculators is not done");
			Assert.fail();
		}
	}

	@And("click on Home Loan Emi calculator")
	public void click_on_home_loan_emi_calculator() {
		try {
			hp.click_HomeLoanEmiCalculator();	
			Thread.sleep(2000);	
			cucumber_BaseClass.getLogger().info("click on Home-Loan-Emi-Calculator");
			}
			catch(Exception e) {
				cucumber_BaseClass.getLogger().info("click on Home-Loan-Emi-Calculator is not done");
				Assert.fail();
			}
	}

	@When("user enter the home loan details {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_enter_the_home_loan_details(String home_Value ,String home_DownPayment ,String loan_Insurance ,
													String home_Loaninterest ,String home_LoanTenure ,String LoanFees, String home_StartMonth, String home_StartYear) {
		
		homeValue = home_Value;
		homeDownPayment = home_DownPayment;
		homeLoaninterest = home_Loaninterest;
		homeLoanTenure = home_LoanTenure;
		loanInsurance = loan_Insurance;
		Loan_Fees = LoanFees;
		startMonth = home_StartMonth;
		startYear = home_StartYear;
		
		//----------------------------------------------------------------------------------------
		try {
			hp.sendData_homeValue(homeValue);
			cucumber_BaseClass.getLogger().info("Home value set");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Home value is not set");
			Assert.fail();
		}
		//------------------------------------------------------------------------------------------
		try {
			hp.sendData_homeDownPayment(homeDownPayment);
			cucumber_BaseClass.getLogger().info("Home Down Payment set");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Home Down Payment is not set");
			Assert.fail();
		}
		//------------------------------------------------------------------------------------------
		try {
			hp.sendData_homeLoanInterest(homeLoaninterest);
			cucumber_BaseClass.getLogger().info("Home Interest rate is set");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Home Interest rate is not set");
			Assert.fail();
		}
		//------------------------------------------------------------------------------------------
		try {
			hp.sendData_homeLoanTenure(homeLoanTenure);
			cucumber_BaseClass.getLogger().info("Home Loan Tenure is set");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Home Loan Tenure is not set");
			Assert.fail();
		}
		//------------------------------------------------------------------------------------------
		try {
			hp.sendData_LoanInsurance_AND_LoanFees(loanInsurance, Loan_Fees);
			cucumber_BaseClass.getLogger().info("Home Loan Insurance  & Loan Fees is set");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Home Loan Insurance & Loan Fees is not set");
			Assert.fail();
		}
		//------------------------------------------------------------------------------------------
		try {
			hp.sendData_Date(home_StartMonth.substring(0, 3),home_StartYear);
			cucumber_BaseClass.getLogger().info("Start date is set");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Start date is not set");
			Assert.fail();
		}
		//------------------------------------------------------------------------------------------
	}

	@And("user enter home owner expences {string} {string} {string} {string}")
	public void user_enter_home_owner_expences(String one_TimeExpenses ,
												String property_Tax ,String Home_Insurance ,String maintainanceExpenses) {
		oneTimeExpenses = one_TimeExpenses;
		propertyTax = property_Tax;
		HomeInsurance = Home_Insurance;
		maintainance_expenses = maintainanceExpenses;
		
		try {
			hp.sendData_HomeOwnerExpenses(oneTimeExpenses, propertyTax, HomeInsurance, maintainance_expenses);
			cucumber_BaseClass.getLogger().info("Home Owner Expenses is set");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Home Owner Expenses is not set");
			Assert.fail();
		}
	}

	@Then("user fetch the table in the excel file")
	public void user_fetch_the_table_in_the_excel_file() {
		try {
			hp.fetch_table();
			cucumber_BaseClass.getLogger().info("Table Data fetched properly");
		}
		catch(Exception e)
		{
			cucumber_BaseClass.getLogger().info("Table Data is not fetched properly");
			Assert.fail();
		}
		finally {
			cucumber_BaseClass.getLogger().info("------------------------ Test Case 2 completed ------------------->>>>>>");
		}
	}




}
