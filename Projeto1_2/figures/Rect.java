

package figures;
import java.awt.*;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h,Color Board, Color Background){
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
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.Background);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(255,0,0));
        //g2d.fillOval(this.x,this.y, 10,10);
        }
    }