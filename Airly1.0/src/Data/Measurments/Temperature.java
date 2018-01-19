package Data.Measurments;

import Data.Measurments.Units.TemperatureUnit;

import java.io.Serializable;

public class Temperature implements Measurement {
    private final Double value;
    private final Integer space;
    public Temperature(Double value,int space){
        this.space=space;
        this.value=value;
    }

    @Override
    public String getValue() {
        return Math.round(value) + TemperatureUnit.CELSIUS.toString();
    }

    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|   temperature       " + Math.round(value) + TemperatureUnit.CELSIUS.toString());
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }
}
