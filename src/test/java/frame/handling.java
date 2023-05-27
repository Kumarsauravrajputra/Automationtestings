package frame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handling {
 
	WebDriver driver;
	@Test
	public void frame() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.switchTo().frame("frm2");
		driver.findElement(By.id("firstName")).sendKeys("Kumar");
		driver.findElement(By.id("lastName")).sendKeys("Saurav");
		List<WebElement>radiobutton=driver.findElements(By.xpath("//input[@type='radio' and contains(@id,'ale')]"));
		for(WebElement button:radiobutton) {
			String btn=button.getAttribute("id");
			if(btn.equals("malerb")) {
			Thread.sleep(2000);
				button.click();	
			}
		}
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'bx')]"));
		for(WebElement box:checkbox) {
			String bx=box.getAttribute("id");
				if(bx.equals("hindichbx")|| (bx.equals("englishchbx"))||(bx.equals("chinesechbx"))) {
					Thread.sleep(2000);
					box.click();
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.close();
	}

}
