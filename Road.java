import java.util.ArrayList;

public class Road{
//FEILDS
private ArrayList<Station> road;
private int numstations;

//CONSTRUCTOR
public Road(int myNumstations){
    road = new ArrayList<Station>();
    numstations = myNumstations;
}
//Methods (take all stations and update them so that all cars move once and stations updates and prints things!)

public void update(){

    for(int i = 0; i < road.size(); i++){
        road.get(i).updateCars();
        for(int j = 0; j < road.get(i).getCars().size(); j++){
            road.get(i).getCars().get(j).changePos();
            if(road.get(i).getCars().get(j).getDirectionality() == true){
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

}