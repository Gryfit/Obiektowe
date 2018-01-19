package Data.Measurments;

public class PollutionLevel implements Measurement {
    private final Double value;
    private final Integer space;
    public PollutionLevel(Double value,int space){
        this.space=space;
        this.value=value;
    }

    @Override
    public String getValue() {
        return ""+value.intValue();
    }

    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|   pollution level   " + value.intValue());
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }
}
