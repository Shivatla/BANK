package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/*public class DBConnection {       // This Oracle Sql 
	private static Connection con=null;
	
	private DBConnection() {}
	static {
	try{
	  Class.forName("oracle.jdbc.driver.OracleDriver"); // Load the Oracle JDBC driver
	  
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
      
      
    
  } catch (Exception e) {
      e.printStackTrace();
  }
}

public static Connection getCon() {
	
	
	
  return con;
}}*/

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con = null;

    private DBConnection() {}

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver

            String url = "jdbc:mysql://localhost:3306/Bank";
            String username = "root";
            String password = "tiger";

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection sucessfully ");
            System.out.println(con);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }
}

	


