import Data.AirlyJSON;
import Data.ConsoleInput.History;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataParser {
    private JSONObject jsonObject;

    private JSONObject currentMeasurements;
    private JSONArray history;

    DataParser(JSONObject json){
        jsonObject=json;
    }


    AirlyJSON Parse(History h){
        currentMeasurements = jsonObject.getJSONObject("currentMeasurements");
        history = jsonObject.getJSONArray("history");
        return  new AirlyJSON(currentMeasurements,history,h);
    }

}

