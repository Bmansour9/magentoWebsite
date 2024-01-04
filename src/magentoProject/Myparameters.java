package magentoProject;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Myparameters {

	String myWebsite = "https://magento.softwaretestingboard.com//";
	String myWebsite2 = "https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";
	WebDriver driver = new ChromeDriver();
	String firstName = "Batool";
	String lastName = "Mansour";
	String Password = "lifeIsgood#2023";
	String email = "batoansoh77@gmail.com";
	Random rand = new Random();

	public void BeforeT() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		driver.manage().window().maximize();
		driver.get(myWebsite);
	}

	public boolean Signup() throws InterruptedException {

		// to open sign up page
		WebElement SignUp = driver
				.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		SignUp.click();
		////// fill information and create account
		WebElement FirstN = driver.findElement(By.id("firstname"));
		WebElement LastN = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Passwordd = driver.findElement(By.id("password"));
		WebElement PasswordConfirm = driver.findElement(By.id("password-confirmation"));
		WebElement CreateAccount = driver.findElement(By.className("submit"));

		FirstN.sendKeys(firstName);
		LastN.sendKeys(lastName);
		Email.sendKeys(email);
		Passwordd.sendKeys(Password);
		PasswordConfirm.sendKeys(Password);
		CreateAccount.click();
		Thread.sleep(4000);
		String MyAccountLabel = driver.findElement(By.className("base")).getText();
		if (MyAccountLabel.contains("My Account")) {
			return true;
		} else {

			return false;
		}

	}

	public boolean Login() throws InterruptedException {

		WebElement LoginButton = driver.findElement(By.cssSelector("div[class='panel header'] li[data-label='or'] a"));
		LoginButton.click();
		Thread.sleep(3000);

		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("pass"));
		emailField.sendKeys(email);
		passwordField.sendKeys(Password);
		WebElement signInButton = driver.findElement(By.id("send2"));
		signInButton.click();
		Thread.sleep(5000);
		String ActualLabelWelcome = driver.findElement(By.className("logged-in")).getText();
		if (ActualLabelWelcome.contains("Welcome")) {
			return true;
		} else {
			return false;
		}
	}

public Boolean LogoutMethod() throws InterruptedException {
	WebElement dropListButton=driver.findElement(By.cssSelector(".action.switch"));
	dropListButton.click();
//	WebElement dropList=driver.findElement(By.cssSelector(".header.links"));
	Thread.sleep(2000);
	WebElement logoutButton=driver.findElement(By.className("authorization-link"));
	Thread.sleep(2000);
	logoutButton.click();

Thread.sleep(2000);
	String actualmsg = driver.findElement(By.className("authorization-link")).getText();
	
	if (actualmsg.contains("Sign In")) {
	return true;
}
	else {return false;
}
}


public boolean AddFirstJaket() throws InterruptedException {
	
	
	// open the link of men jacket category
	WebElement menDropList=driver.findElement(By.id("ui-id-5"));
menDropList.click();
Thread.sleep(2000);
WebElement JacketCategorie=driver.findElement(By.cssSelector("body > div:nth-child(5) > main:nth-child(4) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));
JacketCategorie.click();
Thread.sleep(2000);

	/// choose first item

	WebElement TheITemsContainer = driver.findElement(By.cssSelector(".products.list.items.product-items"));
	List<WebElement> allITems = TheITemsContainer.findElements(By.tagName("li"));

	allITems.get(0).click();
	Thread.sleep(2000);
/// choose size randomly
	WebElement SizeContainer = driver
			.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));

	List<WebElement> AllSized = SizeContainer.findElements(By.tagName("div"));

	int RandomSizeToSelect = rand.nextInt(AllSized.size());
	AllSized.get(RandomSizeToSelect).click();
	String ExpectedSized = AllSized.get(RandomSizeToSelect).getText();
	Thread.sleep(1000);
	String ActualSized = driver.findElement(
			By.cssSelector("div[class='swatch-attribute size'] span[class='swatch-attribute-selected-option']"))
			.getText();
	Assert.assertEquals(ActualSized, ExpectedSized);

	/// choose color randomly

	WebElement ColorContainer = driver
			.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));

	List<WebElement> AllColors = ColorContainer.findElements(By.tagName("div"));
	int RandomColor = rand.nextInt(AllColors.size());
	AllColors.get(RandomColor).click();
	Thread.sleep(3000);
	String ExpectedColor = AllColors.get(RandomColor).getAttribute("option-label");
	String ActualColor = driver
			.findElement(By.cssSelector(
					"div[class='swatch-attribute color'] span[class='swatch-attribute-selected-option']"))
			.getText();

	Assert.assertEquals(ActualColor, ExpectedColor, "test for color");

	/// add to cart
	WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
	addToCartButton.click();
	Thread.sleep(3000);
	WebElement Sucssmsg = driver
			.findElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
	
	
	if (Sucssmsg.getText().contains("added")) {
	
	
	return true;}
	else
	{return false;}
}
	
	 public boolean AddAllitemsJaketMen() throws InterruptedException {
		 driver.get(myWebsite2);
		 int ActualValueAdded=0;
			Thread.sleep(6000);
			WebElement CONproduct = driver.findElement(By.cssSelector(".products.list.items.product-items"));
			List<WebElement> ListOfProduct = CONproduct.findElements(By.cssSelector(".item.product.product-item"));

			for (int i = 0; i < ListOfProduct.size(); i++) {
				Thread.sleep(3000);
				int OldValueOfCart=Integer.parseInt(driver.findElement(By.className("counter-label")).getText());
				

				String ItemName=ListOfProduct.get(i).findElement(By.className("product-item-link")).getText().toUpperCase();
			
				Thread.sleep(3000);
				/// choose size randomly
				WebElement ContainerOfSizes = ListOfProduct.get(i).findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
				Thread.sleep(3000);
				List<WebElement> Sizes = ContainerOfSizes.findElements(By.className("swatch-option"));

				int RandomSize = rand.nextInt(Sizes.size());
				Sizes.get(RandomSize).click();
				Thread.sleep(3000);
				/// choose color randomly
				List<WebElement> ColorContainer = ListOfProduct.get(i).findElements(By.className("color"));

				int RandomColor = rand.nextInt(ColorContainer.size());
				ColorContainer.get(RandomColor).click();
				Thread.sleep(3000);

				// Now, find the element that appears after hovering
				WebElement AddToCartButton = ListOfProduct.get(i).findElement(By.className("tocart"));

				// Do something with the appearing element (e.g., click)
				AddToCartButton.click();
				
				Thread.sleep(5000);

				 ActualValueAdded=Integer.parseInt(driver.findElement(By.className("counter-label")).getText());
				Assert.assertEquals(ActualValueAdded,OldValueOfCart+1);
			}
			if(ActualValueAdded==ListOfProduct.size()) {return true;}
			else {return false;}
	}}
