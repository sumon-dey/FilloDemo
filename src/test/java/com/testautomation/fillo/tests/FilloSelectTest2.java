package com.testautomation.fillo.tests;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloSelectTest2 {

	public String query;
	public String filePath = null;

	// using WHERE clause inside the query
	@Test
	public void test1() {
		query = "SELECT * FROM InfoSheet1 WHERE ProgrammingLanguage='Swift'";
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery(query);
			while (recordset.next()) {
				System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
						+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
						+ recordset.getField("Marks Obtained (out of 100)"));
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// using WHERE clause with AND operator inside the query
	@Test
	public void test2() {
		query = "SELECT * FROM InfoSheet1 WHERE (\"Last Name\"='Philips' AND \"Marks Obtained (out of 100)\"=59)";
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery(query);
			while (recordset.next()) {
				System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
						+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
						+ recordset.getField("Marks Obtained (out of 100)"));
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// retrieve all sheet names
	@Test
	public void test3() {
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			List<String> sheetNames = connection.getMetaData().getTableNames();
			for (String sheetName : sheetNames) {
				System.out.println(sheetName);
			}
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// using the "where" method provided by Fillo
	@Test
	public void test4() {
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery("SELECT * FROM InfoSheet1").where("\"Last Name\"='Philips'")
					.where("\"Marks Obtained (out of 100)\"=59");
			while (recordset.next()) {
				System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
						+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
						+ recordset.getField("Marks Obtained (out of 100)"));
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get records where a particular column is empty
	@Test
	public void test5() {
		query = "select * FROM InfoSheet1 WHERE StudentID=null";
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery(query);
			while (recordset.next()) {
				System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
						+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
						+ recordset.getField("Marks Obtained (out of 100)"));
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// using the LIKE operator with the WHERE clause in a SELECT statement
	@Test
	public void test6() {
		query = "SELECT * FROM InfoSheet1 WHERE ProgrammingLanguage LIKE 'Sc%'";
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery(query);
			while (recordset.next()) {
				System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
						+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
						+ recordset.getField("Marks Obtained (out of 100)"));
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test7() {
		query = "SELECT * FROM InfoSheet1";
		filePath = "./files/SampleExcelFile1.xlsx";
		// setting the starting row and column of the table
		System.setProperty("ROW", "1");
		// System.setProperty("COLUMN", "4");
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery(query);
			// get the count of the total rows with data in the excel sheet
			System.out.println("Count of rows: " + recordset.getCount());
			while (recordset.next()) {
				System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
						+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
						+ recordset.getField("Marks Obtained (out of 100)"));
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void afterMethod() {
		System.out.println("*****************************************************************");
	}

}
