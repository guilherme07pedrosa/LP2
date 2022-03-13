/**
 * Figuras - Linhas
 * Guilherme Pedrosa
 * 10/03/2022
 */
package figures;

import java.awt.*;

public class Line extends Figure {
    

    public Line (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void print () {
        System.out.format("Linha de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x,this.y, this.w,this.h);
    }
}