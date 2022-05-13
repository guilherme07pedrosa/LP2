
import java.util.*;



/*
 LinkedStack
 */
public class LinkedStack implements IStackable


{
    LinkedList l= new LinkedList();
    
    public int size(){
      
        return l.size();  
    }
    
    
    
    public void push(int v){
         l.addFirst(v);
    }
    
    public int pop(){
        int v;

        return (int)l.removeFirst();
    }
}
