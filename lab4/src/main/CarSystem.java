package main;

import java.util.LinkedList;

/**
 * Created by gryfit on 08/10/2017.
 */
public class CarSystem {


    public static void main(String[] args) {
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        System.out.print(map.toString());
        map.run(directions);
        System.out.print(map.toString());

    }

}

