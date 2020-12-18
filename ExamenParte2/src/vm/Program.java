package vm;

import vm.module_Interpreter.InstructionSet;
import vm.module_code.Desensamblador;

public class Program {
    public InstructionSet instructionSet;
    public Desensamblador desensamblador;

    public Program(String path) {
        this.instructionSet = new InstructionSet();
        this.desensamblador = new Desensamblador(this.instructionSet);
        desensamblador.desensamblar(path);
        instructionSet.run();
    }

    public InstructionSet getInstructionSet() {
        return instructionSet;
    }

    public void setInstructionSet(InstructionSet instructionSet) {
        this.instructionSet = instructionSet;
    }

    public Desensamblador getDesensamblador() {
        return desensamblador;
    }

    public void setDesensamblador(Desensamblador desensamblador) {
        this.desensamblador = desensamblador;
    }

    @Override
    public String toString() {
        return "Program{" +
                "instructionSet=" + instructionSet +
                ", desensamblador=" + desensamblador +
                '}';
    }
}
