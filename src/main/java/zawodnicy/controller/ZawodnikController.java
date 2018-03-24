package zawodnicy.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import zawodnicy.model.Zawodnik;

public class ZawodnikController {
	
	private Connection connection;
	
	public ZawodnikController(Connection connection) {
		this.connection = connection;
	}

	public List<Zawodnik> selectAll() throws SQLException {
		String sql = "Select * FROM zawodnicy;";
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
		while (resultSet.next()) {
			
			Zawodnik zawodnik = new Zawodnik(
					resultSet.getInt("id_skoczka"),
					resultSet.getString("imie"), 
					resultSet.getString("nazwisko"),
					resultSet.getString("kraj"),
					resultSet.getDate("data_ur"),
					resultSet.getInt("wzrost"),
					resultSet.getInt("waga"));
			zawodnikList.add(zawodnik);
		}
		return zawodnikList;
	}
	
	
}
