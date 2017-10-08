package main;

/**
 * Created by gryfit on 08/10/2017.
 */
public class CarSystem {

    public static void main(String[] args) {
        Position position1 = new Position(1, 2);
        System.out.println(position1);
        Position position2 = new Position(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection dir = MapDirection.East;
        System.out.println(dir);
        dir = dir.next();
        System.out.println(dir);
        dir = dir.previous();
        System.out.println(dir);


    }
}

