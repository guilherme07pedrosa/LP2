public class RectApp {/*definição classe RecApp*/
    public static void main (String[] args) {/*função principal*/
        Rect r1 = new Rect(1,1, 10,10);/*Criação de um objeto r1 com parâmetros 1,1,10,10 - o programa vai direto para a linha 10 que contem os campos do objeto Rect*/
        r1.print();/*metodo print*/
    }
}
class Rect {
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {/*Construtor da classe - Define  as instâncias do objeto Rect*/
        this.x = x;/*atribui o valor 1 a x*/
        this.y = y;/*atribui o valor 1 a y*/
        this.w = w;/*atribui o valor 10 a w*/
        this.h = h;/*atribui o valor 10 a w* após essa linha o programa volta para a linha 3 e em seguida vai para a linha 4*/
    }
    void print () {/*é invocado o método print e esse método imprime na tela os valores atribuidos a r1*/
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
}
