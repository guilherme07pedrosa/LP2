
package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.*;

public class Circulo extends Figure {
   
    
    public Circulo (int x, int y, int w, int h,Color Board, Color Background){
        super(x, y,w,h,Board,Background);
      
        }
        
        

       public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

       
        if (focused){
            g2d.setColor(Color.red);
            g2d.drawOval(this.x, this.y, this.w,this.w);
        }
        else {
            g2d.setColor(this.Board);
            g2d.fillOval(this.x, this.y, this.w, this.w);
        }
    }
}