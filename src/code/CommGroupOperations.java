/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author karan
 */
public class CommGroupOperations 
{
    public Boolean insertGroup(BeanCommGroup data)
    {
    
        String str="Insert into committeegroup (committeeid,startdate,enddate,collectiondate,totalmember) values(?,?,?,?,?)";
    
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            
            ps.setInt(1, data.getComId());
            ps.setString(2,data.getSDate());
            ps.setString(3,data.getEDate());
            ps.setString(4,data.getcDate());
            ps.setInt(5, data.getTotalMem());
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
        public ArrayList<BeanCommGroup> retrieveGroup(String str)
        {
            try
            {
                PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
                
                ResultSet rs=ps.executeQuery();
                 ArrayList<BeanCommGroup> list=null; 

                if(rs.next())
                {
                    rs.beforeFirst();
                BeanCommGroup data=null;
                list=new ArrayList();
                while(rs.next())
                {
                    data=new BeanCommGroup();
                    data.setGrpId(rs.getInt(1));
                    data.setComId(rs.getInt(2));
                    data.setSDate(rs.getString(7));
                    data.setEDate(rs.getString(8));
                    data.setCDate(rs.getString(9));
                    data.setTotalMem(rs.getInt(6));

                    list.add(data);
                }
                }
                return list;
            }
            catch(Exception e)
            {
                System.out.println(e);
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
         public Boolean update(BeanCommGroup data)
    {
        Boolean result=false;
        String str="Update  committeegroup set groupid=?,startdate=?,enddate=?,collectiondate=?,totalmember=? where groupid=?";
        try
        {
            PreparedStatement ps=DbConnection.startConnection().prepareStatement(str);
            ps.setInt(1, data.getGrpId());
            ps.setString(2,data.getSDate());
            ps.setString(3, data.getEDate());
            ps.setString(4, data.getcDate());
            ps.setInt(5, data.getTotalMem());
            ps.setInt(6, data.getGrpId());
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
          public Boolean deleteGrp(String str)
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
          public ArrayList<BeanCommGroup> getCDate()
          {
                   String s="Select groupid,collectiondate,month(collectiondate)as cmonth,extract(day from collectiondate)as cday from committeegroup";

              try
              {
                  PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
                  ResultSet rs=ps.executeQuery();
                   ArrayList<BeanCommGroup> list=null; 

                if(rs.next())
                {
                    rs.beforeFirst();
                BeanCommGroup data=null;
                list=new ArrayList();
            while(rs.next())
                {
                    data=new BeanCommGroup();
                    data.setGrpId(rs.getInt(1));
                    data.setDate(rs.getString(3)); // collection month
                    data.setCDate(rs.getString(2)); //collection complete format date
                    data.setCDay(Integer.parseInt(rs.getString(4)));
                    

                    list.add(data);
                }
                }
                return list;
            }
            catch(Exception e)
            {
                System.out.println(e);
                return null;
           }
            
        }
          public Boolean updateCDate(int cd,int id)
          {
              Boolean result=false;
              String s="Update committeegroup set collectiondate=date_add(collectiondate,interval ? month) where groupid=?";
              try
              {
                  PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
                  ps.setInt(1, cd);
                  ps.setInt(2, id);
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
          public int termnos(int gid)
          {
              int i=-1;
              String s="Select month(collectiondate)- month(startdate)as s from committeegroup where groupid=?";
              try
              {
                  PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
                  ps.setInt(1,gid );
                  ResultSet rs=ps.executeQuery();
                  if(rs.next())
                  {
                     i=rs.getInt(1);
                     
                  }
                  
                 return i; 
              }
              catch(Exception e)
              {
                  System.out.println(e);
                  return -1;
              }
          }
          public int countMem(int termno,int gid)
          {     
              int i=-1;
              String s="Select count(*) from transactionentry where groupid=? and termno=?";
              try
              {
                  PreparedStatement ps=DbConnection.startConnection().prepareStatement(s);
                  ps.setInt(1, gid);
                  ps.setInt(2, termno);
                  ResultSet rs=ps.executeQuery();
                  if(rs.next())
                  {
                      i=rs.getInt(1);
                     
                  }
                  return i;
              }
              catch(Exception e)
              {
                  System.out.println(e);
                  return -1;
              }
          }
}


