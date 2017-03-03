
package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CommTransactionOperations
{
    public int getAmount(String str)
    {
        int i=-1;
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
               i=rs.getInt(2);
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
    public Boolean Entry(BeanCommTrans data)
    {
        String str="Insert into transactionentry (User_Id, groupid, termno, amount, depositdate) values(?,?,?,?,? )";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            ps.setInt(1,data.getUId());
            ps.setInt(2, data.getGId());
            ps.setInt(3, data.getTerm());
            ps.setInt(4, data.getAmount());
            ps.setString(5,data.getDDate());
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                return true;
            }
            return false;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
             return false;       
        }
        
    }
    public ArrayList<BeanCommTrans> retrieve(String s)
    {
          try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ResultSet rs=ps.executeQuery();
            ArrayList<BeanCommTrans> list=null; 

             if(rs.next())
            {
                rs.beforeFirst();
                BeanCommTrans data=null;
                list=new ArrayList();
                while(rs.next())
                {
                   data=new BeanCommTrans();
                   data.setUId(rs.getInt(1));
                   data.setFirst(rs.getString(2));
                   data.setLast(rs.getString(3));
                   data.setGId(rs.getInt(4));
                   
                   data.setTerm(rs.getInt(5));
                   data.setAmount(rs.getInt(6));
                   data.setDate(rs.getString(7));
                   
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
      public Boolean update(int gid,int uid,int term)
    {
        Boolean result=false;
        String str="delete from transactionentry where groupid=? and User_Id=? and termno=?";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            ps.setInt(1, gid);
            ps.setInt(2, uid);
            ps.setInt(3,term);
           
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
    
       public int getTermNo(int gid,int uid)
    {
        int i=1;
        String s="Select max(termno) from transactionentry where groupid=? and User_Id=?";
          try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ps.setInt(1, gid);
            ps.setInt(2,uid);
            ResultSet rs=ps.executeQuery();
             

             if(rs.next())
            {
                 i=rs.getInt(1)+1;
            }
            
              return i;  
        }
        catch(Exception ex)
        {
            return -1;
        }       
    } 
        public ArrayList<BeanCommTrans> getPending(String s)
    {
          try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
            ResultSet rs=ps.executeQuery();
            ArrayList<BeanCommTrans> list=null; 

             if(rs.next())
            {
                rs.beforeFirst();
                BeanCommTrans data=null;
                list=new ArrayList();
                while(rs.next())
                {

                   data=new BeanCommTrans();
                   data.setGId(rs.getInt(1));
                   
                   data.setUId(rs.getInt(2));
                   data.setName(rs.getString(3));
                   
                   data.setTerm(rs.getInt(4));
                   data.setAmount(rs.getInt(5));
                   data.setDate(rs.getString(6));
                   
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
      
}
