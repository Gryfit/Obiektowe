package main;

/**
 * Created by student40 on 2017-10-20.
 */
public class OptionParser {
    MoveDirection[] parse (String[] arg){
           int size=0;
        for(String s : arg){
            if (s == "f" || s=="forward" || s=="b" || s=="backward"){
                size++;
            }
        }
        MoveDirection [] out = new MoveDirection [size];
        int i=0;
        for(String s : arg){
            if (s == "f" || s=="forward"){
                out[i++]=MoveDirection.Forward;
            }
            if(s=="b" || s=="backward"){
                out[i++]=MoveDirection.Backward;
            }
        }
        return out;
    }
}
