package main.maps.rectangularMap;


import main.mapElement.Car;
import main.maps.MapVisualizer;
import main.utility.Position;
import main.maps.AbstractMap;
import main.maps.IWorldMap;

import java.util.LinkedList;

public class RectangularMap extends AbstractMap implements IWorldMap {
    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
    }
    public boolean canMoveTo(Position position){
        return position.smaller(new Position(width,height))
                && position.larger(new Position(0,0))
                && super.canMoveTo(position);
    }

    @Override
    public String toString (){
        return MapVisualizer.dump(this, new Position(0, 0), new Position(width, height));
    }
}
