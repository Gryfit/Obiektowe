package Data.Measurments.Units;

public enum PressureUnit {
    //Hectopascal
    HPA("hPa"),
    //Millibar
    MBAR("mbar");
    private final String current;
    PressureUnit(String unit) {
        current=unit;
    }

    @Override
    public String toString() {
        return current;
    }
}
