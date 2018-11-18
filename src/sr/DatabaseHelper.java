package sr;

import java.sql.*;

public class DatabaseHelper {
	static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
	static final String DB_URL = "jdbc:mysql://localhost/userdata";

	static final String USER = "root";
	static final String PASS = "root";
	public ResultSet rs =null;

	public Object dbget() {
		Connection conn = null;
		Statement stmt = null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String sql;
			sql = "SELECT * FROM userdata.users; ";
			 rs = stmt.executeQuery(sql);

			/*while (rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("password"));

			}*/

			
			/*rs.close();
			stmt.close();
			conn.close();*/

		} catch (SQLException se) {
			// Handle errors for JDBC
			return se;
		} catch (Exception e) {
			// Handle errors for Class.forName
			return e;
		} 
		
		/*finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
*/		
	return rs;
	}// end main
}// end FirstExample
