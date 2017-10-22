package tests;

import main.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class OptionParserTest {

    @Test
    public void testParseCorrect() throws Exception {
        OptionParser p = new OptionParser();
        String[] comm = new String [1]; comm[0]="f";
        MoveDirection[] d = new MoveDirection[1]; d[0]=MoveDirection.Forward;
        assertEquals(p.parse(comm)[0],d[0]);
        comm[0]="forward";
        assertEquals(p.parse(comm)[0],d[0]);
        comm[0]="b"; d[0]=MoveDirection.Backward;
        assertEquals(p.parse(comm)[0],d[0]);
        comm[0]="backward"; d[0]=MoveDirection.Backward;
        assertEquals(p.parse(comm)[0],d[0]);
    }
    @Test
    public void testParseWrong() throws Exception {
        OptionParser p = new OptionParser();
        String[] comm = new String [2]; comm[0]="LOL"; comm[1]="f";
        MoveDirection[] d = new MoveDirection[1]; d[0]=MoveDirection.Forward;
        assertEquals(p.parse(comm)[0],d[0]);
    }
}