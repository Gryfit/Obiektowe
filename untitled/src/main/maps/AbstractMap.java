package main.maps;

import main.mapElement.Car;
import main.MoveDirection;
import main.Position;

import java.util.LinkedList;

/**
 * Created by student59 on 2017-11-10.
 */
public abstract class AbstractMap implements IWorldMap{
    private LinkedList<Car> cars= new LinkedList<Car>();

    public boolean place(Car car){
        if(this.canMoveTo(car.getPosition())){
            cars.add(car);
            return true;
        }
        return false;
    }

    public void run(MoveDirection[] directions){
        int i=0;
        while(i<directions.length){
            for(Car c : cars){
                c.move(directions[i++]);
            }
        }
    }

    public Object objectAt(Position position){
        for(Car c: cars){
            if(c.getPosition().equals(position)){
                return c;       //we want ref to this car object not a new car object.
            }
        }
        return null;
    }

    public boolean isOccupied(Position position){
        return !canMoveTo(position);
    }


    @Override
    public abstract String toString ();
}
