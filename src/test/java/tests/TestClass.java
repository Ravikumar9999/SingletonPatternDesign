package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mypackage.Constants;
import mypackage.TestBase;

public class TestClass {
	
	@BeforeMethod
	public void setUp() {
		TestBase.initialize();
	}
	
	
	@Test(priority=1)
	public void verifyTitleTest() {
		String title = TestBase.driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.loginPageTitle);
	}
	
	
	@Test(priority=2)
	public void logoTest() {
		Assert.assertEquals(TestBase.driver.findElement(By.className("img-responsive")).isDisplayed(), true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		TestBase.quit();
	}

}
