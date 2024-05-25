package cucumber_StepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber_Factory.cucumber_BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	WebDriver driver;
	Properties p;

	@Before
	public void setup() throws IOException, InterruptedException
	{
		driver=cucumber_BaseClass.initilizeBrowser();	
		p=cucumber_BaseClass.getProperties();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(p.getProperty("openURL"));


	}


	@After
	public void tearDown(Scenario scenario) {

		driver.quit();

	}


	@AfterStep
	public void addScreenshot(Scenario scenario) {

		// this is for cucumber junit report
		if(scenario.isFailed()) {

			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());

		}

	}

}
