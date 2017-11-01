package main;


import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.ListIterator;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;
    private LinkedList<Car> cars= new LinkedList<>();
    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
    }


    public boolean canMoveTo(Position position){
        return position.smaller(new Position(width,height))
                && position.larger(new Position(0,0))
                && !isOccupied(position);
    }

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

    public boolean isOccupied(Position position){
        for(Car c: cars){
             if(c.getPosition().equals(position)){
                 return true;
             }

        }
        return false;
    }

    public Object objectAt(Position position){
        for(Car c: cars){
            if(c.getPosition().equals(position)){
                return c;       //we want ref to this car object not a new car object.
            }
        }
        return null;
    }
    @Override
    public String toString (){
        return MapVisualizer.dump(this, new Position(0,0),new Position(width,height));
        //cannot be referenced form a static context ???
    }
}
