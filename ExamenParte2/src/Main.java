import generated.AlphaScanner;
import generated.AlphaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

    public static void main(String[] args) {
        AlphaScanner inst = null;
        CharStream input=null;
        CommonTokenStream tokens = null;
        ParseTree tree=null;

        try {
            input = CharStreams.fromFileName("test.txt");
            inst = new generated.AlphaScanner(input);
            tokens = new CommonTokenStream(inst);
            AlphaParser p = new AlphaParser(tokens);

            tree = p.program();
            System.out.println("Compilación Terminada");

        }
        catch(Exception e){System.out.println("No hay archivo");e.printStackTrace();}
    }
}
