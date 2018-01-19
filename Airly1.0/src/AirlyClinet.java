import Data.AirlyJSON;
import Data.ConsoleInput.ApiKey;
import Data.CurrentMeasurments;

public class AirlyClinet {
    public static void main (String[] args){
        //sensor-id=842
        //--latitude=50 --longitude=19.9

        try{
            //Parse commandline arguments
            Parser parser = new Parser(args);

            parser.Parse();
            Connection connection = new Connection(parser.getApiKey(), parser.getHistory(), parser.getLocation());


            DataParser dataParser = new DataParser(connection.Request());
            AirlyJSON airlyJSON = dataParser.Parse(parser.getHistory());
            Printer printer = new Printer(airlyJSON);
            printer.Print();
        }catch (Exception e){
            System.out.println(e.getMessage());
            printHelp();
        }
    }
    private static void printHelp(){
        System.out.println(
                "AirlyClient - The Airly console client\n"
                        +"\nUsage: AirlyClient [--latitude --longitude] [--sensor-id] [--api-key] [--history]\n"
                        +"\nAvailable Options:\n"
                        +"--help                "+"Print this help\n"
                        +"--latitude            "+"Set latitude for the place you want to check\n"
                        +"--longitude           "+"Set longitude for the place you want to check\n"
                        +"--sensor-id           "+"Set ID of the sensor you want to see data form\n"
                        +"--api-key             "+"Set Api Key if it's not set in environmental variable\n"
                        +"--history             "+"View historical data from last 24 hours\n"
        );
    }
}
