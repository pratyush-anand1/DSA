// copy one linled list to another

#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
};

struct node *copy(struct node *head)
{
    if (head == NULL)
    {
        return NULL;
    }
    else
    {
        struct node *dup = (struct node *)malloc(sizeof(struct node));
        dup->data = head->data;
        dup->next = copy(head->next);
        return dup;
    }
}

void access(struct node *ptr)
{
    while (ptr != NULL)
    {
        printf("%d\t", ptr->data);
        ptr = ptr->next;
    }
}
int main()
{
    struct node *head;
    struct node *second;
    struct node *third;
    head = (struct node *)malloc(sizeof(struct node));
    second = (struct node *)malloc(sizeof(struct node));
    third = (struct node *)malloc(sizeof(struct node));
    head->data = 7;
    head->next = second;
    second->data = 8;
    second->next = third;
    third->data = 9;
    third->next = NULL;
    printf("Original list:\n");
    access(head);
    struct node *dup=copy(head);
    printf("Duplicate list:\n");
    access(dup);
    return 0;
}