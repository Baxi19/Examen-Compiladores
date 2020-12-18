package vm.module_Interpreter;

public class MyHash {
    public String key;
    public Object value;

    public MyHash(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{ key = ' " + key + " ' , value = ' " + value + " '} ";
    }
}
