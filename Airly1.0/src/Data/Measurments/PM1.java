package Data.Measurments;

import Data.Measurments.Units.PMUnit;

public class PM1 implements Measurement {
    private final Double value;
    private final Integer space;
    public PM1(Double value,int space){
        this.space=space;
        this.value=value;
    }

    @Override
    public String getValue() {
        return value.intValue() + PMUnit.UGM3.toString();
    }

    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|   pm1               " + value.intValue() + PMUnit.UGM3.toString());
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }
}
