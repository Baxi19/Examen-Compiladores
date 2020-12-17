package com.company;

import generated.XMLParser;
import generated.XMLScanner;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        XMLParser parser = null;
        XMLScanner scanner = null;
        CharStream input = null;
        CommonTokenStream tokens = null;
        ParseTree tree;

        try {
            input = CharStreams.fromFileName("test.txt");
            scanner = new generated.XMLScanner(input);
            tokens = new CommonTokenStream(scanner);
            parser = new XMLParser(tokens);


            tree = parser.program();
            java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
            treeGUI.get().setVisible(true);
        }catch (Exception e){

        }


    }
}
