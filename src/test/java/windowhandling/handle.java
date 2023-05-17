package windowhandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String windowid=driver.getWindowHandle();
		System.out.println(windowid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windowids=driver.getWindowHandles();
		List<String> windowlist=new ArrayList<String>(windowids);
		
		String parentwindowid=windowlist.get(0);
		System.out.println("The Parent Window id="+parentwindowid);
		
		String childwindowid=windowlist.get(1);
		System.out.println("The child window id ="+childwindowid);
		Thread.sleep(2000);
		driver.switchTo().window(parentwindowid);
		System.out.println("The page parent details="+driver.getTitle());
		driver.switchTo().window(childwindowid);
		System.out.println("The page child window details="+driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

}
