
/**
 * 
 */
class usuario_solução implements Ialuno, Iprofessor
{

    public void show()
    {
        
        Ialuno.super.show();

        Iprofessor.super.show();
    }
  
    public static void main(String args[])
    {
        usuario_solução d = new usuario_solução();
        d.show();
    }
}
