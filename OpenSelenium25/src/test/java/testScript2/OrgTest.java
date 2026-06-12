package testScript2;

import org.testng.annotations.Test;

public class OrgTest {
	
	@Test
	public void createContactTest()
	{
		System.out.println("execute contact test");
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String User = System.getProperty("username");
		String pass = System.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(User);
		System.out.println(pass);
		
	}
	@Test
	public void modifyContactTest()
	{
		System.out.println("modify contact test");
	}
	@Test
	public void DeleteContactTest()
	{
		System.out.println("Delete contact test");
	}


}
