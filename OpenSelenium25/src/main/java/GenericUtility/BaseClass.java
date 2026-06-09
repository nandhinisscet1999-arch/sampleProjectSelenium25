package GenericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass extends ListernerUtility{
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("After Suite");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("After Test");
	}
	@BeforeClass
	public void Bc()
	{
		System.out.println("Before class");
	}
	@AfterClass
	public void Ac()
	{
		System.out.println("Before class");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("Before Method");
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("Aftermethhod");
	}

}
