package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_de_stock", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("show tables;");
			System.out.println("Connected");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
