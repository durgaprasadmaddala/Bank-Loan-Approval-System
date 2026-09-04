package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnections {

	private static Connection con;

	public static Connection getConnection() {

		try {

			if (con == null || con.isClosed()) {

				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loanapproval", "root", "root");

				System.out.println("Database Connected");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}