#include <stdio.h>
int min4(int a, int b, int c, int d)
{
    int A[4];
    A[0] = a;
    A[1] = b;
    A[2] = c;
    A[3] = d;
    int min = A[0];
    for (int i = 0; i < 4; i++)
    {
        if (A[i] < min)
            min = A[i];
    }
    return min;
}

void merge(int a[], int lo, int p1, int p2, int p3, int hi)
{

    int n1 = p1 - lo + 1;
    int n2 = p2 - p1;
    int n3 = p3 - p2;
    int n4 = hi - p3;
    int A[n1 + 1], B[n2 + 1], C[n3 + 1], D[n4 + 1];
    for (int i = 0; i < n1; i++)
    {
        A[i] = a[lo + i];
    }
    for (int i = 0; i < n2; i++)
    {
        B[i] = a[p1 + 1 + i];
    }
    for (int i = 0; i < n3; i++)
    {
        C[i] = a[p2 + 1 + i];
    }
    for (int i = 0; i < n4; i++)
    {
        D[i] = a[p3 + 1 + i];
    }
    int p = 0, q = 0, r = 0, s = 0;

    A[n1] = 100000;
    B[n2] = 100000;
    C[n3] = 100000;
    D[n4] = 100000;

    int k = lo;
    while (k <= hi)
    {

        a[k] = min4(A[p], B[q], C[r], D[s]);
        if (a[k] == A[p])
        {
            k++;
            p++;
        }
        else if (a[k] == B[q])
        {
            k++;
            q++;
        }
        else if (a[k] == C[r])
        {
            k++;
            r++;
        }
        else if (a[k] == D[s])
        {
            k++;
            s++;
        }
    }
}
void merge_sort(int A[], int lo, int hi)
{
    if (lo < hi)
    {
        int p2 = (lo + hi) / 2;
        int p1 = (lo + p2) / 2;
        int p3 = ((p2 + 1 + hi)) / 2;

        merge_sort(A, lo, p1);
        merge_sort(A, p1 + 1, p2);
        merge_sort(A, p2 + 1, p3);
        merge_sort(A, p3 + 1, hi);
        merge(A, lo, p1, p2, p3, hi);
    }
}

int main()
{
    int A[] = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    merge_sort(A, 0, 15);
    for (int i = 0; i < 16; i++)
    {
        printf("%d ", A[i]);
    }
}