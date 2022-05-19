package figures;
import java.awt.*;


/**
 Criado em 19/05/2022
 */

public class Quadrado extends Figure {

    public Quadrado(int x, int y, int w, int h,Color Board, Color Background){
        super(x, y,w,h,Board,Background);
        //this.x=x;
        //this.y=y;
       // this.w=w;
       // this.h=h;
            this.Board=Board;
            this.Background=Background;
    }   
        
    public void colorFig(Color Background){
            this.Background = Background;
        
        }
    

    
       public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillRect(this.x, this.y, this.w, this.w);


        if (focused){
            g2d.setColor(Color.red);
            g2d.drawRect(this.x, this.y, this.w,this.w);
            
        }
        else {
            g2d.setColor(Color.black);
            g2d.drawRect(this.x, this.y, this.w, this.w);
            
        }

    }
    } 
        
        
        
        
    