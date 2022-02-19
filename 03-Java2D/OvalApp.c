#include <stdio.h>
 
typedef struct {
	int x,y;
	int w,h;
} Oval ;

void print (Oval* o) {
	printf("elipse com foco nos pontos (%d,%d), altura(%d) e largura (%d). \n", o->w,o->h,o->x,o->y);
}
void main (void) {
	Oval o1 = {2,2,5,5};
	print(&o1);
}
