package figures;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ellipse extends Figure {
   
      
    public Ellipse (int x, int y, int w, int h,Color Board, Color Background){
        super(x, y,w,h,Board,Background);
      
        }
       

        public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

      
        if (focused){
            g2d.setColor(Color.red);
            g2d.drawOval(this.x, this.y, this.w,this.h);
        }
        else {
            g2d.setColor(this.Board);
            g2d.fillOval(this.x, this.y, this.w, this.h);
        }

    }
    }
    