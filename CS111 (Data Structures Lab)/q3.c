#include<stdio.h>

void swap(int* a, int* b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
 


int binaryserach(int arr[],int n,int key){
    int low=0;
    int high=n-1;
    while(low<=high){
        int mid=(low+high)/2;
        if(arr[mid] == key){
            printf("%d\t",key);
            return 1;
        }
        else if(arr[mid]>key){
           high=mid-1;
        }
        else{
            low=mid+1;
        }
    }
    return 0;
}

int partition (int arr[], int low, int high)
{
    int pivot = arr[high]; 
    int i = (low - 1);
    for (int j = low; j <= high - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main(){
    int arr[]={4,8,9,1,3,6,7,10};
    int n=sizeof(arr)/sizeof(arr[0]);
    int sum=10; 
    int i=0;
    int low = 0;
    quickSort(arr, low ,n-1);
    for(i = 0; i < n; i++){    

         if(binaryserach(arr,n,sum-arr[i])){
            printf("%d\n",arr[i]);
            
        } 
}
    return 0;
}