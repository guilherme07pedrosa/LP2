package figures;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {
    
      
    public Ellipse (int x, int y, int w, int h,Color Board, Color Background){
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

        public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.Board);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(this.Background);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(new Color(255,0,0));
        //g2d.fillOval(this.x,this.y, 10,10);
        }
    }