import java.sql.*;	//	IMPORT SQL	{1}

public class DBconfig {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/db1";
		String Username = "root";
		String Password = "1321232";
		
		String query = "select * from family";
		

//		Class.forName("com.mysql.jdbc.Driver");	//	ACTIVATING DRIVER (SOMETIMES MIGHT NOT NECESSARY TO DO THIS EXPLICITLY)	{2}
		
		Connection conn = DriverManager.getConnection(url, Username, Password);	//	CREATING CONNECTION WITH DATABASE	{3}
		
		Statement st = conn.createStatement();	//	STATEMENT CONTAINER FOR THE RESPECTIVE CONNECTION	{4}
		ResultSet tbl = st.executeQuery(query);	//	QUERY EXECUTION, RETURNS A RESULTSET (KINDOF TABLE FORMAT)	{5}
		
		while (tbl.next()) {	//	MOVING POINTER FURTHER AND CHECKING ROW EXISTANCE AND PROCESSING RESULT	{6}
			String s = tbl.getString("name");
			String t = tbl.getString("PHONE");
			System.out.println(s + " " + t);
		}
		
		st.close();
		conn.close();	//	CLOSE DB CONNECTION {7}
	}
	
//	.next() method is necessary before any .getString(), because, at the beginning, it is not pointing to the row data, its pointing to the column data,
//	 so therefore, .next() will move the pointer one step down to the data row.
//	putting .next() in while condition have the following advantages:
//	(1. It'll check if next row is existing or not as it returns boolean)
//	(2. During further iterations, it keeps moving the pointer downwards, and we can then fetch the data in that particular row using the respective column name)

}
