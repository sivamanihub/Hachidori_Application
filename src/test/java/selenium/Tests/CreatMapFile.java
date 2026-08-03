package selenium.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import sivamani.PageObjectModel.MapGeneratePage;

public class CreatMapFile extends BaseTest {

	
	//@Test(dataProvider = "getData")
	public void loginapplication(HashMap<String, String> input)
	{
		lp.LoginApplication(input.get("username"),input.get("password") );
	}
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
		List<HashMap<String, String>> data= getJsonDatatoMap(System.getProperty("user.dir")+"\\src\\test\\java\\selenium\\DataDriven\\Credential.json");
		return new Object[][] {{data.get(0)}};
	}
	
	@Test(dataProvider = "getData")
	public void CreateNode(HashMap<String, String> input) throws InterruptedException
	{
		MapGeneratePage mg=lp.LoginApplication(input.get("username"),input.get("password") );
		mg.createNode();
	}
}
