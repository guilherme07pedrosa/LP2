package figures;

import java.awt.Graphics;

public abstract class Figure {
    int x, y;
    int w, h;
    int a[], b[];
    int n=3;
    public Figure(int x, int y, int w, int h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        
        
    }
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
public abstract void paint (Graphics g);
}