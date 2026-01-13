#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    int n;
    printf("Enter number of operations: ");
    scanf("%d", &n);

    char ops[1005][20];
    int i;

    printf("Enter the operations:\n");
    for (i = 0; i < n; i++) {
        scanf("%s", ops[i]);
    }

    int stack[2000];
    int top = -1;

    for (i = 0; i < n; i++) {
        if (strcmp(ops[i], "C") == 0) {
            if (top >= 0) top--;
        }
        else if (strcmp(ops[i], "D") == 0) {
            int val = stack[top] * 2;
            stack[++top] = val;
        }
        else if (strcmp(ops[i], "+") == 0) {
            int val = stack[top] + stack[top - 1];
            stack[++top] = val;
        }
        else {
            int num = atoi(ops[i]);
            stack[++top] = num;
        }
    }

    int sum = 0;
    for (i = 0; i <= top; i++) {
        sum += stack[i];
    }

    printf("Total score: %d", sum);

    return 0;
}
