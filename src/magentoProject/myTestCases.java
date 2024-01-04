package magentoProject;

import java.awt.Color;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLDivElement;

public class myTestCases extends Myparameters {

	@BeforeTest

	public void MySetUp() {
		BeforeT();
	}

	@Test(priority = 1)
	public void SignUpTest() throws InterruptedException {

		boolean ActualResult = Signup();
		Thread.sleep(3000);
		Assert.assertEquals(ActualResult, true, "this is to check if Welcome msg is there or no ");

	}

	@Test(priority = 3)
	public void LogInTest() throws InterruptedException {
		boolean ActualResult = Login();
		Thread.sleep(5000);
		Assert.assertEquals(ActualResult, true);
	}

	@Test(priority =2)

	public void LogOut() throws InterruptedException {
		Thread.sleep(5000);
		boolean result = LogoutMethod();

		Assert.assertEquals(result, true);

	}

	@Test(priority = 2,enabled = false)
	public void AddTheFirstItemfromMenJaket() throws InterruptedException {

		boolean result = AddFirstJaket();
		Assert.assertEquals(result, true);

	}

	////////// ***********////////////
	@Test(priority = 4)
	public void AddAllItems() throws InterruptedException {
//add all jackets from men jackets category 
		boolean result = AddAllitemsJaketMen();
		Assert.assertEquals(result, true);

	}

	@AfterTest
	public void Aftertest() {
		// driver.close();
	}

}
