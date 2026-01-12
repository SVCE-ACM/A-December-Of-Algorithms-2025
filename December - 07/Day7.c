#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int n;
    scanf("%d", &n);

    char op[20];
    int stack[1000];
    int top = -1;

    for (int i = 0; i < n; i++) {
        scanf("%s", op);

        if (strcmp(op, "C") == 0) {
            top--;
        }
        else if (strcmp(op, "D") == 0) {
            stack[++top] = 2 * stack[top];
        }
        else if (strcmp(op, "+") == 0) {
            stack[++top] = stack[top] + stack[top - 1];
        }
        else {
            stack[++top] = atoi(op);
        }
    }

    int totalScore = 0;
    for (int i = 0; i <= top; i++) {
        totalScore += stack[i];
    }

    printf("%d", totalScore);
    return 0;
}
