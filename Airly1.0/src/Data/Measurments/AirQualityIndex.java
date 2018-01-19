package Data.Measurments;

public class AirQualityIndex implements Measurement {
    private final Double value;
    private final Integer space;
    public AirQualityIndex(Double value,int space){
        this.value=value;
        this.space=space;
    }
    @Override
    public String toString() {
        StringBuilder msg2 = new StringBuilder("|   air quality index " + value.intValue());
        while(msg2.length()<space){
            msg2.append(" ");
        }
        msg2.append("|\n");
        return msg2.toString();
    }

    public String getValue() {
        return ""+value.intValue();
    }
}
