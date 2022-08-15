package week6.day1.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class MergeContact extends BaseClass {
	
	@Test
	public  void mergeContact() throws InterruptedException {
//		 * 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
//			 * 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
//		 * 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::a")).click();
//		 * 8. Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow= new ArrayList<String>(windowHandles);
		String fromComtactWindow = listWindow.get(1);
		String mainWindow = listWindow.get(0);
		driver.switchTo().window(fromComtactWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
//		 * 9. Click on Widget of To Contact
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='To Contact']/following::a")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindow1= new ArrayList<String>(windowHandles1);
		String toComtactWindow = listWindow1.get(1);
		driver.switchTo().window(toComtactWindow);
		Thread.sleep(3000);
//		 * 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
//		 * 11. Click on Merge button using Xpath Locator		
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		driver.findElement(By.linkText("Merge")).click();
//		 * 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
//		 * 13. Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
	}
}