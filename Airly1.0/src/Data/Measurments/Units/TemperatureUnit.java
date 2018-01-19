package Data.Measurments.Units;

public enum TemperatureUnit {
    //Celsius
    CELSIUS("C"),
    //Farenheit
    FARENHEIT("F");
    private final String current;
    TemperatureUnit(String unit) {
        current=unit;
    }

    @Override
    public String toString() {
        return current;
    }
}
