package zawodnicy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			Zawodnik zawodnik = getZawodnik(resultSet);
			zawodnikList.add(zawodnik);
		}
		return zawodnikList;
	}
	
	public void delete(int id) {
		
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM zawodnicy WHERE id_skoczka = ?");
			ps.setInt(1, id);
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate == 0) {
				System.out.println("B³¹d usuwania zawodnika.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("B³¹d usuwania zawodnika.");
		}
		
	}
	
	public Zawodnik show(int id) {
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM zawodnicy WHERE id_skoczka = ?");
			ps.setInt(1, id);
			ResultSet executeQuery = ps.executeQuery();
			Zawodnik zawodnik = null;
			while (executeQuery.next()) {
				zawodnik = getZawodnik(executeQuery);
			}
			return zawodnik;
			
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("B³¹d usuwania zawodnika.");
		}
		return null;
		
	}

	private Zawodnik getZawodnik(ResultSet executeQuery) throws SQLException {
		Zawodnik zawodnik;
		zawodnik = new Zawodnik(
				executeQuery.getInt("id_skoczka"),
				executeQuery.getString("imie"), 
				executeQuery.getString("nazwisko"),
				executeQuery.getString("kraj"),
				executeQuery.getDate("data_ur"),
				executeQuery.getInt("wzrost"),
				executeQuery.getInt("waga"));
		return zawodnik;
	}
}
