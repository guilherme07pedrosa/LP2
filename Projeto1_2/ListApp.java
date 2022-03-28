import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    int i;
    Figure focused = null;
    Point mouse=null;
    Point position;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
       
        /*Listener para o foco do mouse*/
       this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    focused=null;
                    mouse = evt.getPoint();
                    int x = evt.getX();
                    int y = evt.getY();
                    for (Figure fig: figs) {
                        if (fig.clicked(x,y)) {
                            System.out.println("teste ok.");
                            focused = figs.get(i);
                        }
                    }

                }
            }
            );
        /*Listener para arrastar figuras*/
        this.addMouseMotionListener( 
            new MouseAdapter() {
                public void mouseDragged (MouseEvent evt) { 
                          focused.drag(evt.getX() - mouse.x, evt.getY() - mouse.y);
                          mouse = getMousePosition();
                          repaint();
                        
                    }
                }
            );
        
        
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = 70;
                    int y = 80;
                    int w = 90;
                    int h = 55;
                    
                    
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h);
                        figs.add(r);
                    } 
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h));
                    }
                    else if (evt.getKeyChar() == 'l') {
                        figs.add(new Line(x,y, w,h));
                    }
                    else if (evt.getKeyChar() == 't') {
                        figs.add(new Triangulo(x,y, w,h));
                    }
                    else if (evt.getKeyChar() == 'd') {
                        figs.remove(i);
                    }
                    repaint();
                }
            }
            );
            
            

            this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    focused=null;
                    mouse = evt.getPoint();
                    int x = evt.getX();
                    int y = evt.getY();
                    for (Figure fig: figs) {
                        if (fig.clicked(x,y)) {
                            System.out.println("teste ok.");
                            focused = figs.get(i);
                        }
                    }

                }
            }
    
        );
          
        
        
            

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (Exception e)
        {
            
        }
    }
    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
    
        
    }
}
}