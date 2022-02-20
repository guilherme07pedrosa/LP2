1	public class RectApp {
2	    public static void main (String[] args) {
3	        Rect r1 = new Rect(1,1, 10,10);
4	        r1.print();
5	    }
6	}
7	class Rect {
8	    int x, y;
9	    int w, h;
10	    Rect (int x, int y, int w, int h) {
11	        this.x = x;
12	        this.y = y;
13	        this.w = w;
14	        this.h = h;
15	    }
16	    void print () {
17	        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
18	            this.w, this.h, this.x, this.y);
19	    }
20	}