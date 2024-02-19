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
    if(cars.size() > 0){
    for(int i = 0; i < waiting.size(); i++){
        for(int j = 0; j < cars.size(); j++){
            if(cars.get(j).getPassNum() < 3){
                if(cars.get(j).getDirectionality() == false){
                    if(waiting.get(i).getGoalP() > cars.get(j).getPosC()){
                        cars.get(j).addPassenger(waiting.remove(i));
                        i--;
                        break;
                    }

                } else if( cars.get(j).getDirectionality() == true){
                        if(waiting.get(i).getGoalP() < cars.get(j).getPosC()){
                            cars.get(j).addPassenger(waiting.remove(i));
                            i--;
                            break;
                        }
                }

    
            }
        }
    }
    }
}






public void addCars(Car x){
    cars.add(x);
}

public ArrayList<Car> getCars(){
    return cars;
}


public void updateCars(){
    emptyPassengers();
    destroyCars();
    loadPassengers();
}

public String printPassengers(){
    String blank = "";
    for(int k = 0; k < waiting.size(); k++){
        if(waiting.get(k).getGoalP() == StationNum){
            waiting.get(k).AtGoal();
        }
    blank += waiting.get(k).toString();
}
return blank;

}

public int getNumber(){
    return StationNum;
}

public String printCars(){
    String blank = "";
    for(int k = 0; k < cars.size(); k++){
        blank += cars.get(k).toString();
    }
return blank;
}

public String toString(){
    return "Station Num: " + StationNum +  "\nPassengers Waiting[" + printPassengers() + "]\nCars at Station[" + printCars() + "]\n";
}

}

