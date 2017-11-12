package main.mapElement;

import main.utility.MapDirection;
import main.utility.MoveDirection;
import main.utility.Position;
import main.maps.IWorldMap;

/**
 * Created by student40 on 2017-10-20.
 */
public class Car extends MapElement {
    private MapDirection dir = MapDirection.North;
    private IWorldMap map;

    public Car (IWorldMap map){
        super(new Position(2,2));
        this.map=map;
    }
    public Car (IWorldMap map, Position pos){
        super(pos);
        this.map=map;
    }

    public void move(MoveDirection direction){
        Position tmp=this.pos;
        switch (direction){
            case Left:
                this.dir=this.dir.previous();
                break;
            case Right:
                this.dir=this.dir.next();
                break;
            case Forward:
                switch (dir){
                    case North:
                        tmp = this.pos.add(new Position(0,1));
                        break;
                    case South:
                        tmp=this.pos.add(new Position(0,-1));
                        break;
                    case East:
                        tmp=this.pos.add(new Position(1,0));
                        break;
                    case West:
                        tmp=this.pos.add(new Position(-1,0));
                        break;
                }
                break;
            case Backward:
                switch (dir){
                    case North:
                        tmp=this.pos.add(new Position(0,-1));
                        break;
                    case South:
                        tmp=this.pos.add(new Position(0,1));
                        break;
                    case East:
                        tmp=this.pos.add(new Position(-1,0));
                        break;
                    case West:
                        tmp=this.pos.add(new Position(1,0));
                        break;
                }
                break;
        }
        if(map.canMoveTo(tmp)){
            this.pos=tmp;
        }
    }

    @Override
    public String toString(){
        switch (dir){
            case North:
                return "^";
            case South:
                return "V";
            case East:
                return ">";
            case West:
                return "<";
        }
        return " ";
    }
    @Override
    public boolean equals (Object other){
        if(this==other)
            return true;
        if(!(other instanceof Car))
            return false;
        Car that = (Car) other;
        return (this.dir==that.dir) && (this.pos.equals(that.pos));
    }
}
