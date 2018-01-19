package Data.Measurments;

import Data.Measurments.Units.HumidityUnit;

public class Humidity implements Measurement {
    private final Double value;
    private final Integer space;
    public Humidity(Double value,int space) {
        this.space=space;
        this.value=value;
    }

    @Override
    public String getValue() {
        return ""+ value.intValue() + HumidityUnit.PERCENT.toString();
    }

    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|   humidity          " + value.intValue() + HumidityUnit.PERCENT.toString());
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }
}
