import java.util.ArrayList;

public class Car {
    //Feilds
    private int goal; 
    private int pos;
    private ArrayList<Passenger> people;
    private static int IDgen;
    private int IDnum;
    private double balance; 
    private boolean Movingleft;
    private boolean Movingright;

    //Constructor
    public Car(int myPos, int myGoal){
        people = new ArrayList<Passenger>();
        pos = myPos;
        myGoal = goal;
        IDnum = IDgen;
        IDgen++;
        balance = 0.0;
        if(goal < pos){
            Movingleft = true;
            Movingright = false;
        }else{
            Movingleft = false;
            Movingright = true;
        }
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

    public boolean getDirectionality(){
        return Movingleft;
    }

    public String printDirectionality(){
        String blank = "";
        if(Movingleft){
            blank += "Left";
        }else{
            blank += "right";
        }
    return blank;
    }


    public int getPosC(){
        return pos;
    }

    public int getID(){
        return IDnum;
    }
//MUTATORS

public void addPassenger(Passenger x){
    people.add(x);
}

public void changePos(){
    if(getDirectionality()){
    pos--;
    }
    else{
    pos++;
    }

    int num = 0;
    for(Passenger x : people){
        num++;
    }
    balance += num;
}
    
//Printing stuff


public String toString(){
    String blank = "";
    for(Passenger x : people){
        blank += x.getIDnum() + ", ";
    }

    return "Car ID: " + IDnum + " passengers IDs( " + blank + ") Station: " + pos + " Moving " + printDirectionality() +  " goal " + goal + ", "; 
}
}