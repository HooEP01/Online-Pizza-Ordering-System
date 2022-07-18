/*
 * Hoo Ern Ping B200152B
 */

public class Order {
    
    // instance variable
    private int id;
    private String shippingAddress;
    private Double price;
    private String status;

    // static variable
    private static int countTotalOID = 0;

    // default constructor
    public Order(){
        this("None", 0.0, "None");
    }

    // constructor with parameter
    public Order(String shippingAddress, Double price, String status){
        countTotalOID++;
        this.id = countTotalOID;
        this.shippingAddress = shippingAddress;
        this.price = price;
        this.status = status;
    }
    
    // accessor method
    public int getID(){
        return id;
    }
    public String getShippingAddress(){
        return shippingAddress;
    }
    public double getPrice(){
        return price;
    }
    public String getStatus(){
        return status;
    }

    // mutator method
    public void setShippingAddress(String shippingAddress){
        this.shippingAddress = shippingAddress;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setStatus(String status){
        this.status = status;
    }

    // to string method
    public String toString(){
        return 
        String.format("%-20s", "Order ID") + 
        String.format("%-20s", "Order Status") + 
        String.format("%-80s%n", "Shipping Address") + 
        String.format("%-20s", getID()) + 
        String.format("%-20s", getStatus()) + 
        String.format("%-80s%n", getShippingAddress()) +
        String.format("%-20s: ","Total") + 
        String.format("%-20s%n",getPrice()) ;
    }
}
