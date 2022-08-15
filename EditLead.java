package week6.day1.assignment;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class EditLead extends BaseClass {
	
	@Test
	public  void editLead() throws InterruptedException {
//		* 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
//		* 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
//		* 8	Enter first name
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys("Akshaya");
//		* 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		* 10 Click on first resulting lead
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
//		* 11 Verify title of the page
		String title = driver.getTitle();
		if (title.equals("View Lead | opentaps CRM")) {
			System.out.println("The view lead page is verified");
		}
		else {
			System.out.println("The view lead page is not verified");
		}
//		* 12 Click Edit
		driver.findElement(By.linkText("Edit")).click();
//		* 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Flexprod");
//		* 14 Click Update
		driver.findElement(By.className("smallSubmit")).click();
//		* 15 Confirm the changed name appears
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (companyName.equals("Flexprod (10963)")) {
			System.out.println("The company name is updated");
		}
		else {
			System.out.println("The company name is not updated");
		}
	}
}