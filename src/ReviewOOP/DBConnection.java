package ReviewOOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private String url = "jdbc:mysql://localhost:3306/studentlist";
	private String user = "Hien";
	private String password = "04121992";
	public Connection conn;
	public Statement st;
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Successful connection!");
		} catch (Exception e) {
			System.out.println("Failed connection!");
			e.printStackTrace();
		}
	}

	public ResultSet queryDB(String query) throws Exception {
		st = this.conn.createStatement();
		return st.executeQuery(query);
	}
	
	public void close() throws SQLException {
		conn.close();
	}
}
