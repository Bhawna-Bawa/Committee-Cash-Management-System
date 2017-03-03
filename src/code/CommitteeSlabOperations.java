

package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CommitteeSlabOperations 
{
   public CommitteeSlabOperations()
   {
       
   }
    public ArrayList<BeanCommSlab> retrieveSlabInfoMain(String s)
    {
         try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ResultSet rs=ps.executeQuery();
            ArrayList<BeanCommSlab> list=null; 

             if(rs.next())
            {
                rs.beforeFirst();
                BeanCommSlab data=null;
                list=new ArrayList();
                while(rs.next())
                {
                   data=new BeanCommSlab();
                   data.setId(rs.getInt(3));
                   data.setTermNo(rs.getInt(2));
                   data.setAmountGiven(rs.getInt(4));
                   
                   list.add(data);
 
                }
            }
            
                return list;
        }
        catch(Exception ex)
        {
            return null;
        }
        }
    public ArrayList<BeanCommSlab> retrieveSlabInfo(String s)
    {
         try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ResultSet rs=ps.executeQuery();
            ArrayList<BeanCommSlab> list=null; 

             if(rs.next())
            {
                rs.beforeFirst();
                BeanCommSlab data=null;
                list=new ArrayList();
                while(rs.next())
                {
                   data=new BeanCommSlab();
                   data.setId(rs.getInt(1));
                   data.setComName(rs.getString(2));
                   data.setTermNo(rs.getInt(3));
                   data.setAmountGiven(rs.getInt(4));
                   
                   list.add(data);
 
                }
            }
            
                return list;
        }
        catch(Exception ex)
        {
            return null;
        }
        }
    public Boolean insertSlab(BeanCommSlab data)
    {
        String s="Insert into committeeslab (termno,committeeid,amountgiven) values(?,?,?)";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ps.setInt(2,data.getId());
            ps.setInt(1,data.getTermNo());
            ps.setInt(3,data.getAmountGiven());
            
            int i=ps.executeUpdate();
            if(i>0)
            {
               return true; 
            }
            else return false;
        }
        catch(Exception ex)
        {
             System.out.println(ex);
            return false;
        }
    }
    public int amountGiven(String s)
    {
        int i=-1;
        try
        {
           PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {
               i=rs.getInt(1);
               return i;
           }
           return i;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return i;
        }
        
    }
    public Boolean delete(BeanCommSlab data)
    {
        Boolean result=false;
        String str="Delete from  committeeslab where committeeid=? && termno=?";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            
            ps.setInt(1, data.getId());
            ps.setInt(2, data.getTermNo());
            int rs=ps.executeUpdate();
            if(rs>0)
            {
                result=true;
                return result;
            }
            return result;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return result;
        }
        
    }

            
}
    

