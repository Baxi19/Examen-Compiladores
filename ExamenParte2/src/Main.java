import context_analisys.ContextAnalisys;
import errors.AlphaErrorListener;
import generated.AlphaScanner;
import generated.AlphaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import vm.Program;

import javax.swing.*;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        AlphaScanner scanner;
        AlphaParser parser;
        CharStream input;
        CommonTokenStream tokens;
        ParseTree tree;
        try {
            input = CharStreams.fromFileName("test.txt");
            scanner = new AlphaScanner(input);
            tokens = new CommonTokenStream(scanner);
            parser = new AlphaParser(tokens);
            AlphaErrorListener errorListener = new AlphaErrorListener();
            scanner.removeErrorListeners();
            parser.removeErrorListeners();
            scanner.addErrorListener(errorListener);
            parser.addErrorListener(errorListener);
            tree = parser.program();
            ContextAnalisys checkerVisistor = new ContextAnalisys();
            checkerVisistor.visit(tree);
            if (errorListener.hasErrors() | checkerVisistor.hasErrors()) {
                System.out.println("Compilation: Failed");
                System.out.println(errorListener.toString());
                checkerVisistor.printErrors();
            } else {
                java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
                treeGUI.get().setVisible(true);
                checkerVisistor.printErrors();
                System.out.println("Compilation: Successful");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        /*
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.visit(tree);

            System.out.println("Compilación Terminada");
            String path =  System.getProperty("user.dir") + "\\src\\vm\\machine_code.txt";

            FileWriter myWriter = new FileWriter(path);
            myWriter.write(codeGenerator.toString());
            myWriter.close();
            Program program = new Program(path);
  */
    }
}
