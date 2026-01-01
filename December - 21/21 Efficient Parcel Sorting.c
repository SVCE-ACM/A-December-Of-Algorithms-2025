#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int queue[N];
    for(int i = 0; i < N; i++) {
        scanf("%d", &queue[i]);
    }

    int sorted[N];
    int sortedIndex = 0;
    int size = N;

    while(size > 0) {

        // Step 1: find minimum element
        int minVal = queue[0];
        int minIndex = 0;

        for(int i = 1; i < size; i++) {
            if(queue[i] < minVal) {
                minVal = queue[i];
                minIndex = i;
            }
        }

        // Step 2: rotate queue to bring min to front
        for(int i = 0; i < minIndex; i++) {
            int temp = queue[0];
            for(int j = 0; j < size - 1; j++) {
                queue[j] = queue[j + 1];
            }
            queue[size - 1] = temp;
        }

        // Step 3: pick the front element
        sorted[sortedIndex++] = queue[0];

        // Remove front element
        for(int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        size--;
    }

    // Print sorted output
    for(int i = 0; i < sortedIndex; i++) {
        printf("%d ", sorted[i]);
    }

    return 0;
}
