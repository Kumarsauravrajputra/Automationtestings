package demoblaze;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basics {
	@Parameters({"URL"})
    @Test
	public void comp(String url) throws IOException, InterruptedException  {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[@class='hrefch' ])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	Actions act=new Actions(driver);
	WebElement ele=driver.findElement(By.id("cartur"));
	act.click(ele).perform();
	WebElement el=driver.findElement(By.xpath("//button[@type='button'and contains(text(),'Place Order')]"));
	act.click(el).perform();
	Thread.sleep(2000);
	driver.findElement(By.id("name")).sendKeys("Saurav");
	driver.findElement(By.id("country")).sendKeys("India");
	driver.findElement(By.id("city")).sendKeys("New Delhi");
	driver.findElement(By.id("card")).sendKeys("VISA");
	driver.findElement(By.id("month")).sendKeys("JUNE");
	driver.findElement(By.id("year")).sendKeys("2023");
	Thread.sleep(3000);
	WebElement ele1=driver.findElement(By.xpath("//button[@type='button'and contains(text(),'Purchase')]"));
    act.click(ele1).perform();
    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("C:\\Users\\Public\\screenshot\\hi.png"));
    Thread.sleep(2000);
    driver.close();
	}

}
