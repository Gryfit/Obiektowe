package tests;

import main.mapElement.Car;
import main.mapElement.HayStack;
import main.maps.IWorldMap;
import main.maps.rectangularMap.RectangularMap;
import main.maps.unboundedMap.UnboundedMap;
import main.utility.MapDirection;
import main.utility.MoveDirection;
import main.utility.Position;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by gryfit on 12/11/2017.
 */
public class UnboundedMapTest {
    @Test
    public void EndtoEndTest() {
        MoveDirection[] directions = new MoveDirection[2];
        directions[0]=MoveDirection.Forward;
        directions[1]=MoveDirection.Forward;
        LinkedList<HayStack> hs = new LinkedList<>();
        hs.add(new HayStack(new Position(2,3)));
        IWorldMap map3 = new UnboundedMap(hs);
        map3.place(new Car(map3));
        map3.place(new Car(map3,new Position(3,4)));
        assertEquals(map3.toString()," y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | | | | |\n" +
                "  4: | | | |^| | |\n" +
                "  3: | | |S| | | |\n" +
                "  2: | | |^| | | |\n" +
                "  1: | | | | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------");
        map3.run(directions);
        assertEquals(map3.toString()," y\\x  0 1 2 3 4 5\n" +
                "  6: -------------\n" +
                "  5: | | | |^| | |\n" +
                "  4: | | | | | | |\n" +
                "  3: | | |S| | | |\n" +
                "  2: | | |^| | | |\n" +
                "  1: | | | | | | |\n" +
                "  0: | | | | | | |\n" +
                " -1: -------------");
    }

}