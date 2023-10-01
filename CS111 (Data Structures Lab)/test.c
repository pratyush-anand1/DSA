#include<stdio.h>

//Insertion Sort
void swap(int *a,int *b){
    int temp=*a;
    *a=*b;
    *b=temp;
}

int insertionSort(int arr[], int n)
{
    int  swap1 = 0;
	for (int i = 1; i < n; i++) {
		int key = arr[i];
		int j = i - 1;

		while (j >= 0 && arr[j] > key) {
			arr[i + 1] = arr[i];
            swap1++;
			j = j - 1;
            arr[j + 1] = key;
	}
}  
 return swap1;    
}
 int main(){
    int arr[]={4,9,12,1};
    int n = 4;
   /* selectionsort(arr,n);
    printf("Sorted array is:\n");
    for(int i=0;i<n;i++){
        printf("%d\t",arr[i]);
    }*/
    printf("%d\t",insertionSort(arr,n));

    return 0;

}

