package Data;

import Data.ConsoleInput.History;
import org.json.JSONArray;
import org.json.JSONObject;

public class AirlyJSON {
    final private JSONObject currentMeasurements;
    final private JSONArray history;
    final private boolean h;
    public AirlyJSON(JSONObject currentMeasurements, JSONArray history, History h){
        this.currentMeasurements=currentMeasurements;
        this.history=history;
        this.h = h.isHistory();
    }

    public JSONObject getCurrentMeasurements() {
        return currentMeasurements;
    }

    public JSONArray getHistory() {
        return history;
    }

    public boolean isHistory(){
        return h;
    }


}
