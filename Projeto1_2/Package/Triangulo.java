/**
 * Figuras - Triangulo
 * Guilherme Pedrosa
 * 10/03/2022
 */
package figures;

import java.awt.*;

public class Triangulo extends Figure {
    int a[] = {x,(x+w)/2,(x-w)/2};
    int b[] = {y,(y+h)/2,(y-h)/2};

    public Triangulo (int x, int y, int w,int h) {
        super(x,y,w,h);
    }


    

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.a,this.b, 3);
    }
}