/**
 * Figuras - Triangulo
 * Guilherme Pedrosa
 * 10/03/2022
 */
package figures;

import java.awt.*;

public class Triangulo extends Figure {
    int a[] = {x,x+w/2,x-w/2};
    int b[] = {y,y+h,y+h};
    int c=3;

    public Triangulo (int x, int y, int w,int h) {
        super(x,y,w,h);
            a= new int[] {x,x+w/2,x-w/2};
            b= new int[]{y,y+h,y+h};        
    }
   
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
        a= new int[] {x,x+w/2,x-w/2};
        b= new int[]{y,y+h,y+h};
        
    }


    

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillPolygon(this.a,this.b, 3);
    }
}