package com.testautomation.fillo.tests;

import org.junit.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class FilloCreateAndDeleteTableTest {

	private String filePath;

	// create table (worksheet)
	@Test
	public void test1() {
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			connection.createTable("InfoSheet4", new String[] { "StudentID", "First Name", "Last Name",
					"ProgrammingLanguage", "Marks Obtained (out of 100)" });
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// delete table (worksheet)
	@Test
	public void test2() {
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			connection.deleteTable("InfoSheet4");
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
