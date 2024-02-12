import java.util.ArrayList;

public class Car {
    //Feilds
    private int start;
    private int goal; 
    private ArrayList<Passenger> people;
    private static int IDgen;
    private int IDnum;

    //Constructor
    public Car(int myStart, int myGoal){
        people = new ArrayList<Passenger>();
        start = myStart;
        myGoal = goal; 
        IDnum = IDgen;
        IDgen++;
    }

    //Methods

    public ArrayList<Passenger> passangerNum(){
        return people;
    }
}
