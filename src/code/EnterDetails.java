/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;
import code.BeanDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author karan bawa
 */
public class EnterDetails 
{
     int id;
    public boolean insertData(BeanDetails data)
    {
        //String strInsert="insert into values("+rno+"'"+sname+"'"+"'"+address+"')";
        
        String strInsert="insert into logindetails values(?,?,?,?,?,?,?,?,?,?,now())";
        try
        {
             PreparedStatement ps=DbConnection.startConnection().
                    prepareStatement(strInsert);
            

            ps.setInt(1, data.getUserId());
            ps.setString(2,data.getFirst());

            ps.setString(3,data.getLast());
            ps.setString(4, data.getRole());
            ps.setString(5, data.getContact());
            ps.setString(6, data.getEmail());
            ps.setString(7, data.getAddress());
            ps.setString(8, data.getPassword());
            ps.setString(9, data.getQues());
            ps.setString(10, data.getAns());

           
            int i=ps.executeUpdate();
            if(i>0)
            {
                return true;
            }
            else
                return false;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        
    }
    
    public int[] getInfo()
    {
        int id[]=new int[2];
       
       String strInsert="select min(User_Id) as minimum,max(User_Id) as maximum from logindetails";
        try
        {
             PreparedStatement ps=DbConnection.startConnection().
                    prepareStatement(strInsert);
               ResultSet  rs=ps.executeQuery();
                if(rs.next())
                {
                   
                 id[0]=rs.getInt("minimum");
                 id[1]=rs.getInt("maximum");
                 id[1]=id[1]+1;
                 

                }
                return id;
             
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
        
    }
    
    public BeanDetails retrieve(int id) 
 {  
     String str="Select FirstName,LastName from logindetails where User_Id=?";
     try
     {
       
         PreparedStatement ps=DbConnection.startConnection().
                    prepareStatement(str); 
         ps.setInt(1, id);
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {
            BeanDetails data=new BeanDetails();
            data.setFirst(rs.getString("FirstName"));
            data.setLast(rs.getString("LastName"));
            return data;
         }
         else 
             return null;
       
     }
     catch(Exception e)
     {
         System.out.println(e);
         return null;
     }
       
 }
    
    public String ForgotPassword(int UserId,String q,String a)
    {
        String s=null;
        String st="Select Password,Security_Ques,Ans from logindetails where User_Id=?";
     try
     {
      
         PreparedStatement ps=DbConnection.startConnection().
                    prepareStatement(st); 
                    ps.setInt(1, UserId);
         ResultSet rs=ps.executeQuery();
        if(rs.next())
        {              
            String ques,ans;
            ques=rs.getString("Security_Ques");
            ans=rs.getString("Ans");
            if(q.equalsIgnoreCase(ques) &&a.equalsIgnoreCase(ans))
          // if(q.equalsIgnoreCase(rs.getString("Security_Ques")) && a.equalsIgnoreCase(rs.getString("Ans")))
           {
          
               s=rs.getString("Password");
                return s;
           }
           
        }  
         
             
     }
     catch(Exception e)
     {
          System.out.println(e);
         return null;
     }
     return s;
    
    }
    
    public Boolean getChangePassword(String o,int id)
    {
         Boolean result=false;
         String str="Select Password from logindetails where User_Id=?";
         try
            {
                System.out.println(id);
             PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
             ps.setInt(1,id);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
                 Boolean ans=o.equals(rs.getString("Password"));
                 if(ans)
                 {
                     result=true;
                     return result;
                 }
             }

         }
         catch(Exception e)
         {
             System.out.println(e);
         }
          
          return result;

       
    }
    public Boolean updatePassword(String s,int id)
    {
        Boolean result=false;
        String str="Update logindetails set Password=? where User_Id=? ";
         try
         {
             PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
             ps.setString(1,s);
             ps.setInt(2,id);
             int rs=ps.executeUpdate();
             if(rs>0)
             {
                 result =true;
                 return result;
             }
             else return result;
             
                
             
         }
         catch(Exception e)
         {
             System.out.println(e);
             return false;
         }
         
    }
    public BeanDetails info(int id)
    {
        
       
      String  Str="Select * from logindetails where User_Id=?";
      try
      {
      PreparedStatement ps=DbConnection.startConnection().prepareStatement(Str);
      ps.setInt(1, id);
      ResultSet rs=ps.executeQuery();
      if(rs.next())
      {
         BeanDetails data=new BeanDetails();
          data.setAns(rs.getString("Ans"));
           data.setAddress(rs.getString("Address"));
          data.setUserId(rs.getInt("User_Id"));
          data.setFirst(rs.getString("FirstName"));
          data.setLast(rs.getString("LastName"));
          data.setContact(rs.getString("ContactNo"));
          data.setQues(rs.getString("Security_Ques"));
          data.setRole(rs.getString("Role"));
          data.setEmail(rs.getString("EmailId"));
          data.setPassword(rs.getString("Password"));
          data.setlastLogin(rs.getString("Last_Login"));
          
         return data;
      }
      else return null;
      }
      catch(Exception e)
      {
          System.out.println(e);
          return null;
      }
        
       
    }
    public Boolean ContactUpdate(int id ,String c)
    {
        Boolean result=false;
        String str="Update logindetails set ContactNo='"+c+"' where User_Id="+id;
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
           
           
            int rs=ps.executeUpdate();
             if(rs>0)
             {
                 result =true;
                 return result;
             }
             else return result;
             
                
             
         }
         catch(Exception e)
         {
             System.out.println(e);
             return false;
         }
        }
    public Boolean EmailUpdate(int id ,String c)
    {
        Boolean result=false;
        String str="Update logindetails set EmailId='"+c+"' where User_Id="+id;
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
           
           
            int rs=ps.executeUpdate();
             if(rs>0)
             {
                 result =true;
                 return result;
             }
             else return result;
             
                
             
         }
         catch(Exception e)
         {
             System.out.println(e);
             return false;
         }
        }
    public Boolean AddressUpdate(int id ,String c)
    {
        Boolean result=false;
        String str="Update logindetails set Address='"+c+"' where User_Id="+id;
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
           
           
            int rs=ps.executeUpdate();
             if(rs>0)
             {
                 result =true;
                 return result;
             }
             else return result;
             
                
             
         }
         catch(Exception e)
         {
             System.out.println(e);
             return false;
         }
        }
        
    }
    

