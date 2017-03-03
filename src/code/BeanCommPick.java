
package code;


public class BeanCommPick 
{
   int pickedid, groupid, User_Id, termno,  amount;
   String  pickeddate,username,status;
   public int getPId()
   {
       return pickedid;
   }
   public void setPId(int id)
   {
       pickedid=id;
   }

    public int getUId()
   {
       return User_Id;
   }
   public void setUId(int id)
   {
       User_Id=id;
   }
    public int getGId()
   {
       return groupid;
   }
   public void setGId(int id)
   {
       groupid=id;
   }
    public int getTerm()
   {
       return termno;
   }
   public void setTerm(int t)
   {
       termno=t;
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
       return pickeddate;
   }
   public void setPDate(String d)
   {
       pickeddate=d;
   }
   public String getName()
   {
       return username;
   }
   public void setName(String n)
   {
       username=n;
   }
    public String getStatus()
   {
       return status;
   }
   public void setStatus(String n)
   {
       status=n;
   }
}
