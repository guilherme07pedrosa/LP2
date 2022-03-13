/* Esse  programa vai adicionar ao exemplo do professor as figuras Triangulo e Linha - Figuras estas criadas no
exercicio de similar em java*/

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    /*Color fg, bg;*/
    void (* print) (struct Figure*);
} Figure;

/////////////////////////////////////////////////////////////////////////////
/* Retangulo*/
typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de altura e largura (%d,%d) e as diagonais se cruzam no ponto (%d,%d) .\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////
/*Elipse*/
typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de altura e largura (%d,%d) e centro no ponto (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////
/*Reta*/
typedef struct {
    Figure super;
    int w, h;
} Line;

void Line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Reta definida com as seguintes coordenadas no plano  (%d,%d)\n(%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Line* Line_new (int x, int y, int w, int h) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Line_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}
/////////////////////////////////////////////////////////////////////////////////////
/*Triangulo*/
typedef struct {
    Figure super;
    int w,h,a,b;
} Triangle;

void Triangle_print (Triangle* this){
    Figure* sup = (Figure*) this;
    printf("Triangulo localizado no plano cartesiano com as seguintes coordenadas x,y \n(%d,%d)\n(%d,%d)\n(%d,%d).\n ",
          this->w, this->h, this->a, this->b, sup->x, sup->y);

}

Triangle* Triangle_new (int x, int y, int a, int b, int w, int h ) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangle_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->a = a;
    this->b = b;
}






void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) Line_new(10,10,100,100),
        (Figure*) Triangle_new(210,110,305,130,20,30)
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
