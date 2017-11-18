package main.maps;

import javafx.geometry.Pos;
import main.mapElement.Car;
import main.utility.MoveDirection;
import main.utility.Position;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by student59 on 2017-11-10.
 */
//jaki jest sens interfejsu
public abstract class AbstractMap implements IWorldMap{
    protected HashMap<Position,Car> cars= new HashMap<>();

    public boolean canMoveTo(Position position){
        if(cars.get(position).equals(null)){
            return true;
        }
        return false;
    }
    public boolean place(Car car) throws IllegalArgumentException{
        if(this.canMoveTo(car.getPosition())){
            cars.put(car.getPosition(),car);
            return true;
        }
        throw new IllegalArgumentException("Cannot place the Car");
    }

    public void run(MoveDirection[] directions){
        int i=0;
        while(i<directions.length){
            for(HashMap.Entry<Position,Car> c : cars.entrySet()){
                Position pOld = c.getKey();
                c.getValue().move(directions[i++]);
                if(!pOld.equals(c.getValue().getPosition())){
                    cars.put(c.getValue().getPosition(),c.getValue());
                    cars.remove(c.getKey());
                    //ODWRACA MI SIE KOLEJNOSC ;-;
                }
            }
        }
    }

    public Object objectAt(Position position){
        return cars.get(position);
    }

    public boolean isOccupied(Position position){
        return !canMoveTo(position);
    }

    @Override
    public abstract String toString ();
}
