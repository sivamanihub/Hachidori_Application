package sivamani.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sivamani.AbstractC.AbstracComponents;

public class MapGeneratePage extends AbstracComponents {

	
	
    WebDriver driver;
	public Actions actions;
	
	public MapGeneratePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//div[@class='navigator_icon__qPF3K'])[2]")
	WebElement MapGenerateIcon;
	
	@FindBy(css = ".MuiButtonBase-root")
	WebElement creatMapBtn;
	
	@FindBy(xpath = "(//div[@class='relative'])[1]")
	WebElement NodeIcon;
	
	@FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[3]")
	WebElement pathIcon;
	
	@FindBy(css=".konvajs-content")
	WebElement PageCanvas;
	
	@FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[21]")
	WebElement addPathBtn;
	
	@FindBy(xpath="(//input[@type='checkbox'])[4]")
	WebElement specialButEnab;
	
	@FindBy(xpath="(//input[@type='checkbox'])[4]")
	WebElement Bidirection;
	
	@FindBy(xpath="(//button[@type='button'])[15]")
	WebElement updateBtn;
	
	@FindBy(xpath="(//button[@type='button'])[10]")
	WebElement upload;
	
	@FindBy(xpath="//div[contains(@class,'MuiAlert-message')]")
	WebElement mapcreatedMsg;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement deletingmap;
	
	@FindBy(xpath = "(//button[@type='button'])[11]")
	WebElement popupYesBtn;
	
	@FindBy(xpath="//div[contains(@class,'MuiAlert-message')]")
	WebElement mapDeletedMsg;

	
	By msgOpenMapGen=By.cssSelector(".MuiAlert-message");
	By mapcreMsg=By.xpath("//div[contains(@class,'MuiAlert-message')]");
	By deletBtn=By.xpath("(//button[@type='button'])[3]");
	
	
	public String createMap() throws InterruptedException {
		actions = new Actions(driver);
		//waitForElementToAppear(msgOpenMapGen);
		MapGenerateIcon.click();
		creatMapBtn.click();
		NodeIcon.click();
		
	actions.moveToElement(PageCanvas, 100, 180).click().perform();
	actions.moveToElement(PageCanvas, 150, 180).click().perform();
	actions.moveToElement(PageCanvas, 150, 180).click().perform();
	specialButEnab.click();
	updateBtn.click();
	pathIcon.click();
	actions.moveToElement(PageCanvas, 100, 180).click().perform();
	actions.moveToElement(PageCanvas, 150, 180).click().perform();
	Bidirection.click();
    addPathBtn.click();
    upload.click();
    waitForElementToAppear(mapcreMsg);
    
    return  mapcreatedMsg.getText();
	
	}
	
	public String deletMap() throws InterruptedException
	{
		MapGenerateIcon.click();
		//waitForElementToAppear(deletBtn);
		deletingmap.click();
		popupYesBtn.click();
		return mapDeletedMsg.getText();
	
	}
	
	
	
	
}
