package figures;

import java.awt.*;

public class Poly {
    private int x[]; 
    private int y[];
    int n;

    public Poly (int x[], int y[], int n ){
        this.x= x;
        this.y = y;
        this.n = n;
    
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.x, this.y, this.n);
    }

    public void paint (Graphics g) 
    {
    
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(0,0,255));
        g2d.fillPolygon(this.x,this.y, this.n);
        
    }
}