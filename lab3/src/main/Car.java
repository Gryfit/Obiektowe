package main;

import java.util.Map;

/**
 * Created by student40 on 2017-10-20.
 */
public class Car {
    private MapDirection Dir;
    private Position Pos;

    @Override
    public String toString(){
        return Dir.toString() + " " + Pos.toString();
    }

    public Car (){
        this.Dir = MapDirection.North;
        this.Pos = new Position(2,2);
    }

    public MapDirection getDirection (){return this.Dir;}

    public Position getPosition (){return this.Pos;}

    public void setDirection  (MapDirection dir){ this.Dir = dir;}

    public void setPosition (Position pos){ this.Pos = pos;}

    public void move(MoveDirection direction){
        Position tmp=this.Pos;
        switch (direction){
            case Left:
                this.Dir=this.Dir.previous();
                break;
            case Right:
                this.Dir=this.Dir.next();
                break;
            case Forward:
                switch (Dir){
                    case North:
                        tmp = this.Pos.add(new Position(0,1));
                        break;
                    case South:
                        tmp=this.Pos.add(new Position(0,-1));
                        break;
                    case East:
                        tmp=this.Pos.add(new Position(1,0));
                        break;
                    case West:
                        tmp=this.Pos.add(new Position(-1,0));
                        break;
                }
                break;
            case Backward:
                switch (Dir){
                    case North:
                        tmp=this.Pos.add(new Position(0,-1));
                        break;
                    case South:
                        tmp=this.Pos.add(new Position(0,1));
                        break;
                    case East:
                        tmp=this.Pos.add(new Position(-1,0));
                        break;
                    case West:
                        tmp=this.Pos.add(new Position(1,0));
                        break;
                }
                break;
        }
        if(tmp.x>=0 && tmp.y>=0 && tmp.x<=4 && tmp.y<=4){
            this.Pos=tmp;
        }
    }
    @Override
    public boolean equals (Object other){
        if(this==other)
            return true;
        if(!(other instanceof Car))
            return false;
        Car that = (Car) other;
        return (this.Dir==that.Dir) && (this.Pos.equals(that.Pos));
    }
}
