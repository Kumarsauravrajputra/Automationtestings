package azure;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class All {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.id("name"));
		act.click(ele).sendKeys("Saurav").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("7678789873").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("something@gmail.com");
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("12345");
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("New Delhi");
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		act.click().perform();
		
		List<WebElement>el=driver.findElements(By.xpath("//input[@type='radio'and contains(@id,'ale')]"));
		for(WebElement radio:el) {
			radio.click();
		}
		
		List<WebElement>el1=driver.findElements(By.xpath("//input[@class='form-check-input' and contains(@id,'day')]"));
		for(WebElement check:el1) {
		   check.click();	
			
		}
		
		WebElement el2=driver.findElement(By.xpath("//select[@class='custom-select']"));
		Select drop=new Select(el2);
		drop.selectByVisibleText("Norway");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='custom-control-label' and contains(@for,'3years')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='custom-control-label'and contains(@for,'testng')]")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.id("inputGroupFile02")).sendKeys("C:\\Users\\Saurav kumar\\Downloads\\resume.pdf");
		Thread.sleep(3000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Public\\screenshot\\p.png"));
		driver.close();

	}

}
