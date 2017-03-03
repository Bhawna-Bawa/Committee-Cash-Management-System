

package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommPickOperations 
{

      public Boolean insertPickDetails(BeanCommPick data)
   {
       String str="Insert into pickeddetails (groupid,User_Id,termno,pickeddate,amount,status) values (?,?,?,?,?,?) ";
       try
       {
           PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
           ps.setInt(1, data.getGId());
           ps.setInt(2, data.getUId());
           ps.setInt(3, data.getTerm());
           ps.setInt(5, data.getAmount());
           ps.setString(4, data.getDate());
           ps.setString(6,"Picked");
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
   public ArrayList<BeanCommPick> retrievePick(String s)
   {
      try
      {
          PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
          ResultSet rs=ps.executeQuery();
          ArrayList<BeanCommPick> list=null; 
          if(rs.next())
          {
              
                 rs.beforeFirst();
                BeanCommPick data=null;
                list=new ArrayList();
                while(rs.next())
                {
                    data=new BeanCommPick();
                    data.setGId(rs.getInt(1));
                    data.setUId(rs.getInt(2));
                    data.setTerm(rs.getInt(3));
                    data.setPDate(rs.getString(4));
                    data.setAmount(rs.getInt(5));
                    data.setStatus(rs.getString(6));
                    data.setName(rs.getString(7)+" "+rs.getString(8));

                    list.add(data);
                }
               }
                return list;
            }
            catch(Exception ex)
            {
                System.out.println("1"+ex);
                return null;
           }
            
       
    }
        public int getComId(String s)
        {
            int cid=-1;
            try
            {
                PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                     cid=rs.getInt(1);
                    return cid;
                }
                else return cid;
            }
           
        
        catch(Exception ex)
        {
         System.out.println(ex);
                 return cid;
        }
     }
        public String Status(int id)
        {
            String status="Not Picked";
            String str="Select status from pickeddetails where User_Id=?";
            try
            {
                PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
                ps.setInt(1, id);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    status=rs.getString(1);
                    return status;
                }
                return status;
            }
            catch(Exception ex)
            {
                System.out.println(ex);
                return status;
            }
        }
        public Boolean update(int gid,int uid)
    {
        Boolean result=false;
        String str="delete from pickeddetails where groupid=? and User_Id=?";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            ps.setInt(1, gid);
            ps.setInt(2, uid);
           
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
