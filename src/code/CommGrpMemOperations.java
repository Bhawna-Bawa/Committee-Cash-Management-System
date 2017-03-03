
package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CommGrpMemOperations 
{
   public ArrayList<BeanDetails> allMembers(String str)
   {
       try
       {
           PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
           ResultSet rs=ps.executeQuery();
          ArrayList<BeanDetails> list=null; 

           if(rs.next())
           {
              rs.beforeFirst();
                BeanDetails data=null;
                list=new ArrayList();
                while(rs.next()) 
                {
                    data=new BeanDetails();
                     //data.setAns(rs.getString(10));
           //data.setAddress(rs.getString(7));
          data.setUserId(rs.getInt(1));
          data.setFirst(rs.getString(2));
          data.setLast(rs.getString(3));
          data.setContact(rs.getString(4));
          //data.setQues(rs.getString(11));
         // data.setRole(rs.getString(4));
          data.setEmail(rs.getString(5));
         // data.setPassword(rs.getString(8));
          //data.setlastLogin(rs.getString(9));
                list.add(data);
                }
           }
           return list;
       }
       catch(Exception ex)
       {
           System.out.println(ex);
          return null;
       }
       
   }
   public Boolean insertMember(BeanGrpMembers data)
   {
       String str="Insert into groupmember (groupid,User_Id) values (?,?) ";
       try
       {
           PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
           ps.setInt(1, data.getGrpId());
           ps.setInt(2, data.getUserId());
           int i=ps.executeUpdate();
           if(i>0)
           {
               return true;
           }
           else return false;
           
       }
       catch(Exception e)
       {
           System.out.println(e);
           return false;
       }
   }
    public Boolean update(int id)
    {
        Boolean result=false;
        String str="delete from groupmember where User_Id=?";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            ps.setInt(1, id);
           
            int rs=ps.executeUpdate();
            
           
            if(rs>0)
            {
                result=true;
            }
            return result;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
}
   
}
