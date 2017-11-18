package main;

import main.mapElement.Car;
import main.mapElement.HayStack;
import main.maps.IWorldMap;
import main.maps.rectangularMap.RectangularMap;
import main.maps.unboundedMap.UnboundedMap;
import main.utility.MoveDirection;
import main.utility.OptionParser;
import main.utility.Position;

import java.util.LinkedList;

/**
 * Created by gryfit on 08/10/2017.
 */
public class CarSystem {


    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionParser().parse(args);
        LinkedList<HayStack> HS =new LinkedList<>();
            HS.add(new HayStack(new Position(3,3)));
            HS.add(new HayStack(new Position(10,10)));
        IWorldMap map = new UnboundedMap(HS);
        map.place(new Car(map));
        map.place(new Car(map,new Position(5,4)));
        System.out.print(map.toString());
        map.run(directions);
        System.out.print(map.toString());

/*
        String [] elements = new String[2];
            elements[0]="main.mapElement.HayStack";
            elements[1]="main.mapElement.HayStack";
        Position [] elementsPos = new Position[2];
            elementsPos[0]=new Position(2,3);
            elementsPos[1]=new Position(10,10);
        IWorldMap map2 = new UnboundedMap(elements,elementsPos);
        map2.place(new Car(map));
        map2.place(new Car(map,new Position(5,4)));
        System.out.print(map2.toString());
        map.run(directions);
*/
        MoveDirection[] directions2 = new MoveDirection[2];
        directions2[0]=MoveDirection.Forward;
        directions2[1]=MoveDirection.Forward;
        IWorldMap map3 = new RectangularMap(5, 5);
        map3.place(new Car(map3));
        map3.place(new Car(map3,new Position(3,4)));
        System.out.print(map3.toString());
        map3.run(directions2);
        System.out.print(map3.toString());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}

