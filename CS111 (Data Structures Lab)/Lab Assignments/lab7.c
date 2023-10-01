#include<stdio.h>

void swap(int *a,int *b){
    int temp=*a;
    *a=*b;
    *b=temp;
}

void minheapify(int arr[],int n,int i){
    int smallest=i;
    int l=2*i+1, r=2*i+2;
    if(l < n && arr[l] < arr[smallest]){
        smallest=l;
    }
    if(r < n && arr[r] < arr[smallest]){
        smallest=r;
    }
    if(smallest!=i){
        swap(&arr[i],&arr[smallest]);
        minheapify(arr,n,smallest);
    }
}

void buildheap(int arr[],int n){
    int index=(n/2)-1;
    for(int i=index;i>=0;i--){
        minheapify(arr,n,i);
    }
}

void heapsort(int arr[],int n){
    for (int i = n - 1; i >= 0; i--) {
        swap(&arr[0], &arr[i]);
        minheapify(arr,i,0);
    }
}

int main(){
    int arr[]={65,87,43,56,21,89,92,37,71};
    int n=sizeof(arr)/sizeof(int);int k; 
    buildheap(arr,n);
    printf("Enter the value of k:");
    scanf("%d",&k);
    heapsort(arr,n);
    printf("The element is %d",arr[n-k]);  
    return 0;
}