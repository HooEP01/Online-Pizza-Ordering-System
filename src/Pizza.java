/*
 * Hoo Ern Ping B200152B
 */
public class Pizza {
    
    // instance variable
    private int id = 0;
    private int order_id = -1; // Order ID
    private String name;
    private String size; 
    private Double price;
    private String[] topping = {"pepperoni","sausage","mushroom"};
    private int quantity;

    // static variable
    private static int countTotalID = 0;
    

    // constructor
    Pizza(){
        this("none", "none", new String[3], 0);
    }

    Pizza(String name, String size, String[] topping, int quantity){
        countTotalID ++;
        this.id = countTotalID;
        this.order_id = -1;
        this.name = name;
        this.size = size;
        this.price = 0.0;
        this.topping = topping;
        this.quantity = quantity;
    }

    // accessor method
    public int getID(){
        return id;
    }
    public int getOrderID(){
        return order_id;
    }
    public String getName(){
        return name;
    }
    public String getSize(){
        return size;
    }
    public Double getPrice(){
        return price;
    }
    public String[] getTopping(){
        return topping;
    }
    public int getQuantity(){
        return quantity;
    }

    // mutator method
    public void setID(int id){
        this.id = id;
    }
    public void setOrderID(int orderID){
        this.order_id = orderID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSize(String size){
        this.size = size;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setTopping(String[] topping){
        this.topping = topping;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    

    // calculate price method
    public void calculatePrice(){
        double price = 0.0;
        String[] topping = getTopping();

        if(getSize().equalsIgnoreCase("small")){
            price = 8.0;
        }else if(getSize().equalsIgnoreCase("medium")){
            price = 10.0;
        }else if(getSize().equalsIgnoreCase("large")){
            price = 12.0;
        }else{
            price = 0.0;
        }

        if( topping[0].equalsIgnoreCase("none")){
            /* None */
        }else if(topping[1].equalsIgnoreCase("none")){
            price = price + 1 * 2.0;
        }else if(topping[2].equalsIgnoreCase("none")){
            price = price + 2 * 2.0;
        }else{
            price = price + 3 * 2.0;
        }

        price = price * getQuantity();
        setPrice(price);
    }

    // to string method (Cart)
    public String toString(){
        calculatePrice();
        String[] topping = getTopping();
        String allTopping = "";
        for(int i = 0; i < topping.length; i++){
            if(!(topping[i].equalsIgnoreCase("none"))){
                allTopping += topping[i] + " ";
            }
        }
        if(getOrderID() == -1){ // Order Detail ID Default value equal -1, addOrder() from Order class will edit Order Detail ID to 1 or more.
        return  
        String.format("%-20s",getID()) + 
        String.format("%-20s",getName()) +
        String.format("%-20s",getSize()) +
        String.format("%-30s",allTopping) + 
        String.format("%-20d",getQuantity()) +
        String.format("%-20.2f%n",getPrice()) ;
        }else{
            return "";
        }
    } 

    // to string method (Order)
    public String toStringOrder(){
        calculatePrice();
        String[] topping = getTopping();
        String allTopping = "";
        for(int i = 0; i < topping.length; i++){
            if(!(topping[i].equalsIgnoreCase("none"))){
                allTopping += topping[i] + " ";
            }
        }
        return  
        String.format("%-20s",getID()) + 
        String.format("%-20s",getName()) +
        String.format("%-20s",getSize()) +
        String.format("%-30s",allTopping) + 
        String.format("%-20d",getQuantity()) +
        String.format("%-20.2f%n",getPrice()) ;
    }

}
