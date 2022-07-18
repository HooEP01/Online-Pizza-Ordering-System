/*
 * Hoo Ern Ping B200152B
 */

public class Member extends Customer{
    
    // instance variable
    private int point;

    // default constructor
    Member(){
        super();
        this.point = 0;
    }

    // constructor with parameter
    Member(String name, String contactNo, String shippingAddress, String email, String password, int point){
        super(name, contactNo, shippingAddress, email, password);
        this.point = point;
    }

    // mutator method
    public void setPoint(int point){
        this.point = point;
    }

    // accessor method
    public int getPoint(){
        return point;
    }

    // add point method
    public int addPoint(int newPoint){
        return this.point = point + newPoint;
    }

}