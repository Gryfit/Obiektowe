public class Printer {
    private Parser parser;

    public Printer(Parser parser){
        this.parser=parser;
    }

    //0->elements
    //1->table of contents
    void print(LegislationNode legislationRoot) throws Exception {
        if(parser.getMode()==0){
            System.out.print(elements(legislationRoot));
        }else{
            System.out.print(tableOfContents(legislationRoot));
        }
    }


    private String elements(LegislationNode root)throws Exception{
        if(parser.getWhat()[9]==0){
            //single
            try{
                if(parser.textType()==1) {
                    LegislationNode ln = pathBuilderUOKIK(parser.getWhat(), 0, root);
                    return ln.toString();
                }else{
                    LegislationNode ln = pathBuilderKonstytucja(parser.getWhat(),0,root);
                    return  ln.toString();
                }
            }catch(IndexOutOfBoundsException e){
                throw new Exception("Element not found!");
            }
        }else{
            //zakres
            //1->UOKIK
            //0->Konstytucja
            if(parser.textType()==0){
                return rangeKonstytucja(root);
            }else{
                return rangeUOKIK(root);
            }
        }
    }

    private String rangeKonstytucja(LegislationNode root)throws Exception{
        int max = root
                .getChild(
                        root.getChildren().size()-1)
                .getMax();
        if(!((parser.getWhat()[0]>0 && parser.getWhat()[0]<=max) &&
                (parser.getWhat()[1]>0 && parser.getWhat()[1]<=max)))
            throw new Exception("Articles out of bounds!");

        int count =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<root.getChildren().size();i++){
            for(int j=0; j<root.getChild(i).getChildren().size();j++){
                count++;
                if(count>=parser.getWhat()[0] && count<=parser.getWhat()[1]) {
                    sb.append(root.getChild(i).getChild(j).toString());
                }
                if(count>parser.getWhat()[1])
                    return sb.toString();
            }
        }
        return "";
    }

    private String rangeUOKIK(LegislationNode root)throws Exception{
        int max = root
                .getChild(
                        root.getChildren().size()-1)
                .getChild(
                        root.getChild(
                                root.getChildren().size()-1)
                                .getChildren().size()-1)
                .getMax();
        if(!((parser.getWhat()[0]>0 && parser.getWhat()[0]<=max) &&
                (parser.getWhat()[1]>0 && parser.getWhat()[1]<=max)))
            throw new Exception("Articles out of bounds!");


        StringBuilder sb = new StringBuilder();


        for(int i=0; i<root.getChildren().size();i++){
            for(int j=0; j<root.getChild(i).getChildren().size();j++){
                for(int k=0; k<root.getChild(i).getChild(j).getChildren().size();k++)
                if(root.getChild(i).getChild(j).getChild(k).getNum()<=parser.getWhat()[1]
                        && root.getChild(i).getChild(j).getChild(k).getNum()>=parser.getWhat()[0])
                    sb.append(root.getChild(i).getChild(j).getChild(k).toString());
            }
        }
        return sb.toString();
    }

    private String tableOfContents(LegislationNode root){
        if(parser.textType()==0){
            StringBuilder sb = new StringBuilder("Konstytucja Rzeczypospolitej Polskiej"+"\n"+"Spis Treści:"+"\n");
            for(LegislationNode ln : root.getChildren()){
                sb.append(ln.getData());
            }
            return sb.toString();
        }else{
            if(parser.getWhat()[0]==(-1)) {
                StringBuilder sb = new StringBuilder("Ustawa o ochronie konkurencji i konsumentów" + "\n" + "Spis Treści:" + "\n");
                for (LegislationNode ln : root.getChildren()) {
                    sb.append(ln.getData());
                    String SB2="";

                        for (LegislationNode ln2 : ln.getChildren()) {
                            SB2+=ln2.getData();
                            if(SB2.equals("")){
                                for (LegislationNode ln3 : ln2.getChildren()) {
                                    SB2+=(ln3.getData());
                                }
                            }
                            sb.append(SB2);
                            SB2="";
                        }
                }
                return sb.toString();
            }else{
                StringBuilder sb = new StringBuilder("Ustawa o ochronie konkurencji i konsumentów" + "\n"
                        + "Spis Treści Działu: " + (parser.getWhat()[0]+(parser.getWhat()[0]>3?0:1)) +"\n");
                for (LegislationNode ln2 : root.getChild(parser.getWhat()[0]).getChildren()) {
                    sb.append(ln2.getData());
                }
                return sb.toString();
            }

        }

    }


    private LegislationNode pathBuilderUOKIK(int[] what, int step, LegislationNode node)throws IndexOutOfBoundsException{
        if(step<10 && what[step]!=(-1)){
            if(step == 2){
                LegislationNode n = new LegislationNode();
                for(int i=0; i<node.getChildren().size();i++){
                    if (node.getChild(i).getNum() == what[step]){
                        n = node.getChild(i);
                    }
                }
                return pathBuilderUOKIK(what,step+1,n);
            }else{
                return pathBuilderUOKIK(what,step+1,node.getChild(what[step]-1));
            }
        }
        return node;
    }
    private  LegislationNode pathBuilderKonstytucja(int[] what, int step, LegislationNode node) throws IndexOutOfBoundsException{
        if(step<3 && what[step]!=(-1))
            return pathBuilderKonstytucja(what,step+1,node.getChild(what[step]-1));
        return node;
    }

}