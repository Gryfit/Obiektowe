package Data;

import javafx.css.Match;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
    private String timeFrom;
    private String timeTill;
    private final String Regex = "T..:";
    public Time(JSONObject object){
        this.timeFrom=object.optString("fromDateTime");
        this.timeTill=object.optString("tillDateTime");
    }

    @Override
    public String toString() {
        Pattern patternF = Pattern.compile(Regex);
        Matcher matcherF = patternF.matcher(timeFrom);
        String End="";
        String Begining ="";
        if(matcherF.find()){
            Begining = timeFrom.substring(matcherF.start()+1,matcherF.end()-1);
        }
//       Pattern patternT = Pattern.compile(Regex);
//        Matcher matcherT = patternT.matcher(timeTill);
//        if(matcherT.find()){
//            End = timeTill.substring(matcherT.start()+1,matcherT.end()-1);
//        }
//
        return Begining+" - "+ (Integer.parseInt(Begining)+1);
    }
}
