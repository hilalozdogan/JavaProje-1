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
public class InternationalCustomer extends Customer{
    
    private String Country;
    private String City;
 
 
public InternationalCustomer() //parametresiz constructor
    {
        super(); // super sınıfın default yapılandırıcısını kullandık
        Country = null;
        City=null;
    }   
 
 public InternationalCustomer(int CustomerID,String Name,String Surname,String Country,String City) //parametreli constructor
    {
        super(CustomerID,Name,Surname);
        this.Country=Country;
        this.City=City;
    }
public InternationalCustomer(InternationalCustomer ic)
{
     this(ic.getCustomerID(),ic.getName(),ic.getSurname(),ic.getCountry(),ic.getCity());
}
 
    /**
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }
 
    /**
     * @param Country the Country to set
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }
 
    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }
 
    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }
    @Override
    public String toString()
    {
        String result = super.toString();
        result+="\nÜlke: " +getCountry()+"\nŞehir: " +getCity();
        return result;
    }
}