package Data.Measurments;

import Data.Time;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class HistoricalMeasurments {
    Measurements[] historicalMeasurments = new Measurements[24];
    Measurements currentMeasurments;
    JSONArray historicalDataJSON;
    public HistoricalMeasurments(JSONObject currentMeasurments, JSONArray historicalDataJson) throws Exception {
        for (int hour = 0; hour < 24; hour++) {
            historicalMeasurments[hour] = new Measurements(34, historicalDataJson.getJSONObject(hour).getJSONObject("measurements"));
        }
        this.historicalDataJSON=historicalDataJson;
        this.currentMeasurments = new Measurements(124, currentMeasurments);
    }

    @Override
    public String toString() {
        StringBuilder screen = new StringBuilder("");
        screen.append(currentMeasurments.toString());
        screen.append(
                "+-----------+---------------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+\n"
               +"|   time    |    quality    |    AQI    |    pm1    |   pm2.5   |    pm10   |   level   | pressure  |temperature| humidity  |\n"
               +"+-----------+---------------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+\n");
        for(int m =0;m<24;m++){
            Time time = new Time(historicalDataJSON.getJSONObject(m));
            screen.append("| "+time.toString());
            int tmp = time.toString().length();
            while(tmp!=10) {
                screen.append(" ");
                tmp++;
            }
            for(int id=0; id<historicalMeasurments[m].getIdentifiersNum();id++){
                screen.append("| ");
                screen.append(historicalMeasurments[m].getVal(id));
                tmp = historicalMeasurments[m].getVal(id).length();
                while(tmp!=(id==0?14:10)) {
                    screen.append(" ");
                    tmp++;
                }
            }
            screen.append("|\n");
        }
        screen.append("+-----------+---------------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+\n");
        return screen.toString();
    }

    private String getTime(int space, JSONObject object) {
        String fromtime = object.optString("fromDateTime");
        fromtime = fromtime.substring(fromtime.indexOf('T') + 1, fromtime.indexOf('Z'));

        String tilltime = object.optString("tillDateTime");
        tilltime = tilltime.substring(tilltime.indexOf('T') + 1, tilltime.indexOf('Z'));

        StringBuilder val = new StringBuilder("|   From " + fromtime + "  To " + tilltime);

        while (val.length() < space) {
            val.append(" ");
        }
        val.append("|\n");
        return val.toString();
    }
}

