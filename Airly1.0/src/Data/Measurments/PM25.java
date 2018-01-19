package Data.Measurments;

import Data.Measurments.Units.PMUnit;

import java.io.Serializable;

public class PM25 implements Measurement {
    private final Double value;
    private final Integer space;
    public PM25(Double value,int space){
        this.space=space;
        this.value=value;
    }

    public String getValue() {
        return value.intValue() + PMUnit.UGM3.toString();
    }
    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|   pm2.5             " + value.intValue() + PMUnit.UGM3.toString());
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }
}
