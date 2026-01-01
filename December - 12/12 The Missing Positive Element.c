#include <stdio.h>
#include <stdlib.h>

int main() {
    int N;
    printf("Enter N: ");
    scanf("%d", &N);

    int arr[N];
    printf("Enter the elements:\n");
    for(int i=0; i<N; i++) {
        scanf("%d", &arr[i]);
    }

    int duplicate = -1;
    int missing = -1;

    // Mark visited numbers by making arr[num-1] negative
    for(int i=0; i<N; i++) {
        int num = abs(arr[i]);
        if(arr[num-1] < 0) {
            duplicate = num;  // already negative → duplicate
        } else {
            arr[num-1] = -arr[num-1];
        }
    }

    // Find the missing number
    for(int i=0; i<N; i++) {
        if(arr[i] > 0) {
            missing = i + 1;
            break;
        }
    }

    printf("Missing Number: %d\n", missing);
    printf("Duplicate Number: %d\n", duplicate);

    return 0;
}
