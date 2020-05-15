package com.testautomation.fillo.tests;

import org.junit.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class FilloUpdateTest {

	private String query;
	private String filePath;

	@Test
	public void test1() {
		query = "UPDATE \"Info Sheet2\" SET ProgrammingLanguage='Scala' WHERE (StudentID=5 and \"First Name\"='Curt' AND \"Last Name\"='Philips')";
		filePath = "./files/SampleExcelFile1.xlsx";
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			connection.executeUpdate(query);
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
