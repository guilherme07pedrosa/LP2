/**
 Cadatro de usuario da Bilioteca, inspirado no programa Item do Cap 8 do livro
 */
public class UsuarioDaBiblioteca
{
    private String nome;
    private int numeroDoCadatro;
    
    public UsuarioDaBiblioteca(String theNome, int numero)
    {
        nome = theNome;
        numeroDoCadatro=numero;
    }

    
    public void print()
    {
        System.out.print(numeroDoCadatro);
        System.out.print(nome);
   
}
}
