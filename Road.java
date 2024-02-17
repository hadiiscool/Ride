import java.util.ArrayList;

public class Road{
//FEILDS
private ArrayList<Station> road;
private int numstations;
private int numpassengers;
private int numcars;
private ArrayList<Passenger> temp1;
private ArrayList<Car> temp2;

//CONSTRUCTOR
public Road(int myNumstations,int myNumpassengers, int myNumcars){
    road = new ArrayList<Station>();
    temp1 = new ArrayList<Passenger>();
    temp2 = new ArrayList<Car>();
    numstations = myNumstations;
    numpassengers = myNumpassengers;
    numcars = myNumcars;
    makeStations();
    makeCars();
    makePassengers();
}
//Methods (take all stations and update them so that all cars move once and stations updates and prints things!)


public void temp(){

for(int k = 0; k < road.size(); k++){
    road.get(k).updateCars();
}
}

public void updateCars(){

    for(int i = 0; i < road.size(); i++){


        for(int j = 0; j < road.get(i).getCars().size(); j++){
            road.get(i).getCars().get(j).changePos();
            if(road.get(i).getCars().get(j).getPosC() < 0){
                road.get(road.size() - 1).addCars(road.get(i).getCars().get(j));
            }
            else if(road.get(i).getCars().get(j).getDirectionality() == true){
                road.get(i - 1).addCars(road.get(i).getCars().get(j));
                road.get(i).getCars().remove(j);
            }else if(road.get(i).getCars().get(j).getDirectionality() == false){
                road.get(i + 1).addCars(road.get(i).getCars().get(j));
                road.get(i).getCars().remove(j);
            }

        }


        road.get(i).updateCars();
    }
}

public void makePassengers(){
    for(int i = 0; i < numpassengers; i++){
        int start = (int) (Math.random() * numstations);
        int goal = (int) (Math.random() * numstations);
        Passenger x = new Passenger(start, goal);
        temp1.add(x);
    for(int j = 0; j < road.size(); j++){
        for(int k = 0; k < temp1.size(); k++){
        if(temp1.get(k).getStartP() == road.get(j).getNumber()){
            road.get(j).addtoWaiting(temp1.remove(k));
            k--;
        }
    }
}
    }

}



public void makeCars(){
for(int i = 0; i < numcars; i++){
    int start = (int) (Math.random() * numstations);
    int goal = (int) (Math.random() * numstations);
    Car x = new Car(start,goal);
    temp2.add(x);
}
for(int j = 0; j < road.size(); j++){
    for(int k = 0; k < temp2.size(); k++){
    if(temp2.get(k).getPosC() == road.get(j).getNumber()){
        road.get(j).addCars(temp2.remove(k));
        k--;
    }
}
}
}



public void makeStations(){
for(int i = 0; i < numstations; i++){
    Station x = new Station();
    road.add(x);
}
}


public String toString(){
    String blank = "";
    for(int i = 0; i < road.size(); i++){
        blank += road.get(i).toString() + " \n";
    }
    return blank;
}
        
}


