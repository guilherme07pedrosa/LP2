
/**
 * Escreva uma descrição da classe PaintApp aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;
    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 50,50);
        this.r2 = new Rect(200,100, 100,70);
        this.r3 = new Rect(100,300, 120,30);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    String cor_de_contorno,cor_de_fundo;
    Rect (int x, int y, int w, int h) {
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
        g2d.setColor(new Color(255,0,0));
        g2d.fillOval(50,50, 50,50);
        g2d.drawOval(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(0,255,0));
        g2d.fillOval(200,100, 100,70);
        g2d.drawOval(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(0,0,0));
        g2d.fillOval(100,300, 120,30);
        g2d.drawOval(this.x,this.y, this.w,this.h);
        
        
       
    }
}