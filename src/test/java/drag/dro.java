package drag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dro {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Static.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@id='angular']"));
		Thread.sleep(2000);
		WebElement ele2=driver.findElement(By.xpath("//div[@class='dragged'and contains(@id,'droparea')]"));
	   
		Thread.sleep(2000);
		act.dragAndDrop(ele, ele2).perform();
		driver.close();

	}

}
