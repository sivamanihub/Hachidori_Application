package selenium.Test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import sivamani.PageObjectModel.ConfigAMR;
import sivamani.PageObjectModel.MapGeneratePage;
import sivamani.PageObjectModel.landingPage;

public class ConfigAMRTests extends BaseTest {

	@Test(dataProvider = "getData")
	public void LoingToConfigAMR(HashMap<String, String> input) throws InterruptedException
	{
			
		MapGeneratePage mp	=lp.LoginApplication(input.get("username"),input.get("password") );
		
		ConfigAMR ca=mp.gotoConfigAMR();
		ca.LoginToConfigAMR(input.get("roles"));
		//System.out.println(ca.LoginToConfigAMR());
	 //  assertTrue(ca.LoginToConfigAMR(input.get("roles")).equalsIgnoreCase("Configuration Workspace"));
	    
	}
}
