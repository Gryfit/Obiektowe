package main;

/**
 * Created by gryfit on 08/10/2017.
 */
public class CarSystem {


    public static void main(String[] args) {
        Car c = new Car ();
        OptionParser parser = new OptionParser();
        for(MoveDirection  md : parser.parse(args)){
            c.move(md);
        }
        System.out.println(c.toString());
    }
}

