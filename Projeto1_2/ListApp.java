import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import java.io.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    int i;
    Figure focused = null;
    Point mouse=null;
    Button focus_but;
    boolean but_clicked=false;
    int x, y, w, h;
    Color c;

    ListFrame () {
        buts.add(new Button(0, new Rect(0, 0, 0, 0,Color.white,Color.gray))); 
        buts.add(new Button(1, new Ellipse(0,0, 0,0,Color.white,Color.gray)));
        buts.add(new Button(2, new Triangulo(0,0, 0,0,Color.white,Color.gray)));
        buts.add(new Button(3, new Circulo(0,0, 0,0,Color.white,Color.gray)));
        
       try{
            FileInputStream f=new FileInputStream("proj.bin");
            ObjectInputStream o=new ObjectInputStream(f);
            this.figs=(ArrayList<Figure>) o.readObject();
            o.close();
          } catch (Exception x) {
              System.out.println("ERRO");
          }
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                      try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    }  catch (Exception x) {
                        System.out.println("ERRO");
                    }
                    System.exit(0);
                }
            }
        );
       
        /*Listener para o foco  do mouse  figura será criada onde o mouse estiver*/
       this.addMouseListener (
            new MouseAdapter() {
                public void  mousePressed(MouseEvent evt) {
                    mouse = getMousePosition();
                    focused=null;
                    focus_but=null;
                    but_clicked=false;
                    
                    int x = evt.getX();
                    int y = evt.getY();
                    // if (focused != null) {
                    //    focused.Board = c;
                 //   }
                 //   focused=null;
                    
                    for (Figure fig: figs) {
                        if (fig.clicked(x,y)) {
                            //System.out.println("teste ok.");
                            focused = fig;
                            focus_but=null;
                            //focused.Board=c;
                            but_clicked=false;
                        }
                    }
                    //Foco Z, a cor da última figura sempre clicada sempre vai prevalecer quando colocada em cima das outras
                    if (focused != null) {
                       figs.remove(focused);
                       figs.add(focused);
                        }
                    
                    for (Button but:buts) {
                        if(but.clicked(x,y)){ 
                            //System.out.println("teste ok.");
                            focus_but = but;
                            focused = null;
                            but_clicked = true;
                        }
                    }
            repaint();
            
              if (focused == null && focus_but != null){
                        if (focus_but == buts.get(0)) { 
                            figs.add(new Rect(mouse.x,mouse.y, 50,50,Color.white,Color.gray));                                                 
                            
                        }
                        else if (focus_but == buts.get(1)) {
                            figs.add(new Ellipse(mouse.x,mouse.y, 50,70,Color.white,Color.gray ));
                            
                        }  
                        
                        else if (focus_but == buts.get(2)) {
                            figs.add(new Triangulo(mouse.x,mouse.y, 100,100,Color.white,Color.gray ));
                            
                        }
                        
                        else if (focus_but == buts.get(3)) {
                            figs.add(new Circulo(mouse.x,mouse.y, 50,50,Color.white,Color.gray ));
                            
                    
                     }
            
            
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
              
        this.setTitle("Iterface IVisible");
        this.setSize(350, 350);
        
        
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    mouse = getMousePosition();
                    int x = mouse.x;
                    int y = mouse.y;
                    int w = 96;
                    int h = 72;
                    
                    
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h,Color.white,Color.black));
                        
                    } 
                 
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h,Color.white,Color.yellow  ));

                        
                    }
                    
                    else if (evt.getKeyChar() == 't') {
                        figs.add(new Triangulo(x,y, w,h,Color.white,Color.blue));
                    }
                    
                    else if (evt.getKeyChar() == 'c') {
                        figs.add(new Circulo(x,y, w,h,Color.white, Color.green));
                        
                    }
                   
                    else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
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
                    
    }

    
    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g,fig==focused);
        for (Button but: this.buts)  { 
            but.paint(g,but == focus_but);
       }
    
        
    }
}
}
