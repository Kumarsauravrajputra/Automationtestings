package selfprac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Self {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

		driver.switchTo().frame("frm2");
		driver.findElement(By.id("firstName")).sendKeys("Kumar");

		List<WebElement> radiobutton = driver
				.findElements(By.xpath("//input[@class='bcRadioButton'and contains(@id,'ale')]"));
		for (WebElement button : radiobutton) {
			Thread.sleep(2000);
			button.click();
		}
        List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@class='bcCheckBox' and contains(@id,'bx')]"));
        for(WebElement boxes:checkboxes) {
        	Thread.sleep(2000);
        	boxes.click();
        }
        driver.switchTo().defaultContent();
        Actions act=new Actions(driver);
       WebElement hi= driver.findElement(By.xpath("//a[@href='#'and contains(text(),'Selenium Practice')]"));
        act.moveToElement(hi).perform();
        
        
        
        
		Thread.sleep(2000);
		driver.close();
	}

}
