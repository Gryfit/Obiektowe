import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Data.*;
import Data.ConsoleInput.ApiKey;
import Data.ConsoleInput.History;
import Data.ConsoleInput.Location;

public class Parser {
    private String[] args;
    private ApiKey apiKey = new ApiKey("");
    private Location location = new Location("");
    private History history =  new History(false);

    private Pattern Regex[]= new Pattern[]{
            Pattern.compile("^--latitude="),
            Pattern.compile("^--longitude="),
            Pattern.compile("^--sensor-id="),
            Pattern.compile("^--api-key="),
            Pattern.compile("^--history"),
            Pattern.compile("^--help")
    };

    Parser(String[] args){
        this.args=args;
    }

    //--latitude=50.06 --longitude=19.93 [--api-key=11111111111asdsd2212] [--history]
    void Parse()throws Exception{
        if(args.length <1 || args.length>4){
            throw new Exception("Wrong number of arguments\n");
        }
        int i=0;
        boolean flag = false;
        String latitude="";
        String longitude="";
        while (i<args.length){
            for(int j=0; j<6;j++){
                Matcher matcher = Regex[j].matcher(args[i]);
                if(matcher.find()){
                    switch(j){
                        case 0:
                            latitude=args[i].substring(matcher.end(),args[i].length());
                            flag=true;
                            break;
                        case 1:
                            longitude=args[i].substring(matcher.end(),args[i].length());
                            flag=true;
                            break;
                        case 2:
                            location =  new Location(args[i].substring(matcher.end(),args[i].length()));
                            flag=false;
                            break;
                        case 3:
                            apiKey= new ApiKey(args[i].substring(matcher.end(),args[i].length()));
                            break;
                        case 4:
                            history = new History(true);
                            break;
                        case 5:
                            throw new Exception("");
                    }
                }
            }
            i++;
        }
        if(flag)
            location = new Location(latitude,longitude);
        if(location.isEmpty())
            throw new Exception("Wrong Localisation and / or SensorID \n");
        if(apiKey.isEmpty()){
            Map<String,String> environmentalVariables = System.getenv();
            if(environmentalVariables.get("API_KEY")==null){
                throw new Exception("Api key not found\n");
            }
            apiKey = new ApiKey(environmentalVariables.get("API_KEY"));
        }
    }

    public ApiKey getApiKey() {
        return apiKey;
    }

    public History getHistory() {
        return history;
    }

    public Location getLocation() {
        return location;
    }
}
