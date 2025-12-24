#include <stdio.h>

int main() {
    int n;
    printf("Enter number of towers: ");
    scanf("%d", &n);

    int heights[100000];
    printf("Enter the heights: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &heights[i]);
    }

    int result[100000];
    int stack[100000];
    int top = -1;

    for (int i = n - 1; i >= 0; i--) {
        while (top >= 0 && stack[top] <= heights[i]) {
            top--;
        }
        if (top == -1) {
            result[i] = -1;
        } else {
            result[i] = stack[top];
        }
        stack[++top] = heights[i];
    }

    for (int i = 0; i < n; i++) {
        printf("%d ", result[i]);
    }

    return 0;
}
