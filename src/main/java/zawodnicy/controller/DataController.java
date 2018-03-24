package zawodnicy.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zawodnicy.database.DBConnect;

public class DataController {
	
	public List<String> getLabels(String tableName){
		
		StringBuilder query = new StringBuilder("SELECT * FROM ").append(tableName).append(" LIMIT 1;");
		
		//try with resources
		try (Connection connection = DBConnect.getConnection();){
			ResultSet resultSet = connection.createStatement().executeQuery(query.toString());
			int count = resultSet.getMetaData().getColumnCount();
			List<String> labels = new ArrayList<>();
			for (int i = 0; i <= count; i++) {
				labels.add(resultSet.getMetaData().getColumnName(i));
			}
			return labels;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
}
