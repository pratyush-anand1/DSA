#include <stdio.h>
#include <stdlib.h>

struct stack
{
    int size;
    int top;
    int *arr;
};

int empty(struct stack *ptr)
{
    if (ptr->top == -1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int full(struct stack *ptr)
{
    if (ptr->top == ptr->size - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void push(struct stack *ptr, int value)
{
    if (full(ptr))
    {
        printf("Stack Overflow!Can't push an element");
    }
    else
    {
        printf("Pushing value %d\n", value);
        ptr->top++;
        ptr->arr[ptr->top] = value;
    }
}

int pop(struct stack *s){
    int a=-1;
    if(empty(s)){
        printf("Stack Underflow!");
    }
    else{
        a=s->arr[s->top];
        s->top--;
        return a;
    }
}

int main()
{
    struct stack *s;
    s = (struct stack *)malloc(sizeof(struct stack));
    s->size = 5;
    s->top = -1;
    s->arr = (int *)malloc(s->size * sizeof(int));
    push(s,12);
    push(s,19);
    push(s,22);
    push(s,24);
    push(s,90);
    pop(s);
    return 0;
}