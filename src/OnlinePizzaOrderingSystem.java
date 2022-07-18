/*
 * Hoo Ern Ping B200152B
 */
import java.util.ArrayList;

public class OnlinePizzaOrderingSystem {
    
    // arraylist
    private ArrayList<Pizza> pizzaEntry;
    private ArrayList<Order> orderEntry;

    // constructor
    OnlinePizzaOrderingSystem(){
        pizzaEntry = new ArrayList<Pizza>();
        orderEntry = new ArrayList<Order>(); 
    }

    // add cart method
    public void addCart(Pizza newPizza){
        boolean found = false;
		int i,j;
		for(i=0; i<pizzaEntry.size() && found == false; i++) {
			Pizza oldPizza = pizzaEntry.get(i);
			if(oldPizza.getName().equalsIgnoreCase(newPizza.getName()) 
            && oldPizza.getSize().equalsIgnoreCase(newPizza.getSize())) {
                String[] oldPizzaTopping = oldPizza.getTopping();
                String[] newPizzaTopping = newPizza.getTopping();
                for(j = 0; j < oldPizzaTopping.length; j++){
                    if(!(oldPizzaTopping[j].equalsIgnoreCase(newPizzaTopping[j]))){
                        break;
                    }
                }
                if(j == oldPizzaTopping.length){
                    found = true;
                    break;
                }
			}  
		}
		if(found == true){ // if found, update pizza's quantity
            int temp = pizzaEntry.get(i).getQuantity();
			pizzaEntry.get(i).setQuantity(temp+newPizza.getQuantity());
		}else{ // if not found
			pizzaEntry.add(newPizza);
		}
        System.out.println(pizzaEntry.get(i).toString());
        System.out.println("Pizza Added Successfully.");
       
    }
    
    // update cart method
	public void updateCart(int thePizzaID, String thePizzaSize,String[] thePizzaTopping, int quantity) {
        int j;
        for(j=0;j<pizzaEntry.size();j++){
            Pizza p = pizzaEntry.get(j);
            if(p.getID() == thePizzaID){
                break;
            }
        }
        if(j==pizzaEntry.size()){
            System.out.println("Cannot find the Pizza in the cart");
        }else{
        	pizzaEntry.get(j).setSize(thePizzaSize); // update size;
            pizzaEntry.get(j).setTopping(thePizzaTopping); // update topping
            pizzaEntry.get(j).setQuantity(quantity); // update quantity
            System.out.println(pizzaEntry.get(j).toString());
            System.out.println("Pizza ID: " + thePizzaID + " is edit successfully");
        }
	}

    // remove cart method
	public void removeCart(int thePizzaID) {

		int j;
        for(j=0;j<pizzaEntry.size();j++){
            Pizza p = pizzaEntry.get(j);
            if(p.getID() == thePizzaID){
                break;
            }
        }
        if(j==pizzaEntry.size()){
            System.out.println("Cannot find the Pizza in the cart");
        }else{
        	pizzaEntry.remove(j);
            System.out.println("Pizza id: " + thePizzaID + " is removed succefully.");
        }
	}

    // print cart method
	public void printCart() {
        String text = "";
        for(int i = 0; i < pizzaEntry.size(); i++){
            text += pizzaEntry.get(i).toString();
        }
        if(text.equalsIgnoreCase("") == true){
            System.out.println("The cart is empty.");
        }
		System.out.println(text);
	}

    // add order method
    public int addOrder(Order newOrder){
         int i,j;
         double totalPrice = 0.0;
         for(i=0; i<pizzaEntry.size(); i++){
            if(pizzaEntry.get(i).getOrderID() == -1){
                double oldPizza = pizzaEntry.get(i).getPrice();
                totalPrice += oldPizza;
            }
         }
         if(!(totalPrice == 0.0)){
            newOrder.setPrice(totalPrice); // set order detail's price
            orderEntry.add(newOrder);
            int getOrderOId = orderEntry.get(orderEntry.size()-1).getID();
            for(j=0; j<pizzaEntry.size(); j++){
                if((pizzaEntry.get(j).getOrderID() == -1)){
                    pizzaEntry.get(j).setOrderID(getOrderOId); // set pizza's Order  ID (OId) to Order's ID
                }
            }
            System.out.println("Order added successfully, total price: " + totalPrice);
            return (int)totalPrice; // update member's point
         }else{
            System.out.println("The cart is empty.");
            return 0;
         }
         
        
    }

    // print order method
    public void printOrder(){
        String text = "";
        int i = 0;
        for(Order allOrderDetail : orderEntry){
            for(i=0; i<pizzaEntry.size(); i++){
                if(pizzaEntry.get(i).getOrderID() == allOrderDetail.getID()){
                    text += pizzaEntry.get(i).toStringOrder();
                }
                
            }
            text +=  allOrderDetail.toString() ;
        }
        if(text.equalsIgnoreCase("") == true){
            System.out.println("The order is empty");
        }
        System.out.println(text);
    }

}
