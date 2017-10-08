package agh.cs.lab1;

import java.util.Arrays;

/**
 * Created by student30 on 2017-10-06.
 */
public class CarSystem {
    public static void run (Direction[] args){
        /*
        for(int i = 0; i<a.length;i++){
            System.out.println(a[i]);
            if(i<a.length-1){
                System.out.println(",");
            }
        }*/
        /*for(String x : a){
            System.out.println(x);
        }*/
        //Arrays.asList(a).stream().forEach(System.out::println);
        //System.out.println(String.join(", ",a));
        for(Direction x : args){
            switch(x){
                case Forward:
                    System.out.println("do przodu");
                    break;
                case Backward:
                    System.out.println("do tyłu");
                    break;
                case Right:
                    System.out.println("w prawo");
                    break;
                case Left:
                    System.out.println("w lewo");
                    break;
            }
        }
    }
    public static Direction[] convertArgs (String[] args) {
        Direction[] result =  new Direction[args.length]; // inicjowana NULL
        for(int i =0; i<args.length;i++){
            switch(args[i]){
                case "f":
                    result[i]=Direction.Forward;
                    break;
                case "b":
                    result[i]=Direction.Backward;
                    break;
                case "r":
                    result[i]=Direction.Right;
                    break;
                case "l":
                    result[i]=Direction.Left;
                    break;
            }
        }
        return result;
    }
    public static void main (String[] args){
        System.out.println("Start");
        run(convertArgs(args));
        System.out.println("Stop");

    }
}
