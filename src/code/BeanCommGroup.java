
package code;

public class BeanCommGroup 
{
   int  groupid, committeeid,  totalmember,amount,cday,count;
   String startdate, enddate, collectiondate,committeename,cdate;
   public int getGrpId()
   {
       return groupid;
   }
   public void setGrpId(int id)
   {
       groupid=id;
   }
   
    public int getComId()
   {
       return committeeid;
   }
   public void setComId(int id)
   {
       committeeid=id;
   }
    public int getTotalMem()
   {
       return totalmember;
   }
   public void setTotalMem(int n)
   {
       totalmember=n;
   }
   public String getSDate()
   {
       return startdate;
   }   
   public void setSDate(String sd)
   {
       startdate=sd;
   }
   
   public String getEDate()
   {
       return enddate;
   }   
   public void setEDate(String ed)
   {
       enddate=ed;
   }
   
   public String getcDate()
   {
       return collectiondate;
   }   
   public void setCDate(String cd)
   {
       collectiondate=cd;
   }
   public String getComName()
   {
       return committeename;
   }   
   public void setComName(String cd)
   {
       committeename=cd;
   }
   public int getAmount()
   {
       return amount;
     
   }
   public void setAmount(int a)
   {
       amount=a;
   }
    public String getDate()
   {
       return cdate;
   }   
   public void setDate(String cd)
   {
       cdate=cd;
   }
   public int getCDay()
   {
       return cday;
   }
   public void setCDay(int c)
   {
    cday=c;   
   }
   public int getcount()
   {
       return count;
   }
   public void setCount(int c)
   {
       count=c;
   }
}
