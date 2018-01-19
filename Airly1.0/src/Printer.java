import Data.AirlyJSON;
import Data.Measurments.HistoricalMeasurments;
import Data.Measurments.Measurements;

public class Printer {
    AirlyJSON data;

    Printer(AirlyJSON data) {
        this.data = data;
    }
    public void Print() throws Exception{
        String screen;
        if(data.isHistory()){
            HistoricalMeasurments historicalMeasurments = new HistoricalMeasurments(data.getCurrentMeasurements(),data.getHistory());
            screen=historicalMeasurments.toString();
        }else{
            Measurements measurements = new Measurements(34,data.getCurrentMeasurements());
            screen=measurements.toString();
        }
        System.out.println(screen);
    }
}
