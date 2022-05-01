package figures;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import ivisible.IVisible;

    public abstract class Figure implements IVisible {
        protected int x, y;
        protected int w, h;
        public Color Board;
        public void setBoard(Color Board){this.Board=Board;}
        public Color getBoard(){return Board;};
        public Color Background;
        public void setBackground(Color Background){this.Background=Background;}
        public Color getBackground(){return Background;};
       
  
    protected Figure(int x, int y, int w, int h,Color Board, Color Background){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
            this.Board=Board;
            this.Background=Background;
        
    }
   public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
        
    }
    
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    
    
    public  void resize (int rw, int rh){
        this.w += rw;
        this.h += rh;
        
    }
    
    
        
    
    
    public abstract void paint (Graphics g);
    }