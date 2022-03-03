package figures;

import java.awt.*;

public class Arc {
   private int x, y;
   private int w, h;
   private int startAngle, arcAngle;

    public Arc (int x, int y, int w, int h, int startAngle, int arcAngle) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.startAngle = startAngle;
        this.arcAngle= arcAngle;

    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        /*g.drawArc(x, y, width, height, startAngle, arcAngle);*/
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawArc(this.x,this.y, this.w,this.h, this.startAngle, this.arcAngle);
    }
}