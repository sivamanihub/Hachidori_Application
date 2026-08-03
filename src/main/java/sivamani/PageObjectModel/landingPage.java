package sivamani.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class landingPage {

	WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
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
		driver.get("http://10.76.41.148/WEB APP/index.html");
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
