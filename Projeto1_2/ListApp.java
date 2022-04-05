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
    boolean mouse_clicked;
    int x, y, w, h;
    Color c;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
       
        /*Listener para o foco do mouse- a figura será criada onde o mouse estiver clicado*/
       this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    focused=null;
                    mouse = evt.getPoint();
                   // mouse_clicked=true;
                    int x = evt.getX();
                    int y = evt.getY();
                    int w = evt.getX();
                    int h = evt.getY();
                     if (focused != null) {
                        focused.Board = c;
                    }
                    focused=null;
                    
                    
                    for (Figure fig: figs) {
                        if (fig.clicked(x,y)) {
                            //System.out.println("teste ok.");
                            focused = fig;
                            focused.Board=c;
                        }
                        
                         
                    }
                    if (focused != null) {
                     focused.Board=c;
                     figs.remove(focused);
                     figs.add(focused);
                        
                    }
            repaint();
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
                    int x = mouse.x;
                    int y = mouse.y;
                    int w = 96;
                    int h = 72;
                    
                    
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h,Color.green,Color.black);
                        figs.add(r);
                    } 
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h,Color.blue,Color.yellow ));
                    }
                    //else if (evt.getKeyChar() == 'l') {
                    //    figs.add(new Line(x,y, w,h));
                    //}
                    else if (evt.getKeyChar() == 't') {
                        figs.add(new Triangulo(x,y, w,h,Color.cyan,Color.blue));
                    }
                    else if (evt.getKeyChar() == 'c') {
                        figs.add(new Circulo(x,y, w,h,Color.black, Color.green));
                    }
                    
                    else if (evt.getKeyChar() == 'd') {
                        figs.remove(i);}
                    
                    else if (evt.getKeyCode() == KeyEvent.VK_UP){
                            focused.resize(5, 5);
                        }
                    else if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                            focused.resize(-5, -5);
                        }
                    
                    repaint();
                }
            }
            );
                    
        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    
    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
    
        
    }
}
}
