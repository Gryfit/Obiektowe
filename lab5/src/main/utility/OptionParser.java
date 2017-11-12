package main.utility;

/**
 * Created by student40 on 2017-10-20.
 */
public class OptionParser {
    public MoveDirection[] parse (String[] args){
        MoveDirection [] out = new MoveDirection [args.length];
        int i=0;
        for(String s : args){
            if (s.equals("f")){
                out[i++]=MoveDirection.Forward;
            }
            if(s.equals("b")){
                out[i++]=MoveDirection.Backward;
            }
            if (s.equals("r")){
                out[i++]=MoveDirection.Right;
            }
            if(s.equals("l")){
                out[i++]=MoveDirection.Left;
            }
        }
        return out;
    }
}
