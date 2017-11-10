package main.mapElement;

import main.MoveDirection;
import main.Position;
import main.maps.IWorldMap;

/**
 * Created by student59 on 2017-11-10.
 */
public interface IMapElement {
    IWorldMap map;
    Position pos= new Position(0,0);
    public Position getPosition();
    @Override
    public String toString();
}
