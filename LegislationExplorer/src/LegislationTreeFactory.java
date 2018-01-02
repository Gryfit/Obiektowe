
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gryfit on 10/12/2017.
 */

public class LegislationTreeFactory {
    private Parser parser;

    public LegislationTreeFactory(Parser parser){
        this.parser=parser;
    }

    public LegislationNode makeLegislationTree() {
        LegislationNode root = new LegislationNode(parser.getText());
        rek(root,0,parser.textType());
        return root;
    }

    private class wrapper{
        public int start=0;
        public int end=0;
    }
    private String[] regexTableUOKIK = new String[]{
            "^DZIAŁ \\w+\\R",
            "^Rozdział \\d+\\R",
            "^Art\\. \\d+(\\D)?\\. |^Art\\. \\d+.\\d+\\.",
            "^(Art. \\d+\\. )?\\d+\\. ",
            "^\\d+\\) ",
            "^\\D\\) "
    };
    private String[] regexTableKonstytucja = new String[]{
            "^Rozdział [IXVD]+\\R",
            "^Art. \\d+.\\R",
            "^\\d. ",
    };
    private int articles =1;
    //0->konstytucja
    //1->uokik
    private void rek(LegislationNode root, int index, int v){
        if(index >= (v==1?6:3)){return;}
        String s = root.getData();
        Pattern p = Pattern.compile(
                (v==1?regexTableUOKIK[index]:regexTableKonstytucja[index]),
                Pattern.MULTILINE);
        Matcher m = p.matcher(s);
        LinkedList<wrapper> wrappers = new LinkedList<>();

        while(m.find()){
            wrapper w = new wrapper();
            w.start=m.start();
            w.end=m.end();
            wrappers.add(w);
        }

        if(wrappers.isEmpty()){
            if((index ==1 || index ==3) && v==1){ //punkty i rozdziały nie muszą istnieć
                root.setData("");
                root.addChild(new LegislationNode(s));
                root.setRange(1,1);
            }else{
                return;
            }
        }else {
            root.setData(s.substring(0, wrappers.get(0).start));

            if(index== (v==1?2:1)){
                root.setRange(articles, articles+wrappers.size());
                articles+=(wrappers.size());
            }else{
                root.setRange(1,wrappers.size()-1);
            }

            for (int i = 1; i < wrappers.size(); i++) {
                root.addChild(new LegislationNode(
                        s.substring(
                                wrappers.get(i - 1).start,
                                wrappers.get(i).start
                        )));
            }
            root.addChild(new LegislationNode(
                    s.substring(
                            wrappers.get(wrappers.size()-1).start,
                            s.length()
                    )));
        }
        for (int i = 0; i < root.getChildren().size(); i++) {
            rek(root.getChild(i), index + 1,v);
        }
    }

}