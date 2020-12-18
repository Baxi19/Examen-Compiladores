package vm.module_warehouse;

import java.util.HashMap;

public class Warehouse {
    // PRELIMINARY DATA STRUCTURE:
    HashMap<String, Object> data ;

    // -----------------------------
    private String name;

    // constructor
    public Warehouse(String name){
        this.data = new HashMap<String, Object>();
        this.name = name;
    }

    // ADD VALUE TO THE DICTIONARY
    public void setValue(String key, Object value){
        if (searchValue(key)){
            updateValue(key, value);
        }else{
            this.data.put(key, value);
        }
    }

    // RETURN VALUE
    public Object getValue(String key){
        for (int i = 0; i < data.size(); i++) {
            if(data.containsKey(key)){
                return data.get(key);
            }
        }
        return null;
    }

    // GET VALUE IF FOUND
    public Boolean searchValue(String key){
        if(this.data.containsKey(key)){
            return true;
        }
        return false;
    }

    // UPDATE VALUE IF FOUND
    public void updateValue(String key, Object newValue){
        Boolean found = searchValue(key);
        if(!found){
            System.out.println("404 Item ( "+ key.toString() +" ) not found!");
        }
        else{
            data.remove(key);
            data.put(key, newValue);
        }
    }
/*
    // PRINT DICTIONARY
    // Almacen tiene u n item
    public void printContainer(){
        foreach (dynamic item in this.data){
            Console.WriteLine("Key: {0}, Value: {1} Type: {2}", item.Key, item.Value, item.Value.GetType());
        }
    }
*/
}
