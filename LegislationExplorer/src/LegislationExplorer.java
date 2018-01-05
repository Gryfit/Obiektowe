
public class LegislationExplorer {

    public static void main (String[] args){
        /*
            wymagana jest pełna ścieżka: dział rozdział artykuł punkt itp. nawet wtedy kiedy nie ma oficjalnie rozdziału
            przykładowy input:
            path 1 #dział #litDziału #rozdział #artykuł #literaArtykułu #punkt #podpunkt #litera
            z powodu braku przykładowego inputu w specyfikacji projketu przyjąłem powyższy.
            lub w przypadku zakresu artykułów
            path 0 1-13

        */
        try{

            Parser parser = new Parser();
            parser.parse(args);
            LegislationNode legislationRoot =
                    new LegislationTreeFactory(parser).makeLegislationTree();
            Printer printer = new Printer(parser);
            printer.print(legislationRoot);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
