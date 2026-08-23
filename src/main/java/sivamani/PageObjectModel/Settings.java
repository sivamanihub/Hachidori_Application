package sivamani.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sivamani.AbstractC.AbstracComponents;

public class Settings extends AbstracComponents{

	WebDriver driver;
	
	public Settings(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@value='127.0.0.1']")
	WebElement ipadressChange;

	By ipac = By.xpath("//input[@value='127.0.0.1']");
	
	@FindBy(xpath="(//button[@tabindex='0' and @type='button'])[3]")
	WebElement ipadressSavebtn;
	@FindBy(xpath="//div[@role='presentation']")
	WebElement IpconfirmMsg;
	
	public String ConfigIpAddress() throws InterruptedException
	{
	
		
		ipadressChange.click();
		ipadressChange.sendKeys(Keys.CONTROL, "a");
		ipadressChange.sendKeys("10.97.90.148");
		ipadressSavebtn.click();
		waitForWebElementToAppear(IpconfirmMsg);
		
		return IpconfirmMsg.getText();
	}
	
	
	
}
