#include <stdio.h>

int main() {
    int n;
    printf("Enter number of parcels: ");
    scanf("%d", &n);

    int arr[10000];
    printf("Enter the parcels: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int sorted[10000];
    int count = 0;

    while (n > 0) {
        // finding min_index
        int min_index = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[min_index]) {
                min_index = i;
            }
        }

        // rotate until min_index comes to front
        for (int i = min_index; i > 0; i--) {
            int temp = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = temp;
        }

        // pick and place
        sorted[count++] = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;
    }

    for (int i = 0; i < count; i++) {
        printf("%d ", sorted[i]);
    }

    return 0;
}
