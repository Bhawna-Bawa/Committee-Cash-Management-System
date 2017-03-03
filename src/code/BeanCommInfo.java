
package code;
public class BeanCommInfo 
{
    private int committeeid, totalamount, termamount, terms;
        String    committeename, committeetype; 
    public int getId()
    {
        return committeeid;
    }
    public void setId(int id)
    {
        committeeid=id;
    }
      public String getComName()
    {
        return committeename;
    }
    public void setComName(String comname)
    {
        committeename=comname;
    }
      public int getTotalAmount()
    {
        return totalamount;
    }
    public void setTotalAmount(int amount)
    {
        totalamount=amount;
    }
      public int getTerm()
    {
        return terms;
    }
    public void setTerm(int term)
    {
        terms=term;
    }
      public int getTermAmount()
    {
        return termamount;
    }
    public void setTermAmount(int termA )
    {
        termamount=termA;
    }
       public String getType()
    {
        return committeetype;
    }
    public void setType(String type)
    {
        committeetype=type;
    }
    public String toString()
    {
        return ""+committeeid;
    }
    
}
