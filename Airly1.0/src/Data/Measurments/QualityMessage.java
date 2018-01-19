package Data.Measurments;

public class QualityMessage implements Measurement{

    private final Double value;
    private final Integer space;
    public QualityMessage(Double value,int space){
        this.value=value;
        this.space=space;
    }
    public String QualityMessage(Double aqi){
        if(aqi<25){
            return "  Very  good ";
        }
        if(aqi<50){
            return "   Good   ";
        }
        if(aqi<75){
            return "  Medium  ";
        }
        if(aqi<100){
            return "   Bad    ";
        }
        return " Very bad ";
    }
    @Override
    public String toString() {
        StringBuilder msg1 = new StringBuilder("|           " + QualityMessage(value));
        while(msg1.length()<space){
            msg1.append(" ");
        }
        msg1.append("|\n");
        return msg1.toString();
    }

    public String getValue() {
        return QualityMessage(value);
    }
}