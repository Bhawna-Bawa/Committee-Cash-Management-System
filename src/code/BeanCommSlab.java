
package code;


public class BeanCommSlab 
{
    int termno, committeeid, amountgiven;
    String committename;
    public void setId(int id)
    {
        committeeid=id;
       
    }
    
    public int getId()
    {
        return committeeid;
    }
    
     public void setTermNo(int termno)
    {
        this.termno=termno;
       
    }
    
    public int getTermNo()
    {
        return termno;
    }
     public void setAmountGiven(int ag)
    {
        amountgiven=ag;
       
    }
    
    public int getAmountGiven()
    {
        return amountgiven;
    }
   
    public String getComName()
    {
        return  committename;
    }
         public String setComName(String s)
    {
        return  committename=s;
    }
}
