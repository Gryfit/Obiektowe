package tests;

import main.MapDirection;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by gryfit on 08/10/2017.
 */
public class MapDirectionTest {
    @Test
    public void testNext(){
             /*
             North-> East
             South-> West
             West-> North
             East-> South
             */
        MapDirection a = MapDirection.North;
        a=a.next();
        assertEquals(a, MapDirection.East);
        a=a.next();
        assertEquals(a, MapDirection.South);
        a=a.next();
        assertEquals(a, MapDirection.West);
        a=a.next();
        assertEquals(a, MapDirection.North);
    }
    @Test
    public void testPrevious(){
            /*
            North-> West
            South-> East
            West-> South
            East-> North
            */
        MapDirection a = MapDirection.North;
        a=a.previous();
        assertEquals(a, MapDirection.West);
        a=a.previous();
        assertEquals(a, MapDirection.South);
        a=a.previous();
        assertEquals(a, MapDirection.East);
        a=a.previous();
        assertEquals(a, MapDirection.North);
    }
}