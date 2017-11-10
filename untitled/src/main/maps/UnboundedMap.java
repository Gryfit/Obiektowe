package main.maps;

import main.mapElement.Car;
import main.mapElement.HayStack;
import main.Position;

import java.util.LinkedList;

/**
 * Created by student59 on 2017-11-10.
 */
public class UnboundedMap extends AbstractMap implements IWorldMap{
    private LinkedList<HayStack> hayStactList;
    private LinkedList<Car> cars= new LinkedList<Car>();
    public UnboundedMap (LinkedList<HayStack> list){
       for(HayStack i:list){
           hayStactList.add(i);
       }
    }

    public boolean canMoveTo(Position position){
        boolean nothay = true;
        for(HayStack s : hayStactList){
            if(s.getPosition().equals(position)){
                nothay=false;
            };
        }
        boolean notc = true;
        for(Car s : cars){
            if(s.getPosition().equals(position)){
                notc=false;
            };
        }
        return (notc && nothay);
    }

    public Object objectAt(Position position){
        Object ob = super.objectAt(position);
        for(HayStack hs: hayStactList){
            if(hs.getPosition().equals(position)){
                return hs;
            }
        }
        return null;
    }

    @Override
    public String toString (){
        StringBuilder builder = new StringBuilder();
        int maxX = 0; int maxY=0; int minX=0;int minY=0;
        for(Car c: cars){
           maxX = c.getPosition().x > maxX ? c.getPosition().x : maxX;
            minX = c.getPosition().x < minX ? c.getPosition().x : minX;
            maxY = c.getPosition().y > maxY ? c.getPosition().y : maxY;
            minY = c.getPosition().y < minY ? c.getPosition().y : minY;
        }
        for(HayStack hs: hayStactList){
            maxX = hs.getPosition().x > maxX ? hs.getPosition().x : maxX;
            minX = hs.getPosition().x < minX ? hs.getPosition().x : minX;
            maxY = hs.getPosition().y > maxY ? hs.getPosition().y : maxY;
            minY = hs.getPosition().y < minY ? hs.getPosition().y : minY;
        }
        Position upperRight = new Position(maxX,maxY);
        Position lowerLeft = new Position(minX,minY);
        for (int i = upperRight.y + 1; i >= lowerLeft.y - 1; i--) {
            if (i == upperRight.y + 1) {
                builder.append(" y\\x ");
                for (int j = lowerLeft.x; j < upperRight.x + 1; j++) {
                    builder.append(String.format("%2d", j));
                }
                builder.append(System.lineSeparator());
            }
            builder.append(String.format("%3d: ", i));
            for (int j = lowerLeft.x; j <= upperRight.x + 1; j++) {
                Position currentPosition = new Position(j, i);
                if (j <= upperRight.x) {
                    if (i < lowerLeft.y || i > upperRight.y) {
                        builder.append("--");
                    } else {
                        builder.append("|");
                        if (this.isOccupied(currentPosition)) {
                            Object object = this.objectAt(currentPosition);
                            builder.append(object.toString());
                        } else {
                            builder.append(" ");
                        }
                    }
                } else {
                    if (i < lowerLeft.y || i > upperRight.y) {
                        builder.append("-");
                    } else {
                        builder.append("|");
                    }
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
