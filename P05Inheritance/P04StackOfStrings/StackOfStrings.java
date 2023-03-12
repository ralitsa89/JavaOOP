package P05Inheritance.P04StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }
    public void push(String element){
        this.data.add(element);
    }

    public String pop(){
       return this.data.remove(this.data.size() - 1);
    }
    public String peek(){
        return this.data.get(this.data.size() - 1);
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }

}
