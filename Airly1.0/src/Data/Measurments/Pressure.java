package Data.Measurments;

import Data.Measurments.Units.PressureUnit;

import java.io.Serializable;

public class Pressure implements Measurement {
    private final Double value;
    private final Integer space;
    public Pressure(Double value,int space){
        this.space=space;
        this.value=value;
    }

    @Override
    public String getValue() {
        return ""+ value.intValue()/100 + PressureUnit.HPA.toString();
    }

    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|   pressure          " + value.intValue()/100 + PressureUnit.HPA.toString());
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }
}
