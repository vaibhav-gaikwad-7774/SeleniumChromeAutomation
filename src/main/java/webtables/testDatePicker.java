package webtables;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import actions.BaseTest;

public class testDatePicker extends BaseTest {

    @Test
    public void testDatePicker() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentDay = today.getDayOfMonth();

        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.click();

        String yearLocator = String.format("//th[contains(text(), '%d')]", currentYear);
        WebElement monthElement = driver.findElement(By.xpath(yearLocator));
        monthElement.click();

        WebElement leftArrow = driver.findElement(By.cssSelector("div.datepicker-months th.prev"));
        leftArrow.click();

        WebElement monthPastYear = driver.findElement(By.xpath("//span[@class='month focused']"));
        monthPastYear.click();

        String dayElementLocator = String.format("//td[@class='day' and text()='%d']", currentDay);
        WebElement dayElement = driver.findElement(By.xpath(dayElementLocator));
        dayElement.click();

        String oneYearBackDate = datePicker.getDomProperty("value");
        System.out.println("Actual date selected from calendar: " + oneYearBackDate);

        LocalDate previousYear = today.minusYears(1);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String expectedDate = previousYear.format(dateFormat);
        System.out.println("Expected date: " + expectedDate);

        assertEquals(oneYearBackDate, expectedDate, "Selected date does not match the expected date!");
    }
}
