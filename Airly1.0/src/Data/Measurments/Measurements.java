package Data.Measurments;

import org.json.JSONObject;

import java.util.LinkedList;

public class Measurements{
    final int space; //package private
    final String[] identifiers = {
            "airQualityIndex", //message
            "airQualityIndex",
            "pm1",
            "pm25",
            "pm10",
            "pollutionLevel",
            "pressure",
            "temperature",
            "humidity",
    };
    LinkedList<Measurement> fields;
    public Measurements(int space, JSONObject measurements) throws Exception{
        //space=34
        this.space=space;
        fields=new LinkedList<>();
        double value0 = Math.round(measurements.optDouble(identifiers[0]));
        fields.add(new QualityMessage(value0,space));
        double value1 = Math.round(measurements.optDouble(identifiers[1]));
        fields.add(new AirQualityIndex(value1,space));
        double value2 = Math.round(measurements.optDouble(identifiers[2]));
        fields.add(new PM1(value2,space));
        double value3 = Math.round(measurements.optDouble(identifiers[3]));
        fields.add(new PM25(value3,space));
        double value4 = Math.round(measurements.optDouble(identifiers[4]));
        fields.add(new PM10(value4,space));
        double value5 = Math.round(measurements.optDouble(identifiers[5]));
        fields.add(new PollutionLevel(value5,space));
        double value6 = Math.round(measurements.optDouble(identifiers[6]));
        fields.add(new Pressure(value6,space));
        double value7 = Math.round(measurements.optDouble(identifiers[7]));
        fields.add(new Temperature(value7,space));
        double value8 = Math.round(measurements.optDouble(identifiers[8]));
        fields.add(new Humidity(value8,space));

    }
    public String getVal (int identifier){
        return fields.get(identifier).getValue();
    }
    public int getIdentifiersNum(){ return identifiers.length;}

    @Override
    public String toString() {
        //getSimpleTable(34,object)

        StringBuilder stringBuilder = new StringBuilder("+");
        for(int i=0; i<space-1;i++){
            stringBuilder.append("-");
        }
        stringBuilder.append("+\n");
        for (Measurement field: fields) {
            stringBuilder.append(field.toString());
        }
        stringBuilder.append("+");
        for(int i=0; i<space-1;i++){
            stringBuilder.append("-");
        }
        stringBuilder.append("+\n");
    return stringBuilder.toString();
    }
}
