/*
 * Hoo Ern Ping B200152B
 */

public class NonMember extends Customer{
    
    // default constructor 
    NonMember(){
        super();
    }
    // constructor with parameter
    NonMember(String name, String contactNo, String shippingAddress, String email, String password){
        super(name, contactNo, shippingAddress, email, password);
    }
}
