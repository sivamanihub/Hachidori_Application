package selenium.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.TestComponents.BaseTest;
import sivamani.PageObjectModel.MapGeneratePage;
import sivamani.PageObjectModel.Settings;
import sivamani.PageObjectModel.landingPage;

public class SettingsTests extends BaseTest{

	@Test(dataProvider = "getData")
	public void SavingIpadress(HashMap<String, String> input) throws InterruptedException
	{
		lp.LoginApplication(input.get("username"),input.get("password") );
		
		Settings st=lp.goToSettingsPage();
		
		Assert.assertTrue(st.ConfigIpAddress().equalsIgnoreCase("Server Configuration Saved"));
	}

}
