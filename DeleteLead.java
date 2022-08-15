package week6.day1.assignment;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass {
	
	@Test
	public  void deleteLead() throws InterruptedException {
//      5. Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
//		6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
//		7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//		8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//		9	Enter phone number
		driver.findElement(By.id("ext-gen262")).clear();
		driver.findElement(By.id("ext-gen262")).sendKeys("191");
		driver.findElement(By.id("ext-gen266")).sendKeys("1");
		driver.findElement(By.id("ext-gen270")).sendKeys("9500194552");
//		10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//		11	Capture lead ID of First Resulting lead
		String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).getText();
		System.out.println("The first resulting lead id is:"+leadID);
//		12	Click First Resulting lead
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
//		13	Click Delete
		driver.findElement(By.linkText("Delete")).click();
//		14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//		15	Enter captured lead ID
		driver.findElement(By.xpath("(//label[text()='Lead ID:']/following::input)[1]")).sendKeys(leadID);
//		16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		Thread.sleep(2000);
		 String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		 System.out.println(message);
		if (message.equalsIgnoreCase("No records to display")) {
			System.out.println("The lead is deleted");	
		}
		else {
			System.out.println("The lead is not deleted");
		}
		Thread.sleep(1000);
	}

}
