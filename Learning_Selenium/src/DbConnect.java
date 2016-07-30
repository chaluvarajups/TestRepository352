import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLSyntaxErrorException;

public class DbConnect {

	public static void main(String[] args) throws SQLException,SQLSyntaxErrorException, ClassNotFoundException {

	//	String dburl="jdbc:oracle://localhost:1521/Bugs";
	//	String username="System";
	//	String Password="welcome1";
		String query="select * from emp";

		//load Oracle JDBC driver
		//Class.forName("com.oracle.jdbc.driver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//get connection DB
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:orcl","System", "Welcome1");
		System.out.println("Login to db Success");

		//Create Statment object
		Statement stmt = con.createStatement();
				
		//Send SQL query to DB
		ResultSet rs = stmt.executeQuery(query);
		
		//While loop to get ResultSet all rows data
		while(rs.next())
		{ String uName=rs.getString(2);
		System.out.println(uName);
		}
		
		
		//close DB connection
		//con.close();	
		if (con!=null)
		{
			con=null;
			System.out.println("db connection closed");
		}
		}
	}

