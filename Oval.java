public class OvalApp {
	public static void main (String[] args) {
		Oval o1 = new Oval(2,2,5,5);
			o1.print();
	}
}
class Oval {
	int x,y;
	int w,h;
	Oval (int x, int y, int w, int h) {
	this.x = x;
	this.y=y;
	this.w=w;
	this.h=h;
	}
	void print () {
		System.out.format("elipse de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
	}
}
