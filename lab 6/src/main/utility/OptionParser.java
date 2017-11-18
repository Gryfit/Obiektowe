package main.utility;

/**
 * Created by student40 on 2017-10-20.
 */
public class OptionParser {
    public MoveDirection[] parse (String[] args) throws IllegalArgumentException{
        MoveDirection [] out = new MoveDirection [args.length];
        boolean Illegalargument = true;
        int i=0;
        for(String s : args){
            Illegalargument = true;
            if (s.equals("f")){
                out[i++]=MoveDirection.Forward;
                Illegalargument=false;
            }
            if(s.equals("b")){
                out[i++]=MoveDirection.Backward;
                Illegalargument=false;
            }
            if (s.equals("r")){
                out[i++]=MoveDirection.Right;
                Illegalargument=false;
            }
            if(s.equals("l")){
                out[i++]=MoveDirection.Left;
                Illegalargument=false;
            }
            if(Illegalargument){
                throw new IllegalArgumentException(s + " argument is invalid");
            }
        }
        return out;
    }
}
