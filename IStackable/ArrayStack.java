import java.util.*;


public class ArrayStack implements IStackable
{
    ArrayList l = new ArrayList();
    
    
    public int size(){
      
        return l.size();  
    }
    
    
    
    public void push(int v){
         l.add(v);
    }
    
    public int pop(){

        return (int)l.remove(0);
    }
    
    
    
}
