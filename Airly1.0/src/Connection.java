import Data.ConsoleInput.ApiKey;
import Data.ConsoleInput.History;
import Data.ConsoleInput.Location;
import org.json.JSONObject;
import Data.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;


public class Connection {
    private ApiKey apiKey;
    private History history;
    private Location location;
    private final String URLBase = "https://airapi.airly.eu/v1/";

    Connection(ApiKey apiKey, History history, Location location){
        this.apiKey=apiKey;
        this.history=history;
        this.location=location;
    }

    public JSONObject Request() throws Exception{
        URL url = new URL(makeURL());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestProperty("apikey",apiKey.toString());
        if(connection.getResponseCode()!=200){
            throw new Exception(connection.getResponseMessage());
        };

        return makeJSON(connection);

    }
    private String makeURL(){
            StringBuilder url = new StringBuilder(URLBase);
            url.append(location.toString());
            url.append(history.toString());
        return url.toString();
    }

    private JSONObject makeJSON (HttpsURLConnection connection)throws IOException{
        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String jsonText = input.lines().collect(Collectors.joining());
        input.close();
        return new JSONObject(jsonText);
    }

}
