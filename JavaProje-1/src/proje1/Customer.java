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
public class Customer {
    
    private int CustomerID;
    private String Name,Surname;
  
    
 
    public Customer() //parametresiz constructor
    {
        
        CustomerID= 0;
        Name = null;
        Surname= null;
       
    }
    public Customer(int CustomerID, String Name, String Surname)//parametreli constructor
    {  
        
        this.CustomerID=CustomerID;
        this.Name=Name;
        this.Surname=Surname;
    }
   
    public Customer(Customer c ) //copy constructor
    {
        this(c.getCustomerID(),c.getName(),c.getSurname());
       
    }
 
    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }
 
    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }
 
    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }
 
    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }
 
    /**
     * @return the Surname
     */
    public String getSurname() {
        return Surname;
    }
 
    /**
     * @param Surname the Surname to set
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
   
    @Override
    public String toString()  // toString metodu ile integer değişkenleri stringe çevirip ekrana formatlı bir biçimde yazdırdık
    {
        return "Müşteri ID: " + Integer.toString(getCustomerID()) + "\nAd: " + getName() + "\nSoyad: "+ getSurname();
    }

    
    }

   
    
 
   

 
 

