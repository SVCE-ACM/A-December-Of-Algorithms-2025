#include <stdio.h>

int main() {
    int N;
    printf("Enter number of towers: ");
    scanf("%d", &N);

    int heights[N];
    printf("Enter tower heights:\n");
    for(int i = 0; i < N; i++) {
        scanf("%d", &heights[i]);
    }

    int stack[N];   // stack to store heights
    int top = -1;
    int result[N];

    // Traverse from right to left
    for(int i = N - 1; i >= 0; i--) {

        // Remove smaller or equal elements
        while(top != -1 && stack[top] <= heights[i]) {
            top--;
        }

        // If stack empty, no taller tower
        if(top == -1)
            result[i] = -1;
        else
            result[i] = stack[top];

        // Push current height
        stack[++top] = heights[i];
    }

    // Print result
    for(int i = 0; i < N; i++) {
        printf("%d ", result[i]);
    }

    return 0;
}
