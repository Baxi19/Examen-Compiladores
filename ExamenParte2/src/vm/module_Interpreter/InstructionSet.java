package vm.module_Interpreter;

import vm.module_stack.MyStack;
import vm.module_warehouse.Warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class InstructionSet {
    public int level;
    public ArrayList<MyHash> instSet ;

    //se define un almacen global para manejo de variables globales y referencias a métodos
    public Warehouse almacenGlobal;

    //se define un almacén local para variables locales *** PUEDE QUE SE REQUIERA UNO POR CADA CONTEXTO PERO ESO DEBE DEFINIRSE ***
    public ArrayList<Warehouse> almacenLocal;

    public MyStack myStackExprs;
    //public Pila PilaExprs { get { return pilaExprs; } set {} }

    public int actualInstrIndex;
    public ArrayList<Object> actualParamList = new ArrayList<>();
    public String output;

    public InstructionSet() {
        this.output = "";
        this.level = 0;
        this.instSet = new ArrayList<>();
        this.almacenGlobal = new Warehouse("Global");
        almacenGlobal.setValue("write", -1); //por defecto se agrega el método write al almacen global
        this.almacenLocal = new ArrayList<>();
        this.myStackExprs = new MyStack();
        this.actualInstrIndex = 0;
        //this.actualParamList = actualParamList;

    }

    public void addInst(String inst, Object param){
        instSet.add(new MyHash(inst, param));
    }

    private void runPUSH_LOCAL(String name){
        //podría recibir el almacen del contexto en caso de que se requiera
        try
        {
            if (actualParamList.size() != 0){
                almacenLocal.get(almacenLocal.size() - 1).setValue(name, actualParamList.get(0)); //el valor por defecto es el parámetro actual de turno
                actualParamList.remove(0); //se elimina el parámetro actual de turno
            }
            else{
                //declara el elemento "name" en el almacen LOCAL con valor por defecto 0
                almacenLocal.get(almacenLocal.size() - 1).setValue(name, 0);
            }
        }
        catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method PUSH_LOCAL: " + e.getMessage());
        }
    }

    private void runPUSH_GLOBAL(String name){
        try{
            //declara el elemento "name" en el almacen GLOBAL con valor por defecto 0
            almacenGlobal.setValue(name, 0);
        }catch (Exception e){
            System.out.println("( " + actualInstrIndex + " ) " + "instruction in method PUSH_GLOBAL: " + e.getMessage());
        }
    }

    private void runDEF(String name){
        try{
            almacenGlobal.setValue(name,actualInstrIndex); //+1 porque la primer instrucción del método es el siguiente index
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method DEF: " + e.getMessage());
        }
    }

    private void runLOAD_CONST(Object constant){
        try{
            //carga en la pila el valor entero contenido en "constant"
            myStackExprs.push(constant);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method LOAD_CONST: " + e.getMessage());
        }
    }


    private void runLOAD_FAST(String varname){
        try{
            //busca en el almacén LOCAL el valor asociado a "varname" y lo inserta en la pila
            Object val;
            val = almacenLocal.get(almacenLocal.size() - 1).getValue(varname); //EL GET VALUE DEBE DEVOLVER UN VALOR PARA PODERLO CARGAR A LA PILA
            myStackExprs.push(val);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method LOAD_FAST: " + e.getMessage());
        }
    }

    private void runSTORE_FAST(String varname){
        //podría recibir el almacen del contexto en caso de que se requiera
        try{
            //almacena el contenido del tope de la pila en el almacén LOCAL para la variable "varname"
            Object tope = 0;
            tope = myStackExprs.pop(); //debe sacar el elemento de la pila y devolver su valor
            almacenLocal.get(almacenLocal.size() - 1).updateValue(varname, tope);
        }
        catch (Exception e)
        {
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method STORE_FAST: " + e.getMessage());

        }
    }

    private void runSTORE_GLOBAL(String varname){
        try{
            //almacena el contenido del tope de la pila en el almacén GLOBAL para la variable "varname"
            Object tope = 0;
            tope = myStackExprs.pop(); //debe sacar el elemento de la pila y devolver su valor
            almacenGlobal.updateValue(varname, tope);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method STORE_GLOBAL: " + e.getMessage());
        }

    }

    private void runLOAD_GLOBAL(String varname){
        try{
            //busca en el almacén GLOBAL el valor asociado a "varname" y lo inserta en la pila
            Object val;
            val = almacenGlobal.getValue(varname); //EL GET VALUE DEBE DEVOLVER UN VALOR PARA PODERLO CARGAR A LA PILA
            myStackExprs.push(val);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method LOAD_GLOBAL: " + e.getMessage());
        }
    }

    private void runCALL_FUNCTION(int numparams){
        try{
            int actualRef = ( int ) myStackExprs.pop(); //el primer elemento de la pila trae la referencia del método a llamar --REVISAR SI FALTA SUMAR O NO A LA REFERENCIA
            if (actualRef == -1){
                // es porque es el método print
                Object data = myStackExprs.pop();
                // if INT
                if (data.getClass() == Integer.class){
                    output += ("\n"+data.toString());
                    System.out.println(data.toString());
                }
                //if String
                else if (data.getClass() == String.class){
                    output += ("\n"+data);
                    System.out.println(data);
                }
                //if LIST
                else if (data.getClass() == ArrayList.class){
                    Collections.reverse(( ArrayList ) data);
                    System.out.println(Collections.singletonList(data)); // method 2
                    output += "\n"+Collections.singletonList(data);
                    /*output += ("\n[ ");
                    System.out.print("[ ");
                    for (int i = 0; i < (( ArrayList ) data).size(); i++){
                        System.out.print(" " + (( ArrayList ) data).get(i).toString());
                        output += (" "+(( ArrayList ) data).get(i).toString());
                        if (i != (( ArrayList ) data).size() - 1){
                            System.out.print(", ");
                            output += (", ");
                        }
                    }
                    output += (" ]");
                    System.out.println(" ]");

                     */
                    Collections.reverse(( ArrayList ) data);
                }
                //if HASH
                else if (data.getClass() == HashMap.class){
                    System.out.println(Collections.singletonList(data)); // method 2
                    output += "\n"+Collections.singletonList(data);
                }
                //if bool
                else if (data.getClass() == Boolean.class){
                    output += ("\n"+data.toString());
                    System.out.println(data.toString());
                }else{
                    output += ("\n"+data.toString());
                    System.out.println(data.toString());
                }
            }
            else{
                int latestInstr = actualInstrIndex;
                actualInstrIndex = actualRef;
                for (var i = 1; i <= numparams; i++){
                    //carga en una lista, todos los elementos de la pila referentes a parámetros
                    actualParamList.add(myStackExprs.pop());
                }
                Collections.reverse(actualParamList);
                almacenLocal.add(new Warehouse("Local")); // se crea el almacen local para el método a llamar
                myStackExprs.push(latestInstr); //se carga en la pila la dirección de la referencia a la dirección por la que iba antes de cambiarla por la del método a llamar
                //en buena teoría con solo cambiar el índice de la instrucción actual y respaldar el anterior en la pila, ya el ciclo de afuera llama emulando un salto
            }
        }
        catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method CALL_FUNCTION: " + e.getMessage());
        }
    }

    private void runRETURN_VALUE(){
        try{
            Object returnValue;
            returnValue = myStackExprs.pop(); // el tope de la pila tiene el elemento a retornar
            actualInstrIndex = ( int ) myStackExprs.pop(); //si no hay problem,a, el tope de la pila tiene ahora la dirección a la que de sebe "saltar" que estaba respaldada
            myStackExprs.push(returnValue); //se vuelve a meter en la pila el retorno para lo que corresponda posteriormente
            //almacenLocal[almacenLocal.Count-1].printContainer();
            almacenLocal.remove(almacenLocal.size() - 1); // se elimina el almacenLocaL del método
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method RETURN_VALUE: " + e.getMessage());
        }
    }

    private void runRETURN(){
        try{
            actualInstrIndex = ( int ) myStackExprs.pop(); //si no hay problema, el tope de la pila tiene ahora la dirección a la que de sebe "saltar" que estaba respaldad
            //almacenLocal[almacenLocal.Count-1].printContainer();

            almacenLocal.remove(almacenLocal.size() - 1); // se elimina el almacenLocaL del método
            //SI EL RETURN NO SE HACE AL FINAL, ESTO DA PROBLEMAS PORQUE PUEDE HABER COSAS EN LA PILA
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method RETURN: " + e.getMessage());
        }
    }

    private void runEND()
    {
        //acaba la corrida y limpia/elimina las estructuras según sea el caso
    }

    private void runCOMPARE_OP(String op){
        //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
        //se asume que los valores de los operandos son del mismo tipo, si no, se cae feo pero así debe ser... no hay mensajes de error
        Object opn2= myStackExprs.pop();
        Object opn1= myStackExprs.pop();
        try{
            if (op.equals("==")){
                if (opn1 == opn2){
                    myStackExprs.push(false);
                }
                else{
                    myStackExprs.push(true);
                }
            }
            else if (op.equals("!=")){
                if (opn1 != opn2){
                    myStackExprs.push(false);
                }
                else{
                    myStackExprs.push(true);
                }
            }
            else if (op.equals("<")){
                if ((Integer) opn1 < (Integer) opn2){
                    myStackExprs.push(false);
                }
                else{
                    myStackExprs.push(true);
                }
            }
            else if (op.equals("<=")){
                if ((Integer) opn1 <= (Integer) opn2){
                    myStackExprs.push(false);
                }else{
                    myStackExprs.push(true);
                }
            }
            else if (op.equals(">")){
                if ((Integer) opn1 > (Integer) opn2){
                    myStackExprs.push(false);
                }else{
                    myStackExprs.push(true);
                }
            }
            else if (op.equals(">=")){
                if ((Integer) opn1 >= (Integer) opn2){
                    myStackExprs.push(false);
                }else{
                    myStackExprs.push(true);
                }
            }
        }
        catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method COMPARE_OP, impossible to compare ' "+opn1.toString() +" with " +opn2.toString() +"' :" + e.getMessage());
        }
    }

    private void runBINARY_SUBSTRACT(){
        try{
            //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
            //se asume que los valores son enteros, si no, se cae feo pero así debe ser... no hay mensajes de error
            Object opn2= myStackExprs.pop();
            Object opn1= myStackExprs.pop();
            myStackExprs.push((Integer) opn1- (Integer) opn2);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_SUBSTRACT: " + e.getMessage());
        }
    }

    private void runBINARY_ADD(){
        try{
            //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
            //se asume que los valores son enteros, si no, se cae feo pero así debe ser... no hay mensajes de error
            Object opn2= myStackExprs.pop();
            Object opn1= myStackExprs.pop();
            try {
                myStackExprs.push((Integer) opn1 + (Integer) opn2);
            }catch (Exception e){
                myStackExprs.push((String) opn1 + (String ) opn2);
            }
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_ADD: " + e.getMessage());
        }
    }

    private void runBINARY_MULTIPLY(){
        try{
            //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
            //se asume que los valores son enteros, si no, se cae feo pero así debe ser... no hay mensajes de error
            Object opn2= myStackExprs.pop();
            Object opn1= myStackExprs.pop();
            myStackExprs.push((Integer) opn1 * (Integer) opn2);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_MULTIPLY: " + e.getMessage());
        }
    }

    private void runBINARY_DIVIDE(){
        try{
            //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
            //se asume que los valores son enteros, si no, se cae feo pero así debe ser... no hay mensajes de error
            Object opn2= myStackExprs.pop();
            Object opn1= myStackExprs.pop();
            myStackExprs.push((Integer) opn1 / (Integer) opn2);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_DIVIDE: " + e.getMessage());
        }
    }

    private void runBINARY_AND(){
        try{
            //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
            //se asume que los valores son enteros, si no, se cae feo pero así debe ser... no hay mensajes de error
            Object opn2= myStackExprs.pop();
            Object opn1= myStackExprs.pop();
            myStackExprs.push((Boolean) opn1 && (Boolean) opn2);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_AND: " + e.getMessage());
        }
    }

    private void runBINARY_OR(){
        try{
            //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
            //se asume que los valores son enteros, si no, se cae feo pero así debe ser... no hay mensajes de error
            Object opn2= myStackExprs.pop();
            Object opn1= myStackExprs.pop();
            myStackExprs.push((Boolean) opn1 || (Boolean) opn2);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_OR: " + e.getMessage());
        }
    }

    private void runBINARY_MODULO(){
        try{
            //obtiene dos operandos de la pila, opera según el operador y finalmente inserta el resultados de la operación en la pila
            //se asume que los valores son enteros, si no, se cae feo pero así debe ser... no hay mensajes de error
            Object opn2= myStackExprs.pop();
            Object opn1= myStackExprs.pop();
            myStackExprs.push((Double) opn1 %  (Double) opn2);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_MODULO: " + e.getMessage());
        }
    }

    private void runJUMP_ABSOLUTE(int target){
        try{
            //cambia el indice de la línea actual en ejecución a la indicada por "target"
            actualInstrIndex=target-1; //hay que restarle 1 por el incremento del ciclo posterior
        }
        catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method JUMP_ABSOLUTE: " + e.getMessage());
        }
    }

    private void runJUMP_IF_TRUE(int target){
        try{
            Object expr = myStackExprs.pop();
            if (expr.getClass() == Boolean.class){
                if ((Boolean ) expr == true ){
                    actualInstrIndex=target-1; //hay que restarle 1 por el incremento del ciclo posterior
                }
            }else if (expr.getClass() == Integer.class){
                if ((Integer) expr != 0 ){
                    actualInstrIndex=target-1; //hay que restarle 1 por el incremento del ciclo posterior
                }
            }
        }
        catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method JUMP_IF_TRUE: " + e.getMessage());
        }
        //if(pilaExprs.pop()==true)
        //    actualInstrIndex=target-1; //hay que restarle 1 por el incremento del ciclo posterior
    }

    private void runJUMP_IF_FALSE(int target){
        try{
            //cambia el indice de la línea actual en ejecución a la indicada por "target" en caso de que el tope de la pila sea TRUE
            Object expr = myStackExprs.pop();
            if (expr.getClass() == Boolean.class){
                if ((Boolean) expr == true){
                    actualInstrIndex = target - 1; //hay que restarle 1 por el incremento del ciclo posterior
                }
            }
            else if (expr.getClass() == Integer.class){
                if ((Integer) expr != 0){
                    actualInstrIndex = target - 1; //hay que restarle 1 por el incremento del ciclo posterior
                }
            }
            //cambia el indice de la línea actual en ejecución a la indicada por "target" en caso de que el tope de la pila sea FALSE
            //if(pilaExprs.pop()==false)
            //   actualInstrIndex=target-1; //hay que restarle 1 por el incremento del ciclo posterior
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method JUMP_IF_FALSE: " + e.getMessage());
        }
    }

    // Element access
    private void runBINARY_SUBSCR(){
        try{
            Object index = myStackExprs.pop();
            Object data = myStackExprs.pop();
            if (data.getClass() == ArrayList.class){
                ArrayList<Object> list = ( ArrayList<Object> ) data;
                myStackExprs.push(list.get(( Integer ) index));
            }else{
                HashMap<String, Object> hash = ( HashMap<String, Object> ) data;
                myStackExprs.push(hash.get(index.toString()));
            }
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BINARY_SUBSCR: " + e.getMessage());
        }
    }


    // Hash
    private void runBUILD_CONST_KEY_MAP(int size){
        try{
            HashMap<String, Object> hash = new HashMap<String, Object>();
            for (int i = 0; i < size; i++){
                Object value = myStackExprs.pop();
                String key = (String) myStackExprs.pop();
                hash.put(key,value); //adding a key/value using the Add() method
            }
            myStackExprs.push(hash);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BUILD_CONST_KEY_MAP: " + e.getMessage());
        }
    }

    // Array
    private void runBUILD_LIST(int size){
        try{
            ArrayList<Object> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                list.add(myStackExprs.pop());
            }
            myStackExprs.push(list);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method BUILD_LIST: " + e.getMessage());
        }
    }

    //LEN (list)
    private void runCALL_LEN(){
        try{
            ArrayList<Object> list = ( ArrayList<Object> ) myStackExprs.pop();
            Collections.reverse(list);
            int count = list.size();
            Collections.reverse(list);
            myStackExprs.push(count);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method CALL_LEN: " + e.getMessage());
        }
    }

    //FIRST (list)
    private void runCALL_FIRST(){
        try{
            ArrayList<Object> list = ( ArrayList<Object> ) myStackExprs.pop();
            Collections.reverse(list);
            Object value = list.get(0);
            Collections.reverse(list);
            myStackExprs.push(value);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method FIRST: " + e.getMessage());
        }
    }

    //LAST (list)
    private void runCALL_LAST(){
        try
        {
            ArrayList<Object> list = ( ArrayList<Object> ) myStackExprs.pop();
            Object value = list.get(0);
            myStackExprs.push(value);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method LAST: " + e.getMessage());
        }
    }

    //PUSH (list, DATA)
    private void runCALL_PUSH(){
        try{
            Object data = myStackExprs.pop();
            ArrayList<Object> list = ( ArrayList<Object> ) myStackExprs.pop();
            Collections.reverse(list);
            list.add(data);
            Collections.reverse(list);
            myStackExprs.push(list);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method PUSH: " + e.getMessage());
        }
    }

    //REST (list)
    private void runCALL_REST(){
        try{
            ArrayList<Object> list = ( ArrayList<Object> ) myStackExprs.pop();
            Collections.reverse(list);
            list.remove(0);
            Collections.reverse(list);
            myStackExprs.push(list);
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in method REST: " + e.getMessage());
        }
    }

    //método principal para correr todas las instrucciones de la lista... Este método debe recorrer la lista solo para agregar en el almacen global
    //las variables y métodos que hayan y cuando se encuentre el Main, este método si debe ejecutarse línea por línea porque es el punto de inicio
    //del programa
    public void run(){
        try{
            while (actualInstrIndex <= instSet.size()-1){
                if (instSet.get(actualInstrIndex).getKey().equals("PUSH_GLOBAL")||
                    instSet.get(actualInstrIndex).getKey().equals("DEF")){
                    switch(instSet.get(actualInstrIndex).getKey()){
                        case "PUSH_GLOBAL":
                            almacenGlobal.setValue(instSet.get(actualInstrIndex).getValue().toString(),0);
                            break;
                        case "DEF":
                            level = 1;
                            if (instSet.get(actualInstrIndex).getValue().toString().equals("Main")){
                                actualInstrIndex++; //se incrementa para que contenga la primera línea de código del Main
                                runMain();
                                return ;
                            }
                            else
                                runDEF(instSet.get(actualInstrIndex).getValue().toString());
                            break;
                    }
                    //Console.WriteLine("["+instSet[actualInstrIndex].Key + " " + instSet[actualInstrIndex].Value+"]");
                }
                actualInstrIndex++;
            }
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in loop RUN: " + e.getMessage());
        }
    }

    private void runMain(){
        try{
            while (actualInstrIndex <= instSet.size()-1){
                switch(instSet.get(actualInstrIndex).getKey()){
                        case "PUSH_LOCAL":
                            runPUSH_LOCAL(( String ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "PUSH_GLOBAL":
                            runPUSH_GLOBAL(( String ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "LOAD_CONST":
                            runLOAD_CONST(instSet.get(actualInstrIndex).getValue());
                            break;
                        case "LOAD_FAST":
                            runLOAD_FAST(( String ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "STORE_FAST":
                            runSTORE_FAST(( String ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "STORE_GLOBAL":
                            runSTORE_GLOBAL(( String ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "LOAD_GLOBAL":
                            if (instSet.get(actualInstrIndex).getValue().toString().equals("len"))
                            {
                                runCALL_LEN();
                            }else if (instSet.get(actualInstrIndex).getValue().toString().equals("first")){
                                runCALL_FIRST();
                            }else if (instSet.get(actualInstrIndex).getValue().toString().equals("last")){
                                runCALL_LAST();
                            }else if (instSet.get(actualInstrIndex).getValue().toString().equals("push")){
                                runCALL_PUSH();
                            }else if (instSet.get(actualInstrIndex).getValue().toString().equals("rest")){
                                runCALL_REST();
                            }else{
                                runLOAD_GLOBAL(instSet.get(actualInstrIndex).getValue().toString());
                            }
                            break;
                        case "CALL_FUNCTION":
                            runCALL_FUNCTION(( Integer ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "RETURN_VALUE":
                            runRETURN_VALUE();
                            break;
                        case "RETURN":
                            level = 0;
                            runRETURN();
                            break;
                        case "END":
                            runEND();
                            break;
                        case "COMPARE_OP":
                            runCOMPARE_OP(instSet.get(actualInstrIndex).getValue().toString());
                            break;
                        case "BINARY_SUBSTRACT":
                            runBINARY_SUBSTRACT();
                            break;
                        case "BINARY_ADD":
                            runBINARY_ADD();
                            break;
                        case "BINARY_MULTIPLY":
                            runBINARY_MULTIPLY();
                            break;
                        case "BINARY_DIVIDE":
                            runBINARY_DIVIDE();
                            break;
                        case "BINARY_AND":
                            runBINARY_AND();
                            break;
                        case "BINARY_OR":
                            runBINARY_OR();
                            break;
                        case "BINARY_MODULO":
                            runBINARY_MODULO();
                            break;
                        case "JUMP_ABSOLUTE":
                            runJUMP_ABSOLUTE(( Integer ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "JUMP_IF_TRUE":
                            runJUMP_IF_TRUE(( Integer ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "JUMP_IF_FALSE":
                            runJUMP_IF_FALSE(( Integer ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "BUILD_LIST":
                            runBUILD_LIST(( Integer ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "BUILD_CONST_KEY_MAP":
                            runBUILD_CONST_KEY_MAP(( Integer ) instSet.get(actualInstrIndex).getValue());
                            break;
                        case "BINARY_SUBSCR":
                            runBINARY_SUBSCR();
                            break;
                }
                actualInstrIndex++;
            }
        }catch (Exception e){
            System.out.println("SERVER> ERROR : ( " + actualInstrIndex + " ) " + "instruction in loop MAIN: " + e.getMessage());
        }
    }

    public void printInstructionSet(){
        System.out.println();
        System.out.println("Set de instrucciones: ");
        for(int i = 0; i < instSet.size(); i++){
            System.out.println(i + " " + instSet.get(i).toString());
        }
    }

}
