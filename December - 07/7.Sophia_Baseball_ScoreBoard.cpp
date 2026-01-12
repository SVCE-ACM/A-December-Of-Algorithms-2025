#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    int n;
    printf("Enter number of operations: ");
    scanf("%d", &n);

    char ops[n][10];   //n strings, each string up to 9 characters long
    
    printf("Enter the operations:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%s", ops[i]);
    }

    int scores[n];     
    int top = -1;      

    for (int i = 0; i < n; i++)
    {
        
        if (strcmp(ops[i], "C") == 0)
        {
            top--;   
        }
        else if (strcmp(ops[i], "D") == 0)
        {
            int doubled = 2 * scores[top];
            scores[++top] = doubled;
        }
        else if (strcmp(ops[i], "+") == 0)
        {
            int sum = scores[top] + scores[top - 1];
            scores[++top] = sum;
        }
        else
        {
            int value = atoi(ops[i]); 
            scores[++top] = value;
        }
    }

    int total = 0;
    for (int i = 0; i <= top; i++)
    {
        total += scores[i];
    }

    printf("Final Score = %d\n", total);

    return 0;
}

