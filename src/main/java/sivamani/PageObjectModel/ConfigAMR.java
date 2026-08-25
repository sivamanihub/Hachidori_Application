package sivamani.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sivamani.AbstractC.AbstracComponents;

public class ConfigAMR extends AbstracComponents {

	WebDriver driver;
	public ConfigAMR(WebDriver driver) {
		super(driver);
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class='navigator_icon__qPF3K'])[5]")
	WebElement ConfigAMR;
	@FindBy(xpath="//input[@autocomplete='new-password']")
	WebElement LoginField;
	
    @FindBy(xpath="(//button[@type='button'])[3]")
	WebElement LoginSbt;
	
    @FindBy(xpath="//span[text()='Configuration Workspace']")
    WebElement confirmthemsg;
    
    By loginField=By.xpath("//input[@autocomplete='new-password']");
	
	public  String LoginToConfigAMR(String roles) throws InterruptedException
	{
		ConfigAMR.click();
		waitForElementToAppear(loginField);
	    LoginField.sendKeys(roles);
	    LoginSbt.click();
	    return confirmthemsg.getText();
	}
	
	
}
