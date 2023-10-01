#include<stdio.h>

void swap(int *a,int *b){
    int temp=*a;
    *a=*b;
    *b=temp;
}

void maxheapify(int arr[],int n,int i){
    int largest=i;
    int l=2*i+1, r=2*i+2;
    if(l < n && arr[l] > arr[largest]){
        largest=l;
    }
    if(r < n && arr[r] > arr[largest]){
        largest=r;
    }
    if(largest!=i){
        swap(&arr[i],&arr[largest]);
        maxheapify(arr,n,largest);
    }
}

void buildheap(int arr[],int n){
    int index=(n/2)-1;
    for(int i=index;i>=0;i--){
        maxheapify(arr,n,i);
    }
}

void heapsort(int arr[],int n){
    for (int i = n - 1; i >= 0; i--) {
        swap(&arr[0], &arr[i]);
    maxheapify(arr,i,0);
    }
} 

int main(){
    int arr1[]={43,78,12,45,87,62};
    int arr2[]={36,81,23,54,76,91};
    int n1=sizeof(arr1)/sizeof(int); 
    int n2=sizeof(arr2)/sizeof(int);
    buildheap(arr1,n1);buildheap(arr2,n2);
    heapsort(arr1,n1);heapsort(arr2,n2);
    printf("Largest pairs from 2 arrays:\n");
    for(int i=n1-1;i>=0;i--){
        printf("%d %d\n",arr1[i],arr2[i]);
    }
    return 0;
}