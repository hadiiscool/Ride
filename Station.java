import java.util.ArrayList;

public class Station {
    //FEILDS
    private ArrayList<Car> cars;
    private int StationNum;
    private static int StationNumGen;
    private ArrayList<Passenger> waiting;


//Need to empty all passengers that are in cars at destination THEN...
//Destroy cars that have reached destinatin THEN...
//Need to get all passengers waiting and put them on cars that still exist!

//Constructor
public Station(){
    cars = new ArrayList<Car>();
    waiting = new ArrayList<Passenger>();
    StationNum = StationNumGen;
    StationNumGen++;
}


public void addtoWaiting(Passenger x){
    waiting.add(x);
}





public void destroyCars(){
    for(int i = 0; i < cars.size(); i++){
    int location = cars.get(i).getPosC();

        if( location == StationNum && location == cars.get(i).getGoalC()){
//Adds all pasengers in the destroyed car to waiting!
            for(int j = 0; j < cars.get(i).getpassangerlist().size(); j++){
                waiting.add(cars.get(i).getpassangerlist().get(j));
                }
        cars.remove(i);

            } 

        
        }
}






public void emptyPassengers(){

    for(int i = 0; i < cars.size(); i++){
    int locationC = cars.get(i).getPosC();

        for(int j = 0; j < cars.get(i).getpassangerlist().size(); j++){
        int goalP = cars.get(i).getpassangerlist().get(j).getGoalP();

            if(locationC == goalP){
                waiting.add(cars.get(i).getpassangerlist().get(j));
                cars.get(i).getpassangerlist().remove(cars.get(i).getpassangerlist().get(j));
            }

        }
    }
}


public void loadPassengers(){
    for(int i = 0; i < waiting.size(); i++){
        for(int j = 0; j < cars.size(); j++){
            if(cars.get(j).getPassNum() < 3 && waiting.get(i).getGoalP() < cars.get(j).getGoalC()){
                cars.get(j).getpassangerlist().add(waiting.remove(i));
            }
        }
    }
}


public void updateCars(){
    emptyPassengers();
    destroyCars();
    loadPassengers();




}
}

