
/**
  NaveEspacial- se desloca no eixo X, Aitra e Explode.
 
 */
public class NaveEspacial implements SpaceInvaders

{
    public int x,dx;
    public int getPosicaoX(){
        x=0;
        return x;
    }
    
    public int setPosicçãoX(){
        x=0;
        dx=1;
        return x+dx;
    }
    
    
    public boolean Atirar(){
        return true;
    }
    
    public boolean Explodir(){
        return false;
    }
    
    public int Score(){
        return 1000;
    }
    
    
}
    

