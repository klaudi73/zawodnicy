package zawodnicy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import zawodnicy.database.DBConnect;

public class DataController {
	
	public List<String> getLabels(String tableName){
		
		StringBuilder query = new StringBuilder("SELECT * FROM ").append(tableName).append(" LIMIT 1;");
		
		
		try {
			Connection connection = DBConnect.getConnection();
			ResultSet resultSet = connection.createStatement().executeQuery(query.toString());
			int count = resultSet.getMetaData().getColumnCount();
			List<String> labels = new ArrayList<>();
			for (int i = 2; i <= count; i++) {
				labels.add(resultSet.getMetaData().getColumnName(i));
			}
			return labels;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	public void insert(Map<String, String> zawodnik, String tableName) {
		
		String columns = zawodnik.keySet().toString().replace("[", "").replace("]", "");
		String values = zawodnik.values().toString().replace("[", "\"").replace("]", "\"").replace(", ", "\", \"");
		String insert = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ");";
		System.out.println(insert);
		try {
			Connection connection = DBConnect.getConnection();
			System.out.println(connection.isClosed());
			connection.createStatement().executeUpdate(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
