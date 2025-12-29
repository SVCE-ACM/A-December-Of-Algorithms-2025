#include <stdio.h>

int main() {
    int arr[30], n, size;

    // Input size
    scanf("%d", &size);

    // Input elements
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    // Input n (nth from end)
    scanf("%d", &n);

    // Find index to remove
    int index = size - n;

    // Shift elements
    for (int i = index; i < size - 1; i++) {
        arr[i] = arr[i + 1];
    }

    size--;  // reduce size

    // Print result
    if (size == 0) {
        printf("[]");
    } else {
        for (int i = 0; i < size; i++) {
            printf("%d ", arr[i]);
        }
    }

    return 0;
}
