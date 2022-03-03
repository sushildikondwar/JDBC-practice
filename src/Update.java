import java.sql.*;
public class Update {

	public static void main(String[] args) throws Exception{

		String url = "jdbc:mysql://localhost:3306/db1";
		String Username = "root";
		String Password = "1321232";
		
		String newPhoneNo = "9096999917";
		String targetCol = "name";
		String targetAttr = "'Sushil Dikondwar'";
		String query = "update family set phone=" + newPhoneNo + " where " + targetCol + "=" + targetAttr;
		
		Connection conn = DriverManager.getConnection(url, Username, Password);
		
		Statement st = conn.createStatement();
		int count = st.executeUpdate(query);
		System.out.println(count + " rows affected..");
		
		st.close();
		conn.close();
	}

}
