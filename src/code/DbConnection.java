
package code;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DbConnection
{
    static Connection con=null;
            
    private DbConnection()
    {
        
    }
    
    public static Connection startConnection()
    {
        try
        {
            if(con==null)
            {
                 Class.forName("com.mysql.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/committee", "root", "sql");
            }
            return con;
        }
       
        catch(Exception ex)
        {  
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection Failed");
            
            return null; 
        }
       
    }
    
    public  static void closeConnection()
    {
	try
	{
	 if(con!=null)
	 {
	  con.close(); 
	 }
	 con=null;
	}
	catch(Exception ex)
	{
	 System.out.print(ex);
	 con=null;
        }
	 
    }
    
    
}
