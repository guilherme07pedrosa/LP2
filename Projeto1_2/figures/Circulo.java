package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Circulo extends Figure {

    public Circulo (int x, int y, int w, int h) {
        super(x,y,w,h);
    }

    

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.w));
    }
}