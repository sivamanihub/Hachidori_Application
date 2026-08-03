package sivamani.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractC.AbstracComponents;

public class MapGeneratePage extends AbstracComponents {

	
	
   public WebDriver driver;
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
	
	By msgOpenMapGen=By.cssSelector(".MuiAlert-message");
	
	
	
	public void createNode() throws InterruptedException {
		actions = new Actions(driver);
		waitForElementToAppear(msgOpenMapGen);
		MapGenerateIcon.click();
		creatMapBtn.click();
		NodeIcon.click();
		
	actions.moveToElement(PageCanvas, 100, 180).click().perform();
	actions.moveToElement(PageCanvas, 150, 180).click().perform();
	pathIcon.click();
	actions.moveToElement(PageCanvas, 100, 180).click().perform();
	actions.moveToElement(PageCanvas, 150, 180).click().perform();
    addPathBtn.click();
	
	}
	
	
	
	
}
