#include <stdio.h>
#include <stdlib.h>
#include <math.h>
typedef struct point
{
    int x;
    int y;
    int id;
    struct point *next;
} Point;
struct pair
{
    Point p1;
    Point p2;
    float dist;
};
float min(float a, float b)
{
    if (a > b)
        return b;
    else
        return a;
}
float dist(Point p1, Point p2)
{
    return sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y));
}
void merge_x(struct point A[], int mid, int lo, int hi)
{
    int i = lo, j = mid + 1, k = lo;
    struct point B[100];
    while (i <= mid && j <= hi)
    {
        if (A[i].x < A[j].x)
        {
            B[k] = A[i];
            i++;
            k++;
        }
        else
        {
            B[k] = A[j];
            j++;
            k++;
        }
    }
    while (i <= mid)
    {
        B[k] = A[i];
        k++;
        i++;
    }
    while (j <= hi)
    {
        B[k] = A[j];
        j++;
        k++;
    }
    for (int w = lo; w <= hi; w++)
        A[w] = B[w];
}
void mergesort_x(struct point A[], int lo, int hi)
{

    if (lo < hi)
    {
        int mid = (lo + hi) / 2;
        mergesort_x(A, lo, mid);
        mergesort_x(A, mid + 1, hi);
        merge_x(A, mid, lo, hi);
    }
}
void merge_y(struct point A[], int mid, int lo, int hi)
{
    int i = lo, j = mid + 1, k = lo;
    struct point B[100];
    while (i <= mid && j <= hi)
    {
        if (A[i].y < A[j].y)
        {
            B[k] = A[i];
            i++;
            k++;
        }
        else
        {
            B[k] = A[j];
            j++;
            k++;
        }
    }
    while (i <= mid)
    {
        B[k] = A[i];
        k++;
        i++;
    }
    while (j <= hi)
    {
        B[k] = A[j];
        j++;
        k++;
    }
    for (int w = lo; w <= hi; w++)
        A[w] = B[w];
}
void mergesort_y(struct point A[], int lo, int hi)
{

    if (lo < hi)
    {
        int mid = (lo + hi) / 2;
        mergesort_y(A, lo, mid);
        mergesort_y(A, mid + 1, hi);
        merge_y(A, mid, lo, hi);
    }
}
struct pair *ClosestPair(Point Px[], Point Py[], int lo, int hi)
{
    int n = hi - lo + 1;
    // printf("n is %d\n",n);
    if (n == 2)
    {
        struct pair *a = malloc(sizeof(struct pair));
        a->p1 = Px[lo];
        a->p2 = Px[hi];
        a->dist = dist(Px[lo], Px[hi]);
        // printf("base case when n is %d\n",n);
        // printf("%f\n",a->dist);
        return a;
    }
    else if (n == 3)
    {
        int a = dist(Px[lo], Px[lo + 1]), b = dist(Px[lo + 1], Px[hi]), c = dist(Px[lo], Px[hi]);
        struct pair *r = malloc(sizeof(struct pair));
        // printf("base case when n=%d\n",n);
        if (a < b && a < c)
        {
            r->p1 = Px[lo];
            r->p2 = Px[lo + 1];
            r->dist = dist(Px[lo], Px[lo + 1]);
            return r;
        }
        else if (b < c && b < a)
        {
            r->p1 = Px[lo + 1];
            r->p2 = Px[hi];
            r->dist = dist(Px[lo + 1], Px[hi]);
            return r;
        }
        else if (c < a && c < b)
        {
            r->p1 = Px[lo + 1];
            r->p2 = Px[hi];
            r->dist = dist(Px[lo + 1], Px[hi]);
            return r;
        }
    }
    else
    {
        int mid = (lo + hi) / 2;
        // printf("mid is %d\n",mid);
        struct pair *l = ClosestPair(Px, Py, lo, mid);
        struct pair *r = ClosestPair(Px, Py, mid + 1, hi);
        struct pair *k = malloc(sizeof(struct pair));

        float d = min(l->dist, r->dist);
        if (l->dist < r->dist)
        {
            k->p1 = l->p1;
            k->p2 = l->p2;
            k->dist = l->dist;
        }
        else if (l->dist > r->dist)
        {
            k->p1 = r->p1;
            k->p2 = r->p2;
            k->dist = r->dist;
        }
        for (int i = lo; i <= mid; i++)
        {
            Px[i].id = -1;
        }
        for (int i = mid + 1; i <= hi; i++)
        {
            Px[i].id = -2;
        }
        // printf("d is %f\n",d);

        // for(int i=lo;i<=hi;i++)
        // {
        //     if(Px[i].x<Px[mid].x+d && Px[i].x>Px[mid].x-d )
        //     {
        //        Px[i].next=NULL;
        //        struct point *p=head;
        //        if(p==NULL)
        //        {
        //         p=&Px[i];
        //        }
        //        else
        //        {
        //        while(p->next!=NULL)
        //        {
        //         p=p->next;
        //        }
        //        p->next=&Px[i];
        //        }

        //     }
        // }
        struct point *head = NULL;
        for (int i = 0; i < n; i++)
        {
            if (Py[i].x < Px[mid].x + d && Py[i].x > Px[mid].x - d)
            {
                Py[i].next = NULL;
                struct point *p = head;
                if (p == NULL && head == NULL)
                {
                    p = &Py[i];
                    head = p;
                }
                else
                {
                    while (p->next != NULL)
                        p = p->next;
                    p->next = &Py[i];
                }
            }
        }
        // printf("link is created\n");
        //  struct point *o=head;
        //  while(o!=NULL)
        //  {
        //      printf("%d\n",o->x);
        //      o=o->next;
        //  }
        struct point *q = head;

        while (q != NULL)
        {
            struct point *r = q->next;
            for (int i = 0; i < 7; i++)
            {
                // printf("i is %d\n",i);
                if (r != NULL)
                {
                    // printf("d %f\n",d);
                    // printf("dist is %f\n",dist(*q,*r));
                    // printf("x cood of r is %d\n",r->x);
                    if (dist(*q, *r) < d)
                    {

                        // printf("dist is %f\n",dist(*q,*r));
                        d = dist(*q, *r);
                        k->p1 = *q;
                        k->p2 = *r;
                        k->dist = dist(*q, *r);
                        // printf("got\n");
                    }
                    r = r->next;
                }
            }

            q = q->next;
        }

        return k;
    }
}

int main()
{
    // printf("this is main\n");
    struct point P[6];
    P[0].x = 2;
    P[0].y = 3;
    P[0].id = 1;
    P[1].x = 12;
    P[1].y = 30;
    P[1].id = 1;
    P[2].x = 40;
    P[2].y = 50;
    P[2].id = 1;
    P[3].x = 5;
    P[3].y = 1;
    P[3].id = 1;
    P[4].x = 12;
    P[4].y = 10;
    P[4].id = 1;
    P[5].x = 3;
    P[5].y = 4;
    P[5].id = 1;
    struct point Px[6];
    struct point Py[6];
    for (int i = 0; i < 6; i++)
    {
        Px[i] = P[i];
        Py[i] = P[i];
    }
    mergesort_x(Px, 0, 5);
    mergesort_y(Py, 0, 5);

    struct pair *k = ClosestPair(Px, Py, 0, 5);
    printf(" min dist is %f\n", k->dist);
    printf("point 1 is (%d,%d)", (k->p1).x, (k->p1).y);
    printf("point 2 is (%d,%d)", (k->p2).x, (k->p2).y);
    return 0;
}