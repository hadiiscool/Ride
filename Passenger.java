public class Passenger {
    //Feilds
    private int start;
    private int goal;
    private boolean inCar;
    private static int IDgen;
    private int IDnum;
    private boolean AtGoal;

    //Constructor
    public Passenger(int myStart, int myGoal){
        start = myStart;
        goal = myGoal;
        inCar = false;
        IDnum = IDgen;
        IDgen++;
        AtGoal = false;
    }

    //Methods
    public int getStartP(){
        return start;
    }

    public int getGoalP(){
        return goal;
    }

    public boolean getinCar(){
        return inCar;
    }

    public void nowinCar(){
        inCar = true;
    }

    public void notinCar(){
        inCar = false;
    }

    public int getIDnum(){
        return IDnum;
    }

    public void AtGoal(){
        AtGoal = true;
    }

    public String toString(){
        return "Passenger: " + IDnum + "Passenger Goal: " + goal + "Are they at their goal? " + AtGoal;
    }
}
