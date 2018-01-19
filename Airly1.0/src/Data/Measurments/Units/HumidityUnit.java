package Data.Measurments.Units;

public enum HumidityUnit {
    PERCENT("%");

    private final String current;
    HumidityUnit(String unit) {
        current=unit;
    }

    @Override
    public String toString() {
        return current;
    }
}
