package main;

/**
 * Created by gryfit on 08/10/2017.
 */
public enum MoveDirection {
    Forward,
    Backward,
    Right,
    Left;

    @Override
    public String toString (){
        switch (this){
            case Forward: return "F";
            case Backward: return "B";
            case Right: return "R";
            case Left: return "L";
        }
        return "";
    }
}
