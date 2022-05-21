package figures;

import java.awt.*;
import java.awt.font.TextAttribute;

public class Texto extends Figure{
    public Texto (int x, int y, int w, int h,Color Board, Color Background) {
        super(x, y,w,h,Board,Background);
      //  this.x=x;
       // this.y=y;
       // this.w=w;
      //  this.h=h;
            this.Board=Board;
            this.Background=Background;
    }

    public void paint (Graphics g, boolean focus) {
        Graphics2D g2d = (Graphics2D) g;
        
        if (focus){
            
            g2d.setColor(Color.black);
        }
        else {
            g2d.setColor (Color.red);
        }
        
       
        
        
        g2d.drawString("\nTexto", this.x,this.y);
    }

    public boolean clicked (int ex, int ey) {
       
        if (ex >= this.x && ex<=this.x + this.w && ey<=this.y && ey>=this.y-this.h){
            return true;
        }
        return false;
    }
    
}