package selenium.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import sivamani.PageObjectModel.MapGeneratePage;
import sivamani.PageObjectModel.landingPage;

public class BaseTest {

	public WebDriver driver;
	public landingPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
				
		Properties prop=new Properties();
	    FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\sivamani\\Resorce\\GlobalData.properties");
	    prop.load(file);
	    
	    String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
	    
	    if(browserName.contains("chrome"))
	    {
	    	ChromeOptions co=new ChromeOptions();
	    	WebDriverManager.chromedriver().setup();
	    	if(browserName.contains("headless"))
	    	{
	    		co.addArguments("headless");
	    		co.addArguments("--headless=new");
	    		co.addArguments("--disable-gpu");
	    		co.addArguments("--no-sandbox");
	    		co.addArguments("--window-size=1920,1080");
	    	}
	    	driver=new ChromeDriver(co);
	    	driver.manage().window().setSize(new Dimension(1440, 1990));
	    	
	    }
	    else if(browserName.contains("edge"))
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();
	    }
	    else if(browserName.contains("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    return driver;
	}
	
	public List<HashMap<String,String>> getJsonDatatoMap(String string) throws IOException
	{
	
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\DataDriven\\Credential.json"),
				StandardCharsets.UTF_8 );
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
				
		return data;
	}
	@BeforeMethod(alwaysRun = true)
	public landingPage LaunchApplication() throws IOException
	{
		driver=initializeDriver();
		lp=new landingPage(driver);
		lp.Goto();
		return lp;
		
	}
	
//	public MapGeneratePage CreatingNode()
//	{
//		MapGeneratePage mg=new MapGeneratePage(driver);
//		mg.createNode();
//		return mg;
//	}
	
	//@AfterMethod(alwaysRun = true)
	public void teradown()
	{
		driver.quit();
	}
	
}
