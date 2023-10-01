#include<stdio.h>

void swap(int *a,int *b){
    int temp=*a;
    *a=*b;
    *b=temp;
}

//Insertion Sort

int insertionSort(int arr[], int n)
{
    int  swap1 = 0;
	for (int i = 1; i < n; i++) {
		int key = arr[i];
		int j = i - 1;

		while (j >= 0 && arr[j] > key) {
			arr[j + 1] = arr[j];
            swap1++;
			j = j - 1;
            arr[j + 1] = key;
	}
        
}
 return swap1;
}

//Selection sort

int selectionsort(int arr[],int n){
    int swap3 = 0;
    int min;
    for(int i = 0; i < n-1; i++){
        min = i;
        for(int j=i+1;j<n;j++){
            if(arr[j] < arr[min]){
                min=j;
                swap(&arr[min],&arr[i]);
                swap3++;
            }
        } 
    }
return swap3;
}

//Bubble sort

int bubbleSort(int arr[], int n){
    int swap2 = 0;
    int i, j;
    for (i = 0; i < n - 1 ; i++){
        for (j = 0; j < n - i - 1; j++){
            if(arr[j] > arr[j + 1]){
                swap(&arr[j], &arr[j + 1]);
                swap2++;
        }
     }
}
    return swap2;
}

//Quick sort

int partition (int arr[], int low, int high, int *b)
{
    int pivot = arr[high]; 
   
    int i = (low - 1);
 
    for (int j = low; j <= high - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++; 
            swap(&arr[i], &arr[j]);
           *b = *b + 1;
        }
    
    swap(&arr[i + 1], &arr[high]);
    *b = *b + 1;
    
    return (i + 1);
}
}

void quickSort(int arr[], int low, int high, int *a)
{static int b = 0;

    if (low < high){
    
        int pi = partition(arr, low, high,&b);
        quickSort(arr, low, pi - 1,a);
        quickSort(arr, pi + 1, high,a);

    }

    *a=b;
}





 
    
    
int main(){
    int a;
    int arr1[]={1,2,3,4};
    int arr2[]={1,2,3,4};
    int arr3[]={1,2,3,4};
    int arr4[]={1,2,8,4};
    int low = 0;
    int n = 4;
    int b = insertionSort(arr1,n);
    int c = selectionsort(arr2,n);
    int d = bubbleSort(arr3, n);
    quickSort(arr4,low,n ,&a);
    
    if(a < b && a < c && a < d){
        printf("quick sort");
    
    }else if(b < a && b < c && b < d){
        printf("insertion sort");

    }else if(c < a && c <b && c < d){
        printf("selection sort");
    }else{
        printf("bubble sort");
    }
    return 0;
}