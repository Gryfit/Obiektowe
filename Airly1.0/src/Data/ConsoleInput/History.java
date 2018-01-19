package Data.ConsoleInput;

import java.util.HashMap;

public class History {
    private boolean history=false;
    public History(boolean history){
        this.history=history;
    }
    public boolean isHistory() {
        return history;
    }

    @Override
    public String toString() {
        return isHistory()?"&historyHours=24":"";
    }
}
