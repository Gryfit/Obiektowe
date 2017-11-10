package main.mapElement;

import main.Position;

/**
 * Created by student59 on 2017-11-10.
 */
public class HayStack {
    Position pos;
    public HayStack(Position pos){
        this.pos=pos;
    }
    public Position getPosition(){
        return pos;
    }
    @Override
    public String toString(){
        return "s";
    }

}
