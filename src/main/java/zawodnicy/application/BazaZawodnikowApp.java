package zawodnicy.application;

import java.io.FilterInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			Map<String, String> zawodnik = getZawodnikFromUser();
			System.out.println("Zawodnik: " + zawodnik);
			
			DataController dataController = new DataController();
			dataController.insert(zawodnik, "zawodnicy");
			System.out.println("Zaktualizowana lista zawodników: ");
			zawodnikController.selectAll().forEach(z -> System.out.println(z));
			deleteZawodnik(zawodnikController);
			System.out.println("Zaktualizowana lista zawodników po usuwaniu: ");
			zawodnikController.selectAll().forEach(z -> System.out.println(z));
			showZawodnik(zawodnikController);
			
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
	
	private static Map<String, String> getZawodnikFromUser () {
		
		Scanner sc1 = new Scanner(new FilterInputStream(System.in) {
			@Override
			public void close() {
			}
		});
		System.out.println("Witaj w programie dodawania Zawodników.");
		System.out.println("Podaj dane zawodnika:");
		DataController dataController = new DataController();
		List<String> labels = dataController.getLabels("zawodnicy");
		Map<String, String> daneZawodnika = new HashMap<>();
		for (String string : labels) {
			System.out.println("Wpisz " + string + ": ");
			daneZawodnika.put(string, sc1.nextLine());
		}
		sc1.close();
		return daneZawodnika;
	}

	
	private static void deleteZawodnik(ZawodnikController zawodnikController) {
		
		System.out.println("Podaj id zawodnika do usuniêcia: ");
		Scanner sc1 = new Scanner(new FilterInputStream(System.in) {
			@Override
			public void close() {
			}
		});
		String id = sc1.nextLine();
		
		zawodnikController.delete(Integer.valueOf(id));
		
		sc1.close();
	}
	
	private static void showZawodnik(ZawodnikController zawodnikController) {
		
		System.out.println("Podaj id zawodnika do wyœwietlenia: ");
		Scanner sc1 = new Scanner(new FilterInputStream(System.in) {
			@Override
			public void close() {
			}
		});
		String id = sc1.nextLine();
		
		Zawodnik zawodnik = zawodnikController.show(Integer.valueOf(id));
		System.out.println(zawodnik);
		sc1.close();
	}
}
