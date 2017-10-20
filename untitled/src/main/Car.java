package main;

/**
 * Created by student40 on 2017-10-20.
 */
public class Car {
    private
    MapDirection Dir;
    Position Poz;
    Car (){
        this.Dir = MapDirection.North;
        this.Poz = new Position(2,2);
    }
    public
    @Override
     String toString(){
    return Dir.toString() + " " + Poz.toString();
    }
    void move(MoveDirection direction){
        Position tmp=this.Poz;
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
                        tmp = this.Poz.add(new Position(0,1));
                        break;
                    case South:
                        tmp=this.Poz.add(new Position(0,-1));
                        break;
                    case East:
                        tmp=this.Poz.add(new Position(1,0));
                        break;
                    case West:
                        tmp=this.Poz.add(new Position(-1,0));
                        break;
                }
                break;
            case Backward:
                switch (Dir){
                    case North:
                        tmp=this.Poz.add(new Position(0,-1));
                        break;
                    case South:
                        tmp=this.Poz.add(new Position(0,1));
                        break;
                    case East:
                        tmp=this.Poz.add(new Position(-1,0));
                        break;
                    case West:
                        tmp=this.Poz.add(new Position(1,0));
                        break;
                }
                break;
        }
        if(tmp.x>=0 && tmp.y>=0 && tmp.x<=4 && tmp.y<=4){
            this.Poz=tmp;
        }
    }
}
