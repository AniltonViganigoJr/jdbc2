package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args){

		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn = DB.getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from selle");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("Id") + " | " + resultSet.getString("Name"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			DB.closeStatement(statement);
			DB.closeResultSet(resultSet);
			DB.closeConnection();			
		}
	}
}