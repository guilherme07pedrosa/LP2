/* Este programa cria a imagem de um boneco em que a cabeca e uma elipse, os olhos circulos, e cor da liha preta.*/
/* OBS. TENTEI  ALTERAR A COR DE FUNDO MAS NAO CONSEGUI, GOSTARIA DE SABER QUAL FOI O MEU ERRO*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!"); 
        this.setSize(450, 450);
	this.setBackground(Color.BLUE);/*tentativa de alterar a cor de fundo*/
        this.setVisible(true);
	
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);/*cor da linha alterada para preto*/
        int w = getWidth();
        int h = getHeight();
	/*g2d.drawLine(150,150, 300,150);*/
	g2d.drawOval(150,50,150,100);/*cabeca*/
	g2d.drawLine(225,150, 225,300);/*tronco*/
	g2d.drawLine(225,300, w,h);/*perna esquerda*/
        g2d.drawLine(225,300, 0,w);/*perna direita*/
	g2d.drawOval(180,70,20,20);/*OE*/
	g2d.drawOval(255,70,20,20);/*OD*/
	g2d.drawLine(0,225, w,225);/*tronco*/
	g2d.drawLine(200,120, 250,120);/*boca retangular*/
	g2d.drawLine(200,140, 250,140);/*boca retangular*/
	g2d.drawLine(200,120, 200,140);/*boca retangular*/
	g2d.drawLine(250,120, 250,140);/*boca retangular*/
	
	
    }
}
