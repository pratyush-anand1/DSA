#include<stdio.h>

void swap(int* a, int* b)
{
    int temp = *a;
    *a = *b;
    *a = temp;
}

int insertionSort(int arr[], int n)
{
    int swap1=0;
    int i, key, j;
    for (i = 1; i < n; i++) {
        key = arr[i];
        j = i - 1;
 
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
            swap1++;
        }
        arr[j + 1] = key;
    }
    return swap1;
}

int bubbleSort(int arr[], int n)
{
    int swap2=0;
    int i, j;
    for (i = 0; i < n - 1; i++){
        for (j = 0; j < n - i - 1; j++){
            if (arr[j] > arr[j + 1]){
                swap(&arr[j], &arr[j + 1]);}
                swap2++;}}
    return swap2;
}
 
int selectionsort(int arr[],int n){
    int swap3=0;
    int min;
    for(int i=0;i<n-1;i++){
        min=i;
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[min]){
                min=j;
                swap(&arr[min],&arr[i]);
                swap3++;
            }
        }
    }
    return swap3;
}
 

int main(){
    int arr[]={2,6,8,1,6,1,7,5,8,3};
    int n=sizeof(arr)/sizeof(arr[0]);
    

    printf("%d",selectionsort(arr,n));
    return 0;
}