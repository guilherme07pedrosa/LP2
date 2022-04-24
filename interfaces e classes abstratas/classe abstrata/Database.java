import java.util.ArrayList;


public class Database
{
    private ArrayList<UsuarioDaBiblioteca> items;

    
    public Database()
    {
        items = new ArrayList<UsuarioDaBiblioteca>();
    }

    
    public void addItem(UsuarioDaBiblioteca theUsuarioDaBiblioteca)
    {
        items.add(theUsuarioDaBiblioteca);
    }

       public void list()
    {
        for(UsuarioDaBiblioteca item : items) {
            item.print();
            System.out.println();   
        }
    }
}
