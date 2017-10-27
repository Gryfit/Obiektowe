package tests;

import main.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testMoveConstructor() throws Exception {
        Car c = new Car();
        Car tmp;
        tmp = new Car();
        tmp.setDirection(MapDirection.North); tmp.setPosition(new Position(2,2));
        assertEquals(c,tmp);
    }
    @Test
    public void testMoveForwardTillOutOfRange() throws Exception {
        Car c = new Car();
        Car tmp = new Car();
        //Forward till out of range
        for(int i=3; i<=4;i++){
            c.move(MoveDirection.Forward);
            tmp.setDirection(MapDirection.North); tmp.setPosition(new Position(2,i));
            assertEquals(c,tmp);
        }
        c.move(MoveDirection.Forward);
        tmp.setDirection(MapDirection.North); tmp.setPosition(new Position(2,4));
        assertEquals(c,tmp);
    }
    @Test
    public void testMoveBackwardTillOutOfRange() throws Exception {
        Car c = new Car();
        Car tmp = new Car();
        //Backward till out of range
        for(int i=1; i>=0;i--){
            c.move(MoveDirection.Backward);
            tmp.setDirection(MapDirection.North); tmp.setPosition(new Position(2,i));
            assertEquals(c,tmp);
        }
        c.move(MoveDirection.Backward);
        tmp.setDirection(MapDirection.North); tmp.setPosition(new Position(2,0));
        assertEquals(c,tmp);
    }
    @Test
    public void testMove4Right() throws Exception {
        Car c = new Car();
        Car tmp = new Car();
        //4xRight
        MapDirection D = MapDirection.East;
        for(int i=0; i<4;i++){
            c.move(MoveDirection.Right);
            tmp.setDirection(D); tmp.setPosition(new Position(2,2));
            assertEquals(c,tmp);
            D=D.next();
        }
    }
    @Test
    public void testMove4Left() throws Exception {
        Car c = new Car();
        Car tmp = new Car();
        //4xLeft
        MapDirection D = MapDirection.West;
        for(int i=0; i<4;i++){
            c.move(MoveDirection.Left);
            tmp.setDirection(D); tmp.setPosition(new Position(2,2));
            assertEquals(c,tmp);
            D=D.previous();
        }
    }
}