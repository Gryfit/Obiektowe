package Data.Measurments;

import Data.Measurments.Units.PMUnit;

public class PM10 implements Measurement {
    private final Double value;
    private final Integer space;
    public PM10(Double value,int space){
        this.space=space;
        this.value=value;
    }

    @Override
    public String getValue() {
        return ""+ value.intValue() + PMUnit.UGM3.toString();
    }

    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|   pm10              " + value.intValue() + PMUnit.UGM3.toString());
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }
}
