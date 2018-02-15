/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

/**
 *
 * @author hilal
 */
public class NationalCustomer extends  Customer{ 

    
//kalıtımla nationalcustomer sınıfımızı oluşturduk
   
    private int LicensePlateNumber;
    private String Occupation;
   
    
    public NationalCustomer() //parametresiz constructor
    {
        super(); // super sınıfın default yapılandırıcısını kullandık
        LicensePlateNumber=0;
        Occupation = null;
    }
   
    public NationalCustomer(int CustomerID,String Name,String Surname,int LicensePlateNumber,String Occupation) //parametreli constructor
    {
        super(CustomerID,Name,Surname);
        this.LicensePlateNumber=LicensePlateNumber;
        this.Occupation=Occupation;
    }
   
    public NationalCustomer(NationalCustomer nc) //copy constructor
    {
        this(nc.getCustomerID(),nc.getName(),nc.getSurname(),nc.getLicensePlateNumber(),nc.getOccupation());
       
    }

    

    /**
     * @return the LicensePlateNumber
     */
    public int getLicensePlateNumber() {
        return LicensePlateNumber;
    }
 
    /**
     * @param LicensePlateNumber the LicensePlateNumber to set
     */
    public void setLicensePlateNumber(int LicensePlateNumber) {
        this.LicensePlateNumber = LicensePlateNumber;
    }
 
    /**
     * @return the Occupation
     */
    public String getOccupation() {
        return Occupation;
    }
 
    /**
     * @param Occupation the Occupation to set
     */
    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }
   
    @Override
    public String toString()
    {
        String result = super.toString();
        result+="\nPlaka kodu: " + Integer.toString(getLicensePlateNumber()) +"\nMüşteri Mesleği: " + getOccupation();
        return result;
    }
}
    

