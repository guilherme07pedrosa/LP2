/**
 * Figuras - Linhas
 * Guilherme Pedrosa
 * 10/03/2022
 */

package figures;

import java.awt.*;

public class Line extends Figure {

    public Line (int x, int y, int w, int h) {
        super(w,y,w,h);
    }

    

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(this.x,this.y, this.w,this.h);
    }
}