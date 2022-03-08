/**
 * Escreva uma descrição da classe ListAppOval aqui.
 * 
 * @author (Guilherme Pedrosa) 
 * @version (06/03/2022)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class ListAppOval {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Oval> os = new ArrayList<Oval>();
   
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(1000);
                        int y = rand.nextInt(1000);
                        int w = rand.nextInt(100);
                        int h = rand.nextInt(200);
                        os.add(new Oval(x,y, w,h));
                        repaint();  // outer.repaint()
                    
                    }
                }
            }
        );

        this.setTitle("Lista de Elipses");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Oval o: this.os) {
            o.paint(g);
        };
        
        
        
        
        
    }
}

class Oval {
    int x, y;
    int w, h;

    Oval (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(0,255,0));
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
