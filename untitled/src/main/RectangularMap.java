package main;


import java.util.LinkedList;
import java.util.ListIterator;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;
    private LinkedList<Car> Cars;
    RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
    }


    public boolean canMoveTo(Position position){
        return position.smaller(new Position(width,height)) && position.larger(new Position(0,0));
    }

    public boolean place(Car car){
        if(this.canMoveTo(car.getPosition())){
            Cars.add(car);
            return true;
        }
        return false;
    }

    public void run(MoveDirection[] directions){
        ListIterator<Car> listIterator = Cars.listIterator();
        int i=0;
        while(directions.length)
    }

    public boolean isOccupied(Position position){

    }

    public Object objectAt(Position position){

    }
}
