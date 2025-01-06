package webtables;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import actions.BaseTest;

public class WebTableTests extends BaseTest {

    @Test
    public void verifyTable() {
        driver.get("file:///C:/Users/GFG0329/eclipse-workspace/SeleniumChromeAutomation/src/main/java/webtables/employeeTable.html");

        WebElement table = driver.findElement(By.id("employeeTable"));
        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }

        System.out.println("Total Rows: " + rows.size());
        int columnCount = table.findElements(By.xpath("//thead//tr/th")).size();
        System.out.println("Total Columns: " + columnCount);

        WebElement specificCell = driver.findElement(By.xpath("//tbody//tr[2]/td[3]"));
        System.out.println("Employee Department: " + specificCell.getText());

        WebElement specificRowById = driver.findElement(By.xpath("//tbody//tr[td[text()='102']]"));
        String userName = specificRowById.findElement(By.xpath("td[2]")).getText();
        System.out.println("User Name (ID 102): " + userName);

        try {
            WebElement specificRowByName = driver.findElement(By.xpath("//tbody//tr[td[text()='Mark']]"));
            String departmentName = specificRowByName.findElement(By.xpath("td[3]")).getText();
            System.out.println("Mark's Department: " + departmentName);
        } catch (Exception e) {
            System.out.println("No row found for 'Charlie'.");
        }

        System.out.println("Cell Value (Row 1, Col 3): " + getCellValue(table, 1, 3));
        System.out.println("Cell Value (Row 2, Col 3): " + getCellValue(table, 2, 3));
        System.out.println("Cell Value (Row 3, Col 3): " + getCellValue(table, 3, 3));
    }

    private String getCellValue(WebElement table, int row, int col) {
        try {
            WebElement cell = table.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + col + "]"));
            return cell.getText();
        } catch (Exception e) {
            return "Cell not found!";
        }
    }
}
