package sivamani.AbstractC;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sivamani.PageObjectModel.Settings;

public class AbstracComponents {
	WebDriver driver;
	public Actions actions;
	public AbstracComponents(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".MuiAlert-message")
	WebElement msg;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement myorder;
	
	@FindBy(xpath="(//div[@class='navigator_icon__qPF3K'])[7]")
	WebElement settingIcon;
	
	

	public void waitForElementToAppear(By findby) throws InterruptedException
	{
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.presenceOfElementLocated(findby));
		//Thread.sleep(5000);
	}
	public void waitForWebElementToAppear(WebElement findby)
	{
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public void waitForElementToDisapper(WebElement ele)
	{
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void waitForElementToDisappear(WebElement ele)
	{
	    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	    w.until(ExpectedConditions.invisibilityOf(ele));
	}
   public Settings goToSettingsPage()
   {
	   actions = new Actions(driver);
		actions.moveByOffset(0, 100);
	   settingIcon.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.urlContains("#/layout"));
	   Settings st=new Settings(driver);
	   return st;
   }


}
