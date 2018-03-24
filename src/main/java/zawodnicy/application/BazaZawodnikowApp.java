package zawodnicy.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import zawodnicy.controller.DataController;
import zawodnicy.controller.ZawodnikController;
import zawodnicy.database.DBConnect;
import zawodnicy.model.Zawodnik;

public class BazaZawodnikowApp {

	public static void main(String[] args) {
		
		Connection connect = null;
		try {
			connect = DBConnect.getConnection();
			
			ZawodnikController zawodnikController = new ZawodnikController(connect);
			zawodnikController.selectAll().forEach(z -> System.out.println(z));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(connect)) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	private static Zawodnik getZawodnikFromUser () {
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Witaj w programie dodawania Zawodników.");
		System.out.println("Podaj dane zawodnika:");
		DataController dataController = new DataController();
		List<String> labels = dataController.getLabels("zawodnicy");
		for (String string : labels) {
			System.out.println("Wpisz " + string + ": ");
			
		}
	}

}
