#include <stdio.h>
#include <stdlib.h>

typedef struct {
    long long sum;
    int index;
} Pair;

int main() {
    int N;
    long long K;
    scanf("%d %lld", &N, &K);

    long long arr[N];
    for (int i = 0; i < N; i++)
        scanf("%lld", &arr[i]);

    Pair *map = malloc((N + 1) * sizeof(Pair));
    int mapSize = 0;

    long long prefixSum = 0;
    map[mapSize++] = (Pair){0, -1};

    for (int i = 0; i < N; i++) {
        prefixSum += arr[i];

        for (int j = 0; j < mapSize; j++) {
            if (map[j].sum == prefixSum - K) {
                printf("%d %d", map[j].index + 1, i);
                free(map);
                return 0;
            }
        }

        map[mapSize++] = (Pair){prefixSum, i};
    }

    printf("-1 -1");
    free(map);
    return 0;
}
