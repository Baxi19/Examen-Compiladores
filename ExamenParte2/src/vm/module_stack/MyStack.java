package vm.module_stack;

import java.util.Stack;

public class MyStack {
    public Stack<Object> stack = new Stack<>();

    public void push (Object obj){
        stack.push(obj);
    }

    public Object pop(){
        return stack.pop ();
    }

    public Boolean exchange(){
        try{
            Object value1 = stack.pop ();
            Object value2 = stack.pop ();
            stack.push(value1);
            stack.push(value2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void imprimir() {
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i).toString());
        }
    }
}
