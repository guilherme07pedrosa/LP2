
/**
 * Escreva uma descrição da classe Missil aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Asteroide implements SpaceInvaders
{
    public int x,dx;
    public int y,dy;
    
    public int getPosicaoX(){
        x=0;
        return x;
    }
    
    public int setPosicçãoX(){
        x=0;
        dx=1;
        return x+dx;
    }
    
    public int getPosicaoY(){
        y=0;
        return y;
    }
    public int setPosicçãoY(){
        y=0;
        dy=1;
        return y+dy;
    }
    
    public boolean Explodir(){
        return false;
    }
}
