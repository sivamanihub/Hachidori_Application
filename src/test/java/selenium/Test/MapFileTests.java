package selenium.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import sivamani.PageObjectModel.MapGeneratePage;

public class MapFileTests extends BaseTest {

	
	@Test(dataProvider = "getData")
	public void loginapplication(HashMap<String, String> input)
	{
		lp.LoginApplication(input.get("username"),input.get("password") );
	}
	

	
	@Test(dataProvider ="getData")
	public void CreateMap(HashMap<String, String> input) throws InterruptedException
	{
		
		MapGeneratePage mg=lp.LoginApplication(input.get("username"),input.get("password") );
		String msg=mg.createMap();
		assertTrue(msg.equalsIgnoreCase("Uploaded map successfully")); 
	}
	
	@Test(dataProvider ="getData",dependsOnMethods = "CreateMap")
	public void DeletingMap(HashMap<String, String> input) throws InterruptedException
	{
		MapGeneratePage mg=lp.LoginApplication(input.get("username"),input.get("password") );
		String msgDelet=mg.deletMap();
		assertTrue(msgDelet.equalsIgnoreCase("Map Delete")); 
	}
}
