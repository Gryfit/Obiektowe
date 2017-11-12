package main.maps.unboundedMap;

import main.mapElement.Car;
import main.mapElement.HayStack;
import main.mapElement.MapElement;
import main.mapElement.MapElementFactory;
import main.maps.MapVisualizer;
import main.utility.Position;
import main.maps.AbstractMap;
import main.maps.IWorldMap;
import java.util.LinkedList;

/**
 * Created by student59 on 2017-11-10.
 */

//ZAPYTAC List<MapElement> vs List<? extends MapElement> vs List<Class<? extends MapElement>>!!!!!!
    //a dokładnie czemu drugie nie działa w haystack'em

public class UnboundedMap extends AbstractMap implements IWorldMap {
    private LinkedList<MapElement> immovableElList = new LinkedList<>();

    public UnboundedMap (LinkedList<HayStack> list){
       immovableElList.addAll(list);
    }

    public UnboundedMap (String[] imEl, Position[] imElPos){
        MapElementFactory elFactory = new MapElementFactory();
        elFactory.ImmovableFactory(imEl,imElPos);
        immovableElList.addAll(elFactory.getImmovableElements());
    }

    public boolean canMoveTo(Position position){
        boolean can = super.canMoveTo(position);
        for(MapElement s : immovableElList){
            if(s.getPosition().equals(position)){
                can=false;
            }
        }
        return can;
    }

    public Object objectAt(Position position){
        Object ob = super.objectAt(position);
        for(MapElement el: immovableElList){
            if(el.getPosition().equals(position)){
                return el;
            }
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
        for(MapElement el: immovableElList){
            maxX = el.getPosition().x > maxX ? el.getPosition().x : maxX;
            minX = el.getPosition().x < minX ? el.getPosition().x : minX;
            maxY = el.getPosition().y > maxY ? el.getPosition().y : maxY;
            minY = el.getPosition().y < minY ? el.getPosition().y : minY;
        }
        Position upperRight = new Position(maxX,maxY);
        Position lowerLeft = new Position(minX,minY);

        return MapVisualizer.dump(this,lowerLeft,upperRight);
    }
}
