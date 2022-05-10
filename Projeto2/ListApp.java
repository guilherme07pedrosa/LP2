//ListApp.java
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
    Point position;
    Button focus_but=null;
    boolean but_clicked;
    int x, y, w, h;
    Color c;
    
    ListFrame(){
        buts.add(new Button(0, new Rect(0,0, 0,0,Color.white,Color.gray)));// botão para Reta
        buts.add(new Button(1, new Ellipse(0,0, 0,0,Color.white,Color.gray)));// botão pra ellipse
     //   buts.add(new Button(2, new Triangulo(28, 233, 0, 0,Color.white,Color.gray))); // botão para Triangulo 
      //  buts.add(new Button(3, new Circulo(24,144, 0,0,Color.white,Color.gray))); //botão para C
       /*try{
            FileInputStream f=new FileInputStream("proj.bin");
            ObjectInputStream o=new ObjectInputStream(f);
            this.figs=(ArrayList<Figure>) o.readObject();
            o.close();
          }*//*catch (Exception x) {
              System.out.println("ERRO");
          }*/
            
    }
    
   

     {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                   /* try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    }*/ /*catch (Exception x) {
                        System.out.println("ERRO");
                    }
                    System.exit(0);*/
                }
            }
        );
       
        /*Listener para o foco  do mouse  figura será criada onde o mouse estiver*/
       this.addMouseListener (
            new MouseAdapter() {
                public void  mousePressed(MouseEvent evt) {
                    mouse = getMousePosition();
                    focused=null;
                    int x = evt.getX();
                    int y = evt.getY();
                     if (focused != null) {
                        focused.Board = c;
                    }
                    focused=null;
                    
                    for (Figure fig: figs) {
                        if (fig.clicked(x,y)) {
                            System.out.println("teste ok.");
                            focused = fig;
                            focused.Board=c;
                        }
                    }
                    //Foco Z, a cor da última figura sempre clicada sempre vai prevalecer quando colocada em cima das outras
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
              
        this.setTitle("Projeto 2");
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
                    
        this.setTitle("Projeto 2");
        this.setSize(350, 350);
    }

    
    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g/*, fig==focused*/);
        }
        for (Button but: this.buts){
            but.paint(g,but==focus_but); 
        
        }
    }
}
