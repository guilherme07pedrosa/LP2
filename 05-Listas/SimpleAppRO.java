
/**
 * Escreva uma descrição da classe SimpleAppRO aqui.
 * 
 * @author (Guilherme Pedrosa) 
 * @version (06/02/2022)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class SimpleAppRO {
    public static void main (String[] args) {
        SimpleFrame frame = new SimpleFrame();
        frame.setVisible(true);
    }
}

class SimpleFrame extends JFrame {
    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Oval> os = new ArrayList<Oval>();
    Random rand = new Random();

    SimpleFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.setTitle("Lista de Ovais");
        this.setSize(350, 350);

        for (int i=0; i<4; i++) {
            int x = rand.nextInt(350);
            int y = rand.nextInt(350);
            int w = rand.nextInt(50);
            int h = rand.nextInt(50);
            os.add(new Oval(x,y, w,h));
            rs.add(new Rect(x,y, w,h));
        }
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Oval o: this.os) {
            o.paint(g);
        }
       /* for (Rect r: this.rs) {
            r.paint(g);
        }*/
    }
}


class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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
        System.out.format("Retangulo  de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    
        System.out.format("Oval de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}}
