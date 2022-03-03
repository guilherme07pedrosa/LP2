import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures. Rect;
import figures. Ellipse;
import figures. Line;
import figures. RoundRect;
import figures. Polyline;
import figures. Arc;



class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Line l1;
    RoundRect o1;
   /*Polygon p1;*/
    Polyline p1;
    Arc a1;
    
    
    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
       
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,100, 100,30);
        this.l1 = new Line(225,300,250,120);
        this.o1 = new RoundRect(225,300,250,120,90,90);
        int x[] = {225, 200, 170 ,225};
        int y[] = {200, 300, 260, 200 };
        this.p1 = new Polyline(x,y,4);
        this.a1 = new Arc (350,50,250,100,60,60);
        
        
    }

    public void paint (Graphics g ) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.l1.paint(g);
        this.o1.paint(g);
        this.p1.paint(g);
        this.a1.paint(g);
    }
}