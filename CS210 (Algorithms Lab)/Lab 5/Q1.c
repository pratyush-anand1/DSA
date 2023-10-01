#include<stdio.h>

struct coin
{
    int v;int c;
};

void merge(struct coin A[],int mid,int lo,int hi)
{
    int i=lo,j=mid+1,copyAmt=lo;
    struct coin B[100];
    while(i<=mid && j<=hi)
    {
        if(A[i].v>A[j].v)
        {
            B[copyAmt]=A[i];
            i++;copyAmt++;
        }
        else
        {
            B[copyAmt]=A[j];
            j++;copyAmt++;
        }
    }
    while(i<=mid)
    {
        B[copyAmt]=A[i];
        copyAmt++;i++;
    }
    while(j<=hi)
    {
        B[copyAmt]=A[j];
        j++;copyAmt++;
    }
    for(int w=lo;w<=hi;w++) A[w]=B[w];

}
void mergesort(struct coin A[],int lo,int hi)
{
   
   if(lo<hi)
   {
    int mid=(lo+hi)/2;
    mergesort(A,lo,mid);
    mergesort(A,mid+1,hi);
    merge(A,mid,lo,hi);
   }
}

int main()
{    
    int amt;
    printf("Enter the amount you want to change:");
    scanf("%d",&amt);
    int copyAmt=amt;
    int n;
    printf("Enter number of denominations:");
    scanf("%d",&n);
   struct coin deno[n];
   printf("Enter the denominatons:");
   for(int i=0;i<n;i++)
   {
    scanf("%d",&deno[i].v);
    deno[i].c=0;
   }
    mergesort(deno,0,n-1);

    int i=0;
    while(copyAmt>=0)
    {
        if(copyAmt==0) 
        {
            break;
        }
        if(copyAmt<deno[n-1].v){
            break;
        }
        if(copyAmt>=deno[i].v)
        {
            copyAmt=copyAmt-deno[i].v;
            deno[i].c++;
        }
        else i++;
    }
    if(copyAmt==0)
    {
        printf("%d = ",amt);
        for(int i=0;i<n-1;i++)
        {
            printf("%dX%d+",deno[i].v,deno[i].c);
        }
        printf("%dX%d",deno[n-1].v,deno[n-1].c);
    }
    else 
    {
        printf("cannot be distributed \n");
    }
    return 0;
}