#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct {
    float r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef float  (* Figure_Area)  (struct Figure*);
typedef float  (* Figure_Regular)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    float  (* area)  (struct Figure*);
    int  (* regular)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    float x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    float w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%.2f,%.2f) na posicao (%.2f,%.2f) e area %.2f logico Regular %d .\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup),sup->vtable->regular(sup));
           if (sup->vtable->regular(sup)==1)
            printf("Figura regular\n");
            else
            printf("Figura nao regular\n");


}

float rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

int rect_regular (Rect* this) {
    Figure* sup = (Figure*) this;
    if ((this->w/this->h)==1)
        return 1;
    else
        return 0;

}


Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Regular) rect_regular,
};

Rect* rect_new (float x, float y, float w, float h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    float w, h;
} Tria;

void tria_print (Tria* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%0.2f,%0.2f) na posicao (%0.2f,%0.2f) e area %0.2f logico regular %d. \n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->regular(sup));
           if (sup->vtable->regular(sup)==1)
            printf("Figura regular\n");
            else
            printf("Figura nao regular\n");
}

float tria_area (Tria* this) {
    Figure* sup = (Figure*) this;
    return((this->w * this->h)/2);
}

int tria_regular (Rect* this) {
    Figure* sup = (Figure*) this;
    if (((this->w/this->h)<=(sqrt(3.01)/2))&&((this->w/this->h)>=(sqrt(2.99)/2)))
        return 1;
    else
        return 0;
}

Figure_vtable tria_vtable = {
    (Figure_Print) tria_print,
    (Figure_Area)  tria_area,
    (Figure_Regular) tria_regular,
};

Tria* tria_new (float x, float y, float w, float h) {
    Tria* this = malloc(sizeof(Tria));
    Figure* sup = (Figure*) this;
    sup->vtable = &tria_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(10,9,100,10),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) tria_new(40,10,140,300),
        (Figure*) tria_new(210,110,sqrt(3)/2,1),
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
