package main.mapElement;

import main.utility.Position;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

/**
 * Created by gryfit on 11/11/2017.
 */
public class MapElementFactory {
//    private LinkedList<Car> cars;
    private LinkedList<MapElement> immovableElements = new LinkedList<>();
    @SuppressWarnings("unchecked")
        public void ImmovableFactory (String[] elements, Position[] positions){
        try {
            for (int i = 0; i < elements.length; i++) {
                immovableElements.add((MapElement)
                        Class.forName(elements[i]).getConstructor(Position.class).newInstance(positions[i]));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
       /* catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        */
    }
    public LinkedList<MapElement> getImmovableElements (){return immovableElements;}

/*    public void CarsFactory(Position[] positions, IWorldMap map){
        for(Position p : positions) {
            cars.add(new Car(map,p));
        }
    }
    public LinkedList<Car> getCars (){return cars;}
*/

}

