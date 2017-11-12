package main.maps;

import main.mapElement.Car;
import main.utility.MoveDirection;
import main.utility.Position;

/**
 * Created by student42 on 2017-10-27.
 */
public interface IWorldMap {
    boolean canMoveTo(Position position);

    boolean place(Car car);

    void run(MoveDirection[] directions);

    boolean isOccupied(Position position);

    Object objectAt(Position position);
}
