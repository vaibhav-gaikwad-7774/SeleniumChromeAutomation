package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import actions.BaseTest;

public class WebTableTests extends BaseTest {
	@Test
	public void varifyTable() {
		driver.get("C:\\Users\\GFG0329\\eclipse-workspace\\SeleniumChromeAutomation\\src\\main\\java\\webtables\\employeeTable.html");
		
		//locatinh the Table
		WebElement table =  driver.findElement(By.id("employeeTable"));
		
		//get all the rows in the table which is having the body		
        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
        
     // Iterate through all the rows and print the cell data
        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells) {
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }
        
	}
}
