#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
    int n;
    if (printf("Enter the number of elements in the array: "),  scanf("%d", &n) != 1 || n <= 0) {
        printf("Invalid Input\n");
        return 1;
    }

    int *a = malloc(n * sizeof *a);
    if (!a) {
        printf("Memory allocation failed\n");
        return 1;
    }

    printf("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
        if (scanf("%d", &a[i]) != 1) {
            printf("Invalid Input\n");
            free(a);
            return 1;
        }
    }

    int count = 0;
    printf("The perfect squares are:\n");
    for (int i = 0; i < n; i++) {
        if (a[i] >= 0) {
            int r = (int)(sqrt(a[i]));
            if (r * r == a[i]) {
                printf("%d\n", a[i]);
                count++;
            }
        }
    }
    printf("Total perfect squares: %d\n", count);

    free(a);
    return 0;
}