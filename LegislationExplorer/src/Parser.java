
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Parser {
    private int mode;
    private int[] what = new int[10];
    private String text;
    private int type;

    public void parse(String[] args) throws Exception {
        for(int i=0;i<10;i++)
            what[i]=(-1);
        if(args.length<2)
            throw new Exception("Too few arguments!");
        if(!args[0].endsWith("uokik.txt") && !args[0].endsWith("konstytucja.txt"))
            throw new Exception("Błędna nazwa pliku!");

        type = args[0].endsWith("uokik.txt")?1:0;

        text = read(args[0]);

        mode = Integer.parseInt(args[1]);

        if((mode==1 && args.length>3) || (mode==0 && args.length>9)){
            throw new IllegalArgumentException("Inappropriate number of arguments!");

        }
        if(args.length>2)
            elements(args);
    }


    private String read(String path) throws FileNotFoundException{
        Stream<String> stringStream = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(path)), StandardCharsets.UTF_8)).lines();
        String strings = stringStream
                .filter(s -> !s.contains("©Kancelaria Sejmu") && !s.equals("2009-11-16")  && !s.equals("2017-06-28") && s.length()!=1)
                .reduce("",(s,acc)-> {
                    if(s.endsWith("-")){
                        String output = s.substring(0,s.length()-1)
                                + acc.substring(0,
                                acc.indexOf(' ')==(-1)?acc.length():acc.indexOf(' '));
                        if(acc.indexOf(' ')==(-1)){
                            return output;
                        }else{
                            return output+System.getProperty("line.separator")
                                    + acc.substring(acc.indexOf(' ')+1,acc.length());
                        }
                    }
                    return s + System.getProperty("line.separator") + acc;
                });
        return strings;
    }

    private void elements(String[] s){
        Pattern p = Pattern.compile("\\d+-\\d+");
        Matcher m = p.matcher(s[2]);
        if(m.find()){//range
            what[9]=1;
            Pattern p2 = Pattern.compile("\\d+");
            Matcher m2 = p2.matcher(s[2]);
            int i=0;
            while(m2.find()){
                what[i++]=Integer.parseInt(s[2].substring(m2.start(),m2.end()));
            }
            return;
        }
        what[9]=0;
        //single
        int i=0;
        while(i+2<s.length){
            if(s[i+2].equals("_")){
                what[i]=1;
            }else{
                if(i == 3 || i == 6){
                    what[i]= (int)s[i+2].charAt(0);
                    what[i]-=96;

                }else{
                    what[i]=Integer.parseInt(s[i+2]);
                }
            }
            i++;
        }

    }

    public String getText() { return text; }
    public int textType() {
        return type;
    }

    public int getMode() {
        return mode;
    }

    public int[] getWhat() {
        return what;
    }
}
