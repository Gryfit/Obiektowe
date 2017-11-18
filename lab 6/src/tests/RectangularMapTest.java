package tests;

import main.mapElement.Car;
import main.maps.IWorldMap;
import main.maps.rectangularMap.RectangularMap;
import main.utility.MoveDirection;
import main.utility.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gryfit on 12/11/2017.
 */
public class RectangularMapTest {
    @Test
    public void EndtoEndTest() {
        MoveDirection[] directions = new MoveDirection[2];
        directions[0]=MoveDirection.Forward;
        directions[1]=MoveDirection.Forward;
        IWorldMap map3 = new RectangularMap(5, 5);
        map3.place(new Car(map3));
        map3.place(new Car(map3,new Position(3,4)));
        assertEquals(map3.toString()," y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | | | | |\n" +
                "  4: | | | |^| | |\n" +
                "  3: | | | | | | |\n" +
                "  2: | | |^| | | |\n" +
                "  1: | | | | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------");
        map3.run(directions);
        assertEquals(map3.toString()," y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | |^| | |\n" +
                "  4: | | | | | | |\n" +
                "  3: | | |^| | | |\n" +
                "  2: | | | | | | |\n" +
                "  1: | | | | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------");
    }


}