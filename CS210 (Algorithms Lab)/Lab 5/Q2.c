#include<stdio.h>
#include<math.h>

void sort(int calories[],int n){ 
    for(int i = 0; i < n-1; i++)
    {
        int max = i;
        for (int j = i+1; j < n; j++)
            if(calories[j] > calories[max]){
                max = j;
            }
        int temp = calories[max];
        calories[max] = calories[i];
        calories[i] = temp;
    }
}

int main(){
    int n;
    printf("Enter the number of cupcakes:");
    scanf("%d",&n);
    int calories[n];
    printf("Enter the calories of the respective cupcakes:");
    for(int i=0;i<n;i++){
        scanf("%d",&calories[i]);
    }
    sort(calories,n);
    int miles=0;
    for(int i=0;i<n;i++){
        miles+=pow(2,i)*calories[i];
    }
    printf("Marc needs to walk atleast %d miles",miles);
    return 0;
}