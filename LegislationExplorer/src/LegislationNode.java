import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by gryfit on 10/12/2017.
 */
public class LegislationNode {
    private String data;
    private LinkedList<LegislationNode> children;
    private int min;
    private int max;
    private int num;
    public LegislationNode(){
        children = new LinkedList<>();
        data = "";
        min=0;
        max=0;
    }

    public LegislationNode(String data , int num){
        this();
        this.data = data;
        this.num=num;
    }

    public void setRange(int min, int max){
        this.min=min;
        this.max=max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LegislationNode getChild(int i) {
        return children.get(i);
    }

    public LinkedList<LegislationNode> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public void addChild(LegislationNode tree) {
        children.add(tree);
    }

    @Override
    public String toString(){
        if(this.hasChildren()){
            return data
                    + children.stream()
                                        .map(LegislationNode::toString)
                                        .collect(Collectors.joining());
        }
        return data;
    }

    public int getNum() {
        return num;
    }

}

