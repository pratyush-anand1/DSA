#include<stdio.h>
#include<stdlib.h>

struct job
{
    int index;
    int start;
    int end;
};

void sort(struct job data[],int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n-i;j++)
        {
            if(data[j].end >data[j+1].end)
            {
                struct job temp;

                temp.index = data[j].index;
                temp.start = data[j].start;
                temp.end = data[j].end;

                data[j].index =data[j+1].index;
                data[j].start =data[j+1].start;
                data[j].end =data[j+1].end;

                data[j+1].index = temp.index;
                data[j+1].start = temp.start;
                data[j+1].end = temp.end; 
            }
        }
    }
}

int max(int a[],int n)
{
    int max=-111;
    for(int i=0;i<n;i++)
    {
         if(a[i]>max)
         {
            max=a[i];
         } 
    }
    printf("\nElements with most conflicts are: \n");
    for(int i=0;i<n;i++)
    {
        if(a[i]>=max)
        {
            printf("%d ",i+1);
        }
    }
}

int min(int a[],int n)
{
    
    int min=1000;
    for(int i=0;i<n;i++)
    {
         if(a[i]<min)
         {
            min=a[i];
         } 
    }
    printf("\nElemnts with least conflicts are: \n");
    for(int i=0;i<n;i++)
    {
        if(a[i]<=min)
        {
            printf("%d ",i+1);
        }
    }
}



int main()
{
    printf("Enter the number of jobs: ");
    int numberOfJobs;
    scanf("%d",&numberOfJobs);
    printf("\n");
    struct job data[numberOfJobs];
    int count =1;
    for(int i=0;i<numberOfJobs;i++)
    {
        data[i].index =count;
        printf("Enter the starting time of the job %d: ",i+1);
        scanf("%d",&data[i].start);
        printf("Enter the ending time of the job %d: ",i+1);
        scanf("%d",&data[i].end);
        printf("\n");
        count++;
    }
    int conflict[20]={0};
    for(int i=0;i<numberOfJobs;i++){
        printf("For job %d:",i+1);
        printf("Start time:%d\t",data[i].start);
        printf("Finish time:%d\t",data[i].end);
    }
    printf("\n");
    printf("After sorting:\n");
    sort(data,numberOfJobs);
    for(int i=1;i<=numberOfJobs;i++){
        printf("For job %d:",i);
        printf("Start time:%d\t",data[i].start);
        printf("Finish time:%d\t",data[i].end);
    }
    int j=0;
    printf("The jobs that can be scheduled are: \n%d ",(data[j].index));
    for(int i=1;i<numberOfJobs;i++)
    {
        if(data[i].start >=data[j].end)
        {
            printf("%d ",data[i].index);
            j=i;
        }
        else
        {
            conflict[j]++;
        }
    }
    max(conflict,numberOfJobs);
    min(conflict,numberOfJobs);

    return 0;
}