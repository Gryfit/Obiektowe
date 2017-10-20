package main;

/**
 * Created by gryfit on 08/10/2017.
 */
public class CarSystem {

    public static void main(String[] args) {
        Car c = new Car ();
        System.out.println(c.toString());
        OptionParser parser = new OptionParser();
        String [] commands = new String[5];
        commands[0]="f";
        commands[1]="f";
        commands[2]="LOL";
        commands[3]="b";
        commands[4]="b";

        for(MoveDirection  md : parser.parse(commands)){
            c.move(md);
        }

        System.out.println(c.toString());
    }
}

