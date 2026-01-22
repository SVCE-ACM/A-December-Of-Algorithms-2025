#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    int n;
    printf("Enter number of operations: ");
    scanf("%d", &n);

    char ops[1000][10];
    printf("Enter the operations:\n");
    for (int i = 0; i < n; i++) {
        scanf("%s", ops[i]);
    }

    int scores[1000];
    int top = 0; // number of valid scores in stack

    for (int i = 0; i < n; i++) {
        if (strcmp(ops[i], "C") == 0) {
            if (top > 0) top--;  // remove last score
        }
        else if (strcmp(ops[i], "D") == 0) {
            if (top > 0) {
                scores[top] = 2 * scores[top - 1];  // double last score
                top++;
            }
        }
        else if (strcmp(ops[i], "+") == 0) {
            if (top >= 2) {
                scores[top] = scores[top - 1] + scores[top - 2];  // sum last two scores
                top++;
            }
        }
        else {
            scores[top] = atoi(ops[i]);  // convert string to integer
            top++;
        }
    }

    int sum = 0;
    for (int i = 0; i < top; i++) {
        sum += scores[i];
    }

    printf("Total score: %d\n", sum);

    return 0;
}
