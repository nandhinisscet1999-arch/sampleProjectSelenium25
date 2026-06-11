package TestScript;

import org.testng.annotations.Test;

public class contactTest {
	@Test
	
	public void createOrgTest()
	{
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String User = System.getProperty("username");
		String pass = System.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(User);
		System.out.println(pass);
		
		System.out.println("execute createOrgTest");
	}
	@Test
	public void modifyOrgTest()
	{
		System.out.println("execute modifyOrgTest");
	}
    

}
