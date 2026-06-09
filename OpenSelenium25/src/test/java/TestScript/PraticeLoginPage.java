package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PraticeLoginPage {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("./TestData/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url1 = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		FileInputStream fis1 = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		 String Firstname = wb.getSheet("org").getRow(10).getCell(0).toString();
		 String Lastname = wb.getSheet("org").getRow(10).getCell(1).toString();
		 String postal = wb.getSheet("org").getRow(10).getCell(2).toString();



		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--guest");
		WebDriver driver = new ChromeDriver(opt);
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/..//button[text()='Add to cart']")).click();
		String actualData = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		System.out.println(actualData);	
		String expectedData = "1";
		Assert.assertEquals(actualData, expectedData);
		System.out.println("validation passses");
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(Firstname);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(Lastname);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postal);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        
        String totalprice = driver.findElement(By.xpath("(//div[text()='0.00'])[2]")).getText();
        System.out.println(totalprice);
        String expectedPrice="Total: $0.00";
        Assert.assertEquals(totalprice, expectedPrice);
        
        System.out.println("validation is passes");
        driver.findElement(By.xpath("//button[text()='Finish']")).click();
       String validationmessage = driver.findElement(By.xpath("//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']")).getText();
       System.out.println(validationmessage);
        String ExpectedMessage="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(validationmessage, ExpectedMessage);
        
	}

}
