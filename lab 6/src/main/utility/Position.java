package main.utility;

/**
 * Created by gryfit on 08/10/2017.
 */
public class Position{
    public final int x;
    public final int y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    public String toString (){
        Integer X = this.x;
        Integer Y =this.y;
        return "("+X.toString()+","+Y.toString()+")";
    }
    public boolean smaller (Position Second){
        return (this.x<=Second.x&&this.y<=Second.y);
    }
    public boolean larger (Position Second){
        return (this.x>=Second.x&&this.y>=Second.y);
    }
    public Position add (Position Second){
        return new Position(this.x+Second.x,this.y+Second.y);
    }
    public boolean equals (Object other){
        if(this==other)
            return true;
        if(!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }
}
