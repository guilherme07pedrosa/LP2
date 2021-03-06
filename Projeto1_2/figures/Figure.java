
package figures;
import java.io.Serializable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import ivisible.IVisible;
import java.util.*;

public abstract class Figure implements IVisible, Serializable {
    public int x, y;
    public int w, h;
        public Color Board, Background ;
        Color colorList[] = { Color.BLUE, Color.GREEN,};
        Random rand = new Random();
    
  
    public Figure(int x, int y, int w, int h,Color Board, Color Background){
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
    
    public void changing_Board(Color BLUE, Color GREEN){
        if (this.Board==Color.BLUE){
         this.Board=Color.GREEN;}
       else if (this.Board==Color.GREEN){
         this.Board=Color.BLUE;}
    }

    public void changing_Background(Color BLUE, Color GREEN){
        if (this.Board==Color.BLUE){
         this.Board=Color.GREEN;}
       else if (this.Board==Color.GREEN){
         this.Board=Color.BLUE;}
        
         }
    
    public abstract void paint (Graphics g, boolean focused);
    }