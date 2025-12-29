#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int arr[1000];
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    int result[1000];
    int size = N;   // current queue size
    int resIndex = 0;

    while (size > 0) {
        // Step 1: find minimum element index
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // Step 2: rotate until min element comes to front
        while (minIndex > 0) {
            int temp = arr[0];
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[size - 1] = temp;
            minIndex--;
        }

        // Step 3: pick the front element (minimum)
        result[resIndex++] = arr[0];

        // Step 4: remove front element
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // Print sorted result
    for (int i = 0; i < resIndex; i++) {
        printf("%d ", result[i]);
    }

    return 0;
}
