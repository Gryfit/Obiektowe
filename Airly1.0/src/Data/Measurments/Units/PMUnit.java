package Data.Measurments.Units;

public enum PMUnit {
    UGM3("ug/m3");

    private final String current;
    PMUnit(String unit) {
        current=unit;
    }

    @Override
    public String toString() {
        return current;
    }
}
