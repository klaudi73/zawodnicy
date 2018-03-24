package zawodnicy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

//,,
public class DBConnect {
	private static final String USER = "skoczek";
	private static final String PASS = "skoczkowie";
	private static final String URL = "jdbc:mysql://localhost:3306/skoczkowie?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	private static Connection connection = null;

	private DBConnect() {
	}

	public static Connection getConnection() throws SQLException {
		if (Objects.isNull(connection)) {
			connection = DriverManager.getConnection(URL, USER, PASS);
		}
		return connection;
	}

}
