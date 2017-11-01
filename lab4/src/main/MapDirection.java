package main;

/**
 * Created by gryfit on 08/10/2017.
 */
public enum MapDirection {
    North,
    South,
    West,
    East;
    @Override
    public String toString(){
        switch (this){
            case North: return "Północ";
            case South: return "Południe";
            case West: return "Zachód";
            case East: return "Wschód";
        }
        return "";
    }
   public MapDirection next(){
       switch (this){
           case North: return East;
           case South: return West;
           case West: return North;
           case East: return South;
       }
       return null;
   }
    public MapDirection previous(){
        switch (this){
            case North: return West;
            case South: return East;
            case West: return South;
            case East: return North;
        }
        return null;
    }

}
