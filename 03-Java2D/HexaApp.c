#include <stdio.h>
 
typedef struct {
	int x,y;
	int a,b;
	int c,d;
	int e,f;
	int g,i;
	int j,l;
	int m,n;
} Hexa ;

void print (Hexa* h) {
	printf("Hexagono com centro em  (%d,%d) e vertices em  (%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d). \n",
	 h->x,h->y,h->a,h->b,h->c,h->d,h->e,h->f,h->g,h->i,h->j,h->l,h->m,h->n);
}
void main (void) {
	Hexa h1 = {6,5,4,7,6,7,7,5,6,3,4,3,3,5};
	print(&h1);
}