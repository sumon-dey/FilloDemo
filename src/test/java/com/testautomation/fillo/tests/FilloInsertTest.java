package com.testautomation.fillo.tests;

import org.junit.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class FilloInsertTest {

	private String query;
	private String filePath;

	@Test
	public void test1() {
		query = "INSERT INTO \"Info - Sheet3\"(StudentID,\"First Name\",\"Last Name\",ProgrammingLanguage,\"Marks Obtained (out of 100)\") VALUES(21,'Ron','Samuels','Java',88)";
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
