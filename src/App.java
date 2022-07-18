/*
 * Hoo Ern Ping B200152B
 */
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        OnlinePizzaOrderingSystem orderPizza = new OnlinePizzaOrderingSystem();
        int point = 0;
        boolean guest = true;
        Scanner scanner = new Scanner(System.in);
        String pizzaName = "Pizza";
        while(true){
            if(guest == true){
                System.out.println();
                System.out.printf("%s %n", "#Online Pizza Ordering System");
                System.out.printf("%-20s %n", "1 - Register");
                System.out.printf("%-20s: ", "Insert 1");
                int input = scanner.nextInt();

                switch(input){
                    case 1: 
                        // register
                        System.out.println();
                        System.out.println("#Register");
                        System.out.printf("%-20s: ","Email Address ");
                        String email = scanner.next();
                        System.out.printf("%-20s: ","Password ");
                        String password = scanner.next();
                        System.out.printf("%-20s: ","Name ");
                        String username = scanner.nextLine();
                        username = scanner.nextLine();
                        System.out.printf("%-20s: ","Member (Y/N) ");
                        String customerType = scanner.next();
                        System.out.printf("%-20s: ","Contact No ");
                        String contactNo = scanner.next(); scanner.nextLine();
                        System.out.printf("%-20s: ","Shipping Address ");
                        String shippingAddress = scanner.nextLine();

                        if(customerType.equalsIgnoreCase("Y")){
                            customer = new Member(username, contactNo, shippingAddress, email, password, point);

                        }else{
                            customer = new NonMember(username, contactNo, shippingAddress, email, password);
                            point = -1;
                        }
                        
                        guest = false;
                        break;
                
                    default: 
                        // exception
                }
            }
       
            if(guest == false){
                System.out.println();
                System.out.printf("%s %n", "#Welcome");
                System.out.printf("%-20s: " + customer.getName() + "%n","Name ");
                if(!(point == -1)){ // Member
                    System.out.printf("%-20s: Member %n","Status ");
                    point = ((Member)customer).getPoint();
                    System.out.printf("%-20s: " + point + "%n","Point ");
                }else{ // Non-Member
                    System.out.printf("%-20s: Non-Member %n","Status ");
                }
                System.out.println();
                System.out.println("#Online Pizza Ordering System");
                System.out.println("1 - Add pizza to cart");
                System.out.println("2 - Edit your pizza cart");
                System.out.println("3 - Remove pizza from cart");
                System.out.println("4 - View your pizza cart");
                System.out.println("5 - Checkout order");
                System.out.println("6 - View order");
                System.out.println("7 - Exit");
                System.out.printf("%-20s: ","Insert 1 - 7 ");
                int input = scanner.nextInt();
                String decision;
                do {
                    
                    switch(input){
                    case 1: 
                            // add pizza cart
                            System.out.println();
                            System.out.println("#Add Pizza Cart");
                            String pizzaSize = "";
                            String[] pizzaTopping = new String[3];
                            int pizzaQuantity = 0;
                            System.out.printf("%-20s: " + pizzaName + "%n","Pizza Name ");
                            // output pizza size
                            System.out.printf("%-20s: ","Pizza Size ");
                            System.out.printf("%-20s","1 - Small ");
                            System.out.printf("%-20s","2 - Medium ");
                            System.out.printf("%-20s%n","3 - Large ");
                            System.out.printf("%-20s: ","Select 1,2 or 3 ");
                            int pizzaSizeInt = scanner.nextInt();
                            switch(pizzaSizeInt){
                                case 1: pizzaSize = "small"; break;
                                case 2: pizzaSize = "Medium"; break;
                                case 3: pizzaSize = "large"; break;
                                default: pizzaSize = "Medium"; break;
                            }
                            // output pizza topping
                            System.out.printf("%-20s: ","Topping (Y/N) ");
                            String topping = scanner.next();
                            int countTopping = 0;
                            if(topping.equalsIgnoreCase("Y")){
                                System.out.printf("%-20s: ","Mushroom (Y/N) ");
                                String mushroom = scanner.next();
                                System.out.printf("%-20s: ","Pepperoni (Y/N) ");
                                String pepperoni = scanner.next();
                                System.out.printf("%-20s: ","Sausage (Y/N) ");
                                String sausage = scanner.next();

                                if(mushroom.equalsIgnoreCase("Y")){
                                    pizzaTopping[countTopping++] = "Mushroom";
                                }
                                if(pepperoni.equalsIgnoreCase("Y")){
                                    pizzaTopping[countTopping++] = "Pepperoni";
                                }
                                if(sausage.equalsIgnoreCase("Y")){
                                    pizzaTopping[countTopping++] = "Sausage";
                                }
                            }
                            
                            for(int i = 3; i > countTopping; i--){
                                pizzaTopping[i-1] = "None";
                            }
                            // output pizza quantity
                            System.out.printf("%-20s: ","Pizza Quantity ");
                            pizzaQuantity = scanner.nextInt();
                            System.out.println();
                            System.out.println("#Add Pizza Cart");
                            System.out.printf("%-20s","ID ");
                            System.out.printf("%-20s","Name ");
                            System.out.printf("%-20s","Size ");
                            System.out.printf("%-30s","Topping ");
                            System.out.printf("%-20s","Quantity ");
                            System.out.printf("%-20s%n","Price");
                            // add pizza
                            orderPizza.addCart(new Pizza(pizzaName, pizzaSize,pizzaTopping,pizzaQuantity));
                        break;
                    case 2:
                            // edit pizza cart
                            System.out.println();
                            System.out.println("#Edit Pizza Cart");
                            System.out.printf("%-20s","ID ");
                            System.out.printf("%-20s","Name ");
                            System.out.printf("%-20s","Size ");
                            System.out.printf("%-30s","Topping ");
                            System.out.printf("%-20s","Quantity ");
                            System.out.printf("%-20s%n","Price");
                            orderPizza.printCart();
                            // output pizza id
                            System.out.printf("%-20s: ","Edit Product ID ");
                            int editProductID = scanner.nextInt();
                            System.out.println();
                            System.out.printf("%-20s: " + editProductID + "%n","#Edit Pizza ID");
                            System.out.printf("%-20s: " + pizzaName + "%n","Pizza Name ");
                            // output pizza size
                            System.out.printf("%-20s: ","Pizza Size ");
                            System.out.printf("%-20s","1 - Small ");
                            System.out.printf("%-20s","2 - Medium ");
                            System.out.printf("%-20s%n","3 - Large ");
                            System.out.printf("%-20s: ","Select 1,2 or 3 ");
                            int editPizzaSize = scanner.nextInt();
                            String editSize = "";
                            switch(editPizzaSize){
                                case 1: editSize = "small"; break;
                                case 2: editSize = "Medium"; break;
                                case 3: editSize = "large"; break;
                                default: editSize = "Medium"; break;
                            }
                            // output pizza topping
                            System.out.printf("%-20s: ","Topping (Y/N) ");
                            String editTopping = scanner.next();
                            int countEditTopping = 0;
                            String[] editPizzaTopping = new String[3];
                            if(editTopping.equalsIgnoreCase("Y")){
                                System.out.printf("%-20s: ","Mushroom (Y/N) ");
                                String mushroom = scanner.next();
                                System.out.printf("%-20s: ","Pepperoni (Y/N) ");
                                String pepperoni = scanner.next();
                                System.out.printf("%-20s: ","Sausage (Y/N) ");
                                String sausage = scanner.next();

                                if(mushroom.equalsIgnoreCase("Y")){
                                    editPizzaTopping[countEditTopping++] = "Mushroom";
                                }
                                if(pepperoni.equalsIgnoreCase("Y")){
                                    editPizzaTopping[countEditTopping++] = "Pepperoni";
                                }
                                if(sausage.equalsIgnoreCase("Y")){
                                    editPizzaTopping[countEditTopping++] = "Sausage";
                                }
                            }
                            for(int i = 3; i > countEditTopping; i--){
                                editPizzaTopping[i-1] = "None";
                            }
                            // output pizza quantity
                            System.out.printf("%-20s: ","Pizza Quantity ");
                            int editProductQuantity = scanner.nextInt(); 
                            System.out.println();
                            System.out.printf("%-20s: " + editProductID + "%n","#Edit Pizza ID");
                            System.out.printf("%-20s","ID ");
                            System.out.printf("%-20s","Name ");
                            System.out.printf("%-20s","Size ");
                            System.out.printf("%-30s","Topping ");
                            System.out.printf("%-20s","Quantity ");
                            System.out.printf("%-20s%n","Price");
                            // update pizza 
                            orderPizza.updateCart(editProductID, editSize, editPizzaTopping, editProductQuantity);
                        break;
                    case 3:
                            // delete pizza cart
                            System.out.println();
                            System.out.println("#Delete Pizza Order");
                            System.out.printf("%-20s","ID ");
                            System.out.printf("%-20s","Name ");
                            System.out.printf("%-20s","Size ");
                            System.out.printf("%-30s","Topping ");
                            System.out.printf("%-20s","Quantity ");
                            System.out.printf("%-20s%n","Price ");
                            orderPizza.printCart();
                            // output pizza id
                            System.out.printf("%-20s: ","Delete Pizza ID ");
                            int deleteProductID = scanner.nextInt();
                            System.out.println();
                            System.out.printf("%-20s: " + deleteProductID + "%n","#Delete Pizza Order");
                            // remove pizza
                            orderPizza.removeCart(deleteProductID);
                            
                        break;
                    case 4:
                            // view pizza cart
                            System.out.println();
                            System.out.printf("%-20s%n","#View Pizza Cart");
                            System.out.printf("%-20s","ID ");
                            System.out.printf("%-20s","Name ");
                            System.out.printf("%-20s","Size ");
                            System.out.printf("%-30s","Topping ");
                            System.out.printf("%-20s","Quantity ");
                            System.out.printf("%-20s%n","Price");
                            // print cart
                            orderPizza.printCart();
                        break;
                    case 5: 
                            // Checkout pizza order
                            System.out.println();
                            System.out.println("#Checkout Pizza Order");
                            // output shipping address
                            System.out.printf("%-20s: " + customer.getShippingAddress() + "\n","Shipping Address ");
                            System.out.printf("%-20s: ","(Y/N) ");
                            String checkoutAddress = scanner.next();
                            int pointAdd = 0;
                            if(checkoutAddress.equalsIgnoreCase("Y")){
                                 pointAdd = orderPizza.addOrder(new Order(customer.getShippingAddress(), 0.0 , "confirm"));
                                
                            }else{
                                System.out.printf("%-20s: ","Shipping Address");
                                String newShippingAddress = scanner.nextLine();
                                newShippingAddress = scanner.nextLine();
                                pointAdd = orderPizza.addOrder(new Order(newShippingAddress, 0.0 , "confirm"));
                            }
                            // if the customer is member then add point, else nothing.
                            if(!(point == -1)){
                                point = ((Member)customer).addPoint(pointAdd);     
                            }          
                        break;
                    case 6:
                            // view pizza order
                            System.out.println();
                            System.out.println("#View Pizza Order");
                            System.out.printf("%-20s","ID ");
                            System.out.printf("%-20s","Name ");
                            System.out.printf("%-20s","Size ");
                            System.out.printf("%-30s","Topping ");
                            System.out.printf("%-20s","Quantity ");
                            System.out.printf("%-20s%n","Price");
                            // print order
                            orderPizza.printOrder();
                        break;
                    case 7:
                            // Exit
                            System.exit(0);
                    default: 
                            // Exception    

                }
                if(!(input== 4 || input == 5 || input == 6)){
                    System.out.print("Do you want to continue (Y) or go to main page (N): ");
                    decision = scanner.next();
                }else{
                    System.out.print("Go to main page (N): ");
                    decision = scanner.next();
                    decision = "N";
                }
                
                } while (decision.equalsIgnoreCase("Y"));
            }
        }
    }
}
