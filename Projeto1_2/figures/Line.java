/**
 /**
 * Figuras - Linhas
 * Guilherme Pedrosa
 * 10/03/2022
 */

package figures;

import java.awt.*;

public class Line extends Figure {
    
    
    public Line (int x, int y, int w, int h,Color Board, Color Background){
        super(x, y,w,h,Board,Background);
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
            this.Board=Board;
            this.Background=Background;

        }
        
        public void colorFig(Color Background){
			this.Background = Background;
		
		}

        public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.Board);
        g2d.setColor(this.Background);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        }
    }