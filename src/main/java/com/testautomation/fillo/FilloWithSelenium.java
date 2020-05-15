package com.testautomation.fillo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloWithSelenium {

	@Test(dataProvider = "getDataFromExcelUsingFillo")
	public void testUsingSelenium(String username) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		driver.findElement(By.id("user[login]")).sendKeys(username);
		// driver.findElement(By.id("user[email]")).sendKeys(email);
		// driver.close();
	}

	@DataProvider
	public Object[] getDataFromExcelUsingFillo() {
		try {
			Fillo fillo = new Fillo();
			Object[] object = null;
			Connection connection = fillo.getConnection("./files/SampleExcelFile2.xlsx");
			Recordset recordset = connection.executeQuery("SELECT * FROM DataSheet");
			int numberOfRows = recordset.getCount();
			System.out.println("Size: " + numberOfRows);
			int i = 0;
			object = new Object[numberOfRows];
			while (recordset.next()) {
				object[i] = recordset.getField("Username");
				System.out.println(object[i]);
				i++;
			}
			recordset.close();
			connection.close();
			return object;
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
