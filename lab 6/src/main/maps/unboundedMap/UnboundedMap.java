package main.maps.unboundedMap;

import main.mapElement.Car;
import main.mapElement.HayStack;
import main.mapElement.MapElement;
import main.mapElement.MapElementFactory;
import main.maps.MapVisualizer;
import main.utility.Position;
import main.maps.AbstractMap;
import main.maps.IWorldMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by student59 on 2017-11-10.
 */

public class UnboundedMap extends AbstractMap implements IWorldMap {
    private HashMap<Position,MapElement> immovableElMap = new HashMap<>();


    public UnboundedMap (LinkedList<HayStack> list) throws IllegalArgumentException {
        //immovableElList.addAll(list);
        for (HayStack hs_l : list) {
            if (immovableElMap.get(hs_l.getPosition()).equals(null)) {
                throw new IllegalArgumentException(hs_l.toString() + "cant be add");
            }
        }
    }

  /*  public UnboundedMap (String[] imEl, Position[] imElPos){
        MapElementFactory elFactory = new MapElementFactory();
        elFactory.ImmovableFactory(imEl,imElPos);
        //immovableElList.addAll(elFactory.getImmovableElements());

        for(HayStack hs_l: immovableElList){
            boolean dontExist = true;
            for(MapElement hs_iel: immovableElList){
                if(hs_l.getPosition().equals(hs_iel.getPosition())){
                    dontExist=false;
                }
            }
            if(!dontExist){
                throw  new IllegalArgumentException(hs_l.toString()+"cant be add");
            }
        }
    }
*/
    public boolean canMoveTo(Position position){
        boolean can = super.canMoveTo(position);
        if(!immovableElMap.get(position).equals(null)){
            return false;
        }
        return can;
    }

    public Object objectAt(Position position){
        Object ob = super.objectAt(position);
            if(!immovableElMap.get(position).equals(null)){
                return immovableElMap.get(position);
            }
        return ob;
    }

    @Override
    public String toString (){
        int maxX = 0; int maxY=0; int minX=0;int minY=0;
        for(Car c: cars){
            maxX = c.getPosition().x > maxX ? c.getPosition().x : maxX;
            minX = c.getPosition().x < minX ? c.getPosition().x : minX;
            maxY = c.getPosition().y > maxY ? c.getPosition().y : maxY;
            minY = c.getPosition().y < minY ? c.getPosition().y : minY;
        }
        for(Map.Entry<Position,MapElement> el : immovableElMap.entrySet()){
            maxX = el.getKey().x > maxX ? el.getKey().x : maxX;
            minX = el.getKey().x < minX ? el.getKey().x : minX;
            maxY = el.getKey().y > maxY ? el.getKey().y : maxY;
            minY = el.getKey().y < minY ? el.getKey().y : minY;
        }
        Position upperRight = new Position(maxX,maxY);
        Position lowerLeft = new Position(minX,minY);

        return MapVisualizer.dump(this,lowerLeft,upperRight);
    }
}
