/**
 * Figuras - Triangulo
 * Guilherme Pedrosa
 * 10/03/2022
 */
package figures;

import java.awt.*;

public class Triangulo {
    int x[], y[];
    int n;

    public Triangulo (int x[], int y[],  int n) {
        n=3;
        this.x = x;
        this.y = y;
        this.n = n;
    }

   
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.x,this.y, this.n);
    }
}