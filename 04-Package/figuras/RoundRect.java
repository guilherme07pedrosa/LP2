package figures;

import java.awt.*;

public class RoundRect {
    int x, y;
    int w, h;
    int  arcHeight, arcWidth;

    public RoundRect (int x, int y, int w, int h, int arcHeight, int arcWidth) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.arcHeight=arcHeight;
        this.arcWidth=arcWidth;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        /*g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);*/
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRoundRect(this.x,this.y, this.w,this.h, this.arcHeight,  this.arcWidth) ;
    }
}
