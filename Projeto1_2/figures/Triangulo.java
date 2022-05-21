
package figures;

import java.awt.*;

public class Triangulo extends Figure {
    int a[] = {x,x+w/2,x-w/2};
    int b[] = {y,y+h,y+h};
    int c=3;

    public Triangulo (int x, int y, int w, int h,Color Board, Color Background){
        super(x, y,w,h,Board,Background);
        //this.x=x;
      //  this.y=y;
        //this.w=w;
       // this.h=h;
            this.Board=Board;
            this.Background=Background;
            a= new int[] {x,x+w/2,x-w/2};
            b= new int[]{y,y+h,y+h};        
    }
   
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
        a= new int[] {x,x+w/2,x-w/2};
        b= new int[]{y,y+h,y+h};
        
    }

    public void resize(int rw, int rh) {
        this.w += rw;
        this.h += rh;
        a= new int[] {x,x+w/2,x-w/2};
        b= new int[]{y,y+h,y+h};
        
    }
    

    public void colorFig(Color Background){
            this.Background = Background;
        
        }

        
       
         public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.green);
        g2d.fillPolygon(this.a,this.b, 3);

        if (focused){
            g2d.setColor(Color.red);
           g2d.drawPolygon(this.a,this.b, 3);
        }
        else {
            g2d.setColor(Color.green);
           g2d.fillPolygon(this.a,this.b, 3);
           
        }

    }
    }
         
        
        
        
        
    