package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class LoginCheck {

    public LoginCheck() {
    }

    public void date_time(int id)
    {
           String str = "update logindetails SET Last_Login=now() where USer_Id=?";
          try 
          {
            PreparedStatement ls = DbConnection.startConnection().prepareStatement(str);
            ls.setInt(1, id);
            int time= ls.executeUpdate();
          }
          catch (Exception e)
          {
              System.out.println(e);
          }
    }
  
    
    public String isUser(int id, String pass) {

        String s=null;
       // BeanDetails data=new BeanDetails();
        String strR = "select * from logindetails where User_Id=? and Password=?";
        try {
            PreparedStatement ps = DbConnection.startConnection().prepareStatement(strR);
            ps.setInt(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
            {
                String r = rs.getString("Role");
                String f=rs.getString("FirstName");
                String l=rs.getString("LastName");
                s="Welcome "+f+" "+l+" ( " +r+" )";

                date_time(id);
                return s;
                
            }
           
        }
        catch (Exception e)
        {
            System.out.print(e);
            return null;
        }

                    return s;
    }
}
