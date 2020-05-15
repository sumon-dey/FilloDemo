package com.testautomation.fillo.tests;

import org.junit.After;
import org.junit.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloSelectTest1 {

	private String query;
	private String filePath;

	// display the complete data from the excel
	@Test
	public void test1() {
		query = "SELECT * FROM InfoSheet1";
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
	public void test2() {
		query = "SELECT * FROM InfoSheet1";
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery(query);
			// get the count of the total rows with data in the excel sheet
			System.out.println("Count of rows: " + recordset.getCount());
			// get first row data
			recordset.moveFirst();
			System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
					+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
					+ recordset.getField("Marks Obtained (out of 100)"));
			// get next row data
			recordset.moveNext();
			System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
					+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
					+ recordset.getField("Marks Obtained (out of 100)"));
			// get last row data
			recordset.moveLast();
			System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
					+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
					+ recordset.getField("Marks Obtained (out of 100)"));
			// get previous row data
			recordset.movePrevious();
			System.out.println(recordset.getField("StudentID") + " " + recordset.getField("First Name") + " "
					+ recordset.getField("Last Name") + " " + recordset.getField("ProgrammingLanguage") + " "
					+ recordset.getField("Marks Obtained (out of 100)"));
			// get the data from a column according to the column index
			System.out.println(recordset.getField(1).value());
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		query = "SELECT * FROM InfoSheet1";
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset recordset = connection.executeQuery(query);
			// get the number of columns
			int totalColumns = recordset.getFieldNames().size();
			System.out.println("Total number of columns is: " + totalColumns);
			// get the name of all the fields
			for (String eachField : recordset.getFieldNames()) {
				System.out.print(eachField + ", ");
			}
			System.out.println();
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
