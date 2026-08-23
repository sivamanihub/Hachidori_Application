package sivamani.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sivamani.AbstractC.AbstracComponents;

public  class landingPage extends AbstracComponents {

	WebDriver driver;
	String ipaddress = "10.97.90.148";
	
	public landingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement psw;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtn;
	
	public void Goto()
	{
		driver.get("http://"+ipaddress+"/WEB APP/index.html");
	}
	
	public MapGeneratePage LoginApplication(String email,String password)
	{
		username.sendKeys(email);
		psw.sendKeys(password);
		loginBtn.click();
		MapGeneratePage mg=new MapGeneratePage(driver);
		return mg;
		
	}
	
	
	
	
}
