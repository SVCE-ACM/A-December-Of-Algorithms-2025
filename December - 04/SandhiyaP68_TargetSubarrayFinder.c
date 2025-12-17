#include <stdio.h>

int main() {
    int N;
    long long K;
    long long arr[100000];
    long long prefixSum[100000];
    int index[100000];

    printf("Enter N : ");
    scanf("%d",&N);
    printf("Enter K: ");
    scanf("%lld",&K);

    printf("Enter array elements:\n");
    for (int i = 0; i < N; i++) {
        scanf("%lld", &arr[i]);
    }

    long long currSum = 0;
    int found = 0;
    int start = -1, end = -1;
    int size = 0;

    for (int i = 0; i < N; i++) {
        currSum += arr[i];

        /* Case 1: subarray from 0 */
        if (currSum == K) {
            start = 0;
            end = i;
            found = 1;
            break;
        }

        /* Case 2: check previous prefix sums */
        for (int j = 0; j < size; j++) {
            if (prefixSum[j] == currSum - K) {
                start = index[j] + 1;
                end = i;
                found = 1;
                break;
            }
        }

        if (found)
            break;

        /* store prefix sum */
        prefixSum[size] = currSum;
        index[size] = i;
        size++;
    }

    if (found)
        printf("%d %d\n", start, end);
    else
        printf("-1 -1\n");

    return 0;
}
