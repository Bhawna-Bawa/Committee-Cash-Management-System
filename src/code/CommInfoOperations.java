
package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;


public class CommInfoOperations 
{
    public ArrayList<BeanCommInfo> commInfoDisplay(String s)
    {
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ResultSet rs=ps.executeQuery();
            ArrayList<BeanCommInfo> list=null; 

             if(rs.next())
            {
                rs.beforeFirst();
                BeanCommInfo data=null;
                list=new ArrayList();
                while(rs.next())
                {
                    data=new BeanCommInfo();
                    data.setId(rs.getInt(1));
                    data.setComName(rs.getString(2));
                    data.setType(rs.getString(3));
                    data.setTotalAmount(rs.getInt(4));
                    data.setTermAmount(rs.getInt(5));
                    data.setTerm(rs.getInt(6));

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
    public Boolean insertComm(BeanCommInfo data)
    {
        String s="Insert into committeeinfo (committeename,committeetype,totalamount,termamount,terms) values(?,?,?,?,?)";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ps.setString(1, data.getComName());
            ps.setString(2,data.getType());
            ps.setInt(3,data.getTotalAmount());
            ps.setInt(4, data.getTermAmount());
            ps.setInt(5, data.getTerm());
            
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
    
    public Boolean update(BeanCommInfo data)
    {
        Boolean result=false;
        String str="Update  committeeinfo set committeeid=?,committeename=?,committeetype=?,totalamount=? ,termamount=? ,terms=? where committeeid=?";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            ps.setInt(1, data.getId());
            ps.setString(2,data.getComName());
            ps.setString(3, data.getType());
            ps.setInt(4,data.getTotalAmount());
            ps.setInt(5,data.getTermAmount());
            ps.setInt(6,data.getTerm());
            ps.setInt(7, data.getId());
            int rs=ps.executeUpdate();
            
            System.out.println(data.getId());
            System.out.println(data.getTotalAmount());
            System.out.println(data.getTermAmount());
            
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
    public Boolean deleteComm(String str)
    {
        Boolean result=false;
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            int i=ps.executeUpdate();
            
                if(i>0)
                {
                    result=true;
                }
                return result;
                        
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
            
        }
        
    }
    
}
    

