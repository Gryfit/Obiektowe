package main.maps;


import main.mapElement.Car;
import main.Position;

import java.util.LinkedList;

public class RectangularMap extends AbstractMap implements IWorldMap {
    private final int width;
    private final int height;
    private LinkedList<Car> cars= new LinkedList<Car>();
    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
    }

    public boolean canMoveTo(Position position){
        return position.smaller(new Position(width,height))
                && position.larger(new Position(0,0))
                && !isOccupied(position);
    }


    @Override
    public String toString (){
        return MapVisualizer.dump(this, new Position(0, 0), new Position(width, height));
        //cannot be referenced form a static context ???
    }
}
