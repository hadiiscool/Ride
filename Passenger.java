public class Passenger {
    //Feilds
    private int start;
    private int goal;
    private boolean inCar;

    //Constructor
    public Passenger(int myStart, int myGoal){
        start = myStart;
        goal = myGoal;
        inCar = false;
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
    
}
