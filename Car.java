import java.util.ArrayList;

public class Car {
    //Feilds
    private int goal; 
    private int pos;
    private ArrayList<Passenger> people;
    private static int IDgen;
    private int IDnum;
    private double balance; 

    //Constructor
    public Car(int myPos, int myGoal){
        people = new ArrayList<Passenger>();
        pos = myPos;
        myGoal = goal;
        IDnum = IDgen;
        IDgen++;
        balance = 0.0;
    }

    //Methods

//GETTERS:

    public ArrayList<Passenger> getpassangerlist(){
        return people;
    }

    public int getPassNum(){
        int count = 0;
        for(Passenger x : people){
            count++;
        }
    return count;
    }


    public int getGoalC(){
        return goal;
    }

    public int getPosC(){
        return pos;
    }

    public int getID(){
        return IDnum;
    }
//MUTATORS

public void addPassanger(Passenger x){
    people.add(x);
}

public void changePos(){
    pos++;
    int num = 0;
    for(Passenger x : people){
        num++;
    }
    balance += num;
}
    
//Printing stuff


public String toString(){
    int count = 0; 
    for(Passenger x : people){
        count++;
    }

    return "Car ID:" + IDnum + "The number of passengers" + count + "Station: " + pos; 
}
}