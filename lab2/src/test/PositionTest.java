package test;

import javafx.geometry.Pos;
import main.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gryfit on 08/10/2017.
 */
public class PositionTest {
    @Test
    public void testToString() throws Exception {
        Position a = new Position(1,1);
        assertEquals(a.toString(),"(1,1)");
        a = new Position(1,2);
        assertEquals(a.toString(),"(1,2)");
        a = new Position(-1,1);
        assertEquals(a.toString(),"(-1,1)");
        a = new Position(4,11);
        assertEquals(a.toString(),"(4,11)");
    }

    @Test
    public void testSmaller() throws Exception {
        Position a = new Position(1,1);
        Position b = new Position(2,1);
        assertTrue(a.smaller(b));
    }

    @Test
    public void testLarger() throws Exception {
        Position a = new Position(2,2);
        Position b = new Position(1,1);
        assertTrue(a.larger(b));
    }

    @Test
    public void testAdd() throws Exception {
        Position a = new Position(2,2);
        Position b = new Position(1,1);
        assertEquals(a.add(b),new Position(3,3));
    }
}