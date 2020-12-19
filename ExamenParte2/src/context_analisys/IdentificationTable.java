package context_analisys;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class IdentificationTable {
    LinkedList<Ident> tablaVariables;
    LinkedList<MethodIdent> tablaMetodos;

    public int nivelActual;

    public class Ident{
        Token tok;
        int type;
        int nivel;
        int valor;
        boolean isConstant;

        public Ident(Token t, int tp, boolean isConstant){
            tok = t;
            type = tp;
            nivel=nivelActual;
            valor = 0;
            this.isConstant = isConstant;
        }

        public void setValue(int v){
            valor = v;
        }
    }

    public class MethodIdent{
        public Token token; // Identificador a insertado
        public int type; // Tipo de dato (string char, int, float, bool, clase)
        public int value;
        public String methodName;
        public int nivel;
        public ArrayList<Pair<Integer,String>> parameters;

        public MethodIdent(Token token, String methodName, int type, ArrayList<Pair<Integer, String>> parameters)
        {
            this.token = token;
            this.type = type;
            this.methodName = methodName;
            this.parameters = parameters;
            this.nivel = nivelActual;
            value = 0;
        }
    }

    public IdentificationTable() {
        tablaVariables = new LinkedList<Ident>();
        tablaMetodos = new LinkedList<MethodIdent>();
        this.nivelActual=-1;
    }

    public Ident insertVarIdent(Token id, int tipo, boolean isConstant) {
        Ident i = new Ident(id, tipo, isConstant);
        tablaVariables.add(i);
        return i;
    }

    public Ident searchIdent(String nombre){
        Ident temp = null;
        for(int i = (tablaVariables.size()); i > 0; i--){
            Ident id = tablaVariables.get(i-1);
            if (id.tok.getText().equals(nombre) && id.nivel <= nivelActual) {
                temp = id;
            }
        }
        return temp;
    }


    public void openScope(){
        nivelActual++;
    }

    public void closeScope(){
        tablaVariables.removeIf(id -> id.nivel == nivelActual);
        tablaMetodos.removeIf(methodIdent -> methodIdent.nivel == nivelActual);
        nivelActual--;
    }

    public void insertMethodIdent(Token token, String methodName, int type, ArrayList<Pair<Integer,String>> parameters){
        MethodIdent methodIdent = new MethodIdent(token, methodName, type, parameters);
        tablaMetodos.add(methodIdent);

    }

    public MethodIdent searchMethodIdent(String methodIdent){
        for (MethodIdent method : tablaMetodos) {
            if (method.methodName.equals(methodIdent) && method.nivel <= nivelActual) {
                return method;
            }
        }
        return null;
    }

    public void imprimir() {
        System.out.println("----- INICIO TABLA ------");
        for (int i = 0; i < tablaVariables.size(); i++) {
            Ident s = tablaVariables.get(i);
            System.out.println("Nombre: " + s.tok.getText() + " - " + s.nivel + " - " +  s.type);
        }
        System.out.println("----- FIN TABLA ------");
    }
}
