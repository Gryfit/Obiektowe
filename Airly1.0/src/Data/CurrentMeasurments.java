package Data;

import Data.Measurments.Measurements;
import org.json.JSONObject;

public class CurrentMeasurments {
    Measurements measurements;
    public CurrentMeasurments(JSONObject jsonObject) throws Exception{
        measurements =  new Measurements(34,jsonObject);
    }
    @Override
    public String toString() {
        return measurements.toString();
    }
}
