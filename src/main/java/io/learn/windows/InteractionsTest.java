package io.learn.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import actions.BaseTest;

public class InteractionsTest extends BaseTest{
	public static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

	 @Test
	    public void testClickButton() {
	        driver.get(URL);

	        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
	        submitButton.click();

	        WebElement confirmationHeader = driver.findElement(By.cssSelector(".display-6"));
	        String text = confirmationHeader.getText();
	        Assert.assertEquals("Form submitted", text);
	    }

//	    @Test
//	    public void testClickLink() {
//	        driver.get(URL);
//
//	        WebElement returnToIndex = driver.findElement(By.linkText("Return to index"));
//	        returnToIndex.click();
//
//	        String currentUrl = driver.getCurrentUrl();
//	        Assert.assertTrue(currentUrl.contains("index.html"));
//	    }
//
//	    @Test
//	    public void testClickCheckBoxes() {
//	        driver.get(URL);
//
//	        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]:checked"));
//	        Assert.assertEquals("my-check-1", checkbox1.getDomAttribute("id"));
//	        Assert.assertTrue(checkbox1.isSelected());
//
//	        WebElement checkbox2 = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
//	        Assert.assertEquals("my-check-2", checkbox2.getDomAttribute("id"));
//	        Assert.assertFalse(checkbox2.isSelected());
//
//	        checkbox1.click();
//	        Assert.assertFalse(checkbox1.isSelected());
//
//	        checkbox2.click();
//	        Assert.assertTrue(checkbox2.isSelected());
//	    }
//
//	    @Test
//	    public void testClickRadioButtons() {
//	        driver.get(URL);
//
//	        WebElement radio1 = driver.findElement(By.xpath("//input[@type='radio' and @checked]"));
//	        Assert.assertEquals("my-radio-1", radio1.getDomAttribute("id"));
//	        Assert.assertTrue(radio1.isSelected());
//
//	        WebElement radio2 = driver.findElement(By.xpath("//input[@type='radio' and not(@checked)]"));
//	        Assert.assertEquals("my-radio-2", radio2.getDomAttribute("id"));
//	        Assert.assertFalse(radio2.isSelected());
//
//	        radio2.click();
//	        Assert.assertFalse(radio1.isSelected());
//	        Assert.assertTrue(radio2.isSelected());
//	    }
//
//	    @Test
//	    public void testDropDowns() {
//	        driver.get(URL);
//	        WebElement listBox = driver.findElement(By.name("my-select"));
//	        Select select = new Select(listBox);
//
//	        // Print all option text values
//	        List<WebElement> options = select.getOptions();
//	        for (WebElement option : options) {
//	            System.out.println(option.getText());
//	        }
//
//	        // Select one option based on visible text
//	        String optionLabel = "Three";
//	        select.selectByVisibleText(optionLabel);
//
//	        Assert.assertEquals(optionLabel, select.getFirstSelectedOption().getText());
//	    }
//
//	    @Test
//	    public void testDataList() {
//	        driver.get(URL);
//
//	        WebElement dataList = driver.findElement(By.name("my-datalist"));
//	        dataList.click();
//
//	        WebElement option = driver.findElement(By.xpath("//datalist/option[2]"));
//	        String optionValue = option.getDomAttribute("value");
//	        dataList.sendKeys(optionValue);
//
//	        Assert.assertEquals("New York", optionValue);
//	    }
	}