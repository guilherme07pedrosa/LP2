
package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Circulo extends Figure {

    public Circulo (int x, int y, int w, int h,Color Board, Color Background){
        super(x, y,w,h,Board,Background);
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
            this.Board=Board;
            this.Background=Background;

        }
        
        public void colorFig(Color Background){
            this.Background = Background;
        
        }

       public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillOval(this.x, this.y, this.w, this.h);

        if (focused){
            g2d.setColor(Color.red);
            g2d.drawOval(this.x, this.y, this.w,this.h);
        }
        else {
            g2d.setColor(Color.black);
            g2d.drawOval(this.x, this.y, this.w, this.h);
        }
    }
}