import code_generation.CodeGenerator;
import code_generation.CodeInterprete;
import generated.AlphaScanner;
import generated.AlphaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import vm.Program;

import java.io.FileWriter;

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

            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.visit(tree);

            System.out.println("Compilación Terminada");
            String path =  System.getProperty("user.dir") + "\\src\\vm\\machine_code.txt";

            FileWriter myWriter = new FileWriter(path);
            myWriter.write(codeGenerator.toString());
            myWriter.close();

            Program program = new Program(path);
        }
        catch(Exception e){System.out.println("No hay archivo");e.printStackTrace();}
    }
}
