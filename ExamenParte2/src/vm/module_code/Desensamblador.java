package vm.module_code;

import vm.module_Interpreter.InstructionSet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Desensamblador {
    public InstructionSet setInstrucciones;

    public Desensamblador(InstructionSet setInstrucciones){
        this.setInstrucciones = setInstrucciones;
    }

    public void desensamblar(String origen) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(origen));
            for (int i = 0; i < allLines.size(); i++) {
                String[] palabras = allLines.get(i).split(" ");
                if (palabras.length >= 3){ //se podría prescindir del número inicial de la instrucción pero es para control
                    try{
                        int param = Integer.parseInt(palabras[2]);//Primero se intenta convertir el parámetro a número
                        setInstrucciones.addInst(palabras[1], param);
                    }catch (Exception e){
                        char starterChar = palabras[2].toCharArray()[0];
                        if (starterChar == '\''){
                            setInstrucciones.addInst(palabras[1], palabras[2].replace("\'",""));//Si el parámetro no es un char
                        }else if ((starterChar == '"')){
                            String word = "";
                            for (int j = 2; i < palabras.length; i++){
                                word += (palabras[j]+" ");
                            }
                            //Console.WriteLine("DATA: " + word);
                            setInstrucciones.addInst(palabras[1], word.replace("\"",""));//Si el parámetro no es un string
                        }else{
                            setInstrucciones.addInst(palabras[1], palabras[2]);//Si el parámetro no es un número válido para evitar error
                        }
                    }
                }else if (palabras.length == 2){
                    setInstrucciones.addInst(palabras[1], null);//La instrucción no contiene parámetro.
                }
            }
        }catch (IOException e){
            System.out.println("Error con el archivo: " + e.getMessage());
        }
    }
}
