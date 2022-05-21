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
   

    ListFrame () {
        buts.add(new Button(2, new Rect(0, 0, 0, 0,Color.white,Color.gray))); 
        buts.add(new Button(1, new Ellipse(0,0, 0,0,Color.white,Color.gray)));
        buts.add(new Button(0, new Triangulo(85,60, 50,40,Color.white,Color.gray)));
        buts.add(new Button(3, new Circulo(0,0, 0,0,Color.white,Color.gray)));
        buts.add(new Button(4, new Quadrado(0,0, 0,0,Color.white,Color.gray)));
        buts.add(new Button(5, new Texto(0,0, 0,0,Color.white,Color.gray)));
        
       try{
            FileInputStream f=new FileInputStream("proj.svg");
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
                        FileOutputStream f = new FileOutputStream("proj.svg");
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
                
                    
                    for (Figure fig: figs) {
                        if (fig.clicked(x,y)) {
                            focused = fig;
                            focus_but=null;
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
                            figs.add(new Rect(mouse.x,mouse.y, 50,100,Color.white,Color.gray));                                                
                            focus_but = null;
                        }
                        else if (focus_but == buts.get(1)) {
                            figs.add(new Ellipse(mouse.x,mouse.y, 50,70,Color.white,Color.gray ));
                             focus_but = null;
                        }  
                        
                        else if (focus_but == buts.get(2)) {
                            figs.add(new Triangulo(mouse.x,mouse.y, 150,150,Color.white,Color.gray ));
                            
                        }
                        
                        else if (focus_but == buts.get(3)) {
                            figs.add(new Circulo(mouse.x,mouse.y, 50,50,Color.white,Color.gray ));
                             focus_but = null;
                    
                     }
                     
                      else if (focus_but == buts.get(4)) {
                            figs.add(new Quadrado(mouse.x,mouse.y, 50,50,Color.white,Color.gray ));
                             focus_but = null;
                    
                     }
            
                     
                     else if (focus_but == buts.get(5)) {
                            figs.add(new Texto(mouse.x,mouse.y, 50,50,Color.white,Color.gray ));
                             focus_but = null;
                    
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
                    if (focused !=null){
                        int dx = evt.getX() - mouse.x;
                        int dy = evt.getY() - mouse.y;
                        focused.drag(dx, dy);
                        repaint();
                    }
                    mouse = evt.getPoint();
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
                    int h = 150;
        
                    
                    
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
                    
                    else if (evt.getKeyChar() == 'q') {
                        figs.add(new Quadrado(x,y, w,h,Color.white, Color.green));
                        
                    }
                    
                    else if (evt.getKeyChar() == 'x') {
                        figs.add(new Texto(x,y, w,h,Color.white, Color.green));
                        
                    }
                   
                    else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                        figs.remove(focused);}
                    
                    else if (evt.getKeyCode() == KeyEvent.VK_UP){
                            focused.resize(5, 5);
                        }
                    else if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                            focused.resize(-5, -5);
                        }
                    
                   // else if (evt.getKeyCode() == 'd') {
                    //    figs.remove(i);}
                    
                    
                    repaint();
                }
            }
            );  
    }


    public void paint (Graphics g) {
        super.paint(g);
        
        for (Button but: this.buts)  { 
            but.paint(g,but == focus_but);
       }
        for (Figure fig: this.figs) {
            fig.paint(g,fig==focused);

    }
}
}
