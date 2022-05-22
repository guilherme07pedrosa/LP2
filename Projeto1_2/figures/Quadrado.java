package figures;
import java.awt.*;
import java.util.*;


/**
 Criado em 19/05/2022
 */

public class Quadrado extends Figure {
    
    
    public Quadrado(int x, int y, int w, int h,Color Board, Color Background){
        super(x, y,w,h,Board,Background);
        
    }   
        
    public void colorFig(Color Background){
            this.Background = Background;
        
        }
    

    
       public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        

        if (focused){
            g2d.setColor(Color.red);
            g2d.drawRect(this.x, this.y, this.w,this.w);
            
        }
        else {
            g2d.setColor(this.Board);
            g2d.fillRect(this.x, this.y, this.w, this.w);
            
        }

    }
    } 
        
        
        
        
    