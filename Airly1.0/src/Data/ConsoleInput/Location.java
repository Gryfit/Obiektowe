package Data.ConsoleInput;

public class Location {
    private String latitude;
    private String longitude;
    private String sensorID ="";

    public Location(String latitude, String longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }
    public Location(String sensorID){
        this.sensorID=sensorID;
    }
    public boolean isEmpty(){
        return sensorID.isEmpty() && (latitude.isEmpty() || longitude.isEmpty());
    }
    @Override
    public String toString() {
        return (!sensorID.isEmpty()?"sensor/measurements?sensorId=" + sensorID : "mapPoint/measurements?latitude="+latitude+"&"+"longitude="+longitude);
    }
}
