/*Write a C program to create a music playlist application using appropriate data structure.
Your application should support the following functionalities:
(a) play next song
(b) play previous song
(c) Each time you play the last song, the next time when you start the playlist, you want
to play it again as the first song. Note that you want to play that particular song only
once while playing the music playlist.*/

#include<stdio.h>
#include<stdlib.h>

struct node{
  int data;
  struct node *next;
  struct node *prev;
};

struct node *current;

struct node * nextsong(struct node *current){
    printf("Playing song %d\n",current->data);
    current=current->next;
    return current;
   
}

struct node * prevsong(struct node *current,struct node *head){
    struct node *ptr=head;
    while(ptr->next->next!=current){
        ptr=ptr->next;
    }
    ptr=ptr->next;
    printf("Playing song %d\n",ptr->data);
    current=ptr;
    return current;
}

struct node * playsong(struct node *head){
    printf("Playlist starting from beginning\n");
    int a;
    struct node *current=head;
    while(1){
        printf("Press 1 for next song and 0 for previous song and 2 to exit:");
        scanf("%d",&a);
        if(a==1){
            current=nextsong(current);
            continue;
        }
        else if(a==0){
            current=prevsong(current,head);
            continue;
        }
        else if(a==2){
            break;
        }
        else{
            printf("Invalid input!Try again\n");
            continue;
        }
    }
}

int main(){
    struct node *head=(struct node *)malloc(sizeof(struct node));
    struct node *first=(struct node *)malloc(sizeof(struct node));
    struct node *second=(struct node *)malloc(sizeof(struct node));
    struct node *third=(struct node *)malloc(sizeof(struct node));
    struct node *fourth=(struct node *)malloc(sizeof(struct node));
    head->data=1;first->data=2;second->data=3;third->data=4;fourth->data=5;
    head->next=first;
    first->next=second;
    second->next=third;
    third->next=fourth;
    fourth->next=head;
    playsong(head);
}