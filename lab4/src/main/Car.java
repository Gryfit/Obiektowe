package main;

import java.util.Map;

/**
 * Created by student40 on 2017-10-20.
 */
public class Car {
    private MapDirection dir = MapDirection.North;
    private Position pos = new Position(2,2);
    private IWorldMap map;

    public Car (IWorldMap map){
        this.map=map;
    }
    public Car (IWorldMap map, int x, int y){
        this.pos = new Position(x,y);
        this.map=map;
    }



    public Position getPosition (){return this.pos;}

    public void setDirection  (MapDirection dir){ this.dir = dir;}

    public void setPosition (Position pos){ this.pos = pos;}

//przez przypisanie wektora żeby zmniejszyć redundancję

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
