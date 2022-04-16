
/**
 * 
 */
class jogador_perfeito implements Iatacante, Igoleiro
{

    public void show()
    {
        
        Iatacante.super.show();

        Igoleiro.super.show();
    }
  
    public static void main(String args[])
    {
        jogador_perfeito d = new jogador_perfeito();
        d.show();
    }
}
