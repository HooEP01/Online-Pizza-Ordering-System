/*
 * Hoo Ern Ping B200152B
 */
public class Customer {
    
    // instance variable
    private int id;
    private String name;
    private String contactNo;
    private String shippingAddress;
    private String email;
    private String password;

    // static variable
    private static int countTotalID = 0;
    
    // deflaut constructor
    Customer(){
        this("none", "none", "none", "none", "none");
    }

    // constructor with parameter
    Customer(String name, String contactNo, String shippingAddress, String email, String password){
        countTotalID++;
        this.id = countTotalID;
        this.name = name;
        this.contactNo = contactNo;
        this.shippingAddress = shippingAddress;
        this.email = email;
        this.password = password;
    }

    // accessor method
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getContactNo(){
        return contactNo;
    }
    public String getShippingAddress(){
        return shippingAddress;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    
    // mutator method
    public void setName(String name){
        this.name = name;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
    public void setShippingAddress(String shippingAddress){
        this.shippingAddress = shippingAddress;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
