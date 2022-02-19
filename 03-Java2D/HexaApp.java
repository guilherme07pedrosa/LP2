public class HexaApp {
	public static void main (String[] args) {
		Hexa h1 = new Hexa(6,5,4,7,6,7,7,5,6,3,4,3,3,5);
			h1.print();
	}
}
class Hexa {
	int x,y;
	int a,b,c,d,e,f,g,i,j,l,m,n;
	Hexa (int x, int y, int a, int b, int c, int d, int e, int f, int g, int i, int j, int l, int m, int n) {
	this.x = x;
	this.y=y;
	this.a=a;
	this.b=b;
	this.c=c;
	this.d=d;
	this.e=e;
	this.f=f;
	this.g=g;
	this.i=i;
	this.j=j;
	this.l=l;
	this.m=m;
	this.n=n;
	
	}
	void print () {
		System.out.format("Hexagono com centro em  (%d,%d) e vertices em  (%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d). \n",
	 this.x,this.y,this.a,this.b,this.c,this.d,this.e,this.f,this.g,this.i,this.j,this.l,this.m,this.n);
	}
}
