#include <stdio.h>

int main() {
    int N;
    printf("Enter number of employees: ");
    scanf("%d", &N);

    int skills[N];
    int total = 0;

    printf("Enter skill levels:\n");
    for(int i = 0; i < N; i++) {
        scanf("%d", &skills[i]);
        total += skills[i];
    }

    int half = total / 2;

    // DP array
    int dp[half + 1];
    for(int i = 0; i <= half; i++)
        dp[i] = 0;

    dp[0] = 1;

    // Subset sum DP
    for(int i = 0; i < N; i++) {
        for(int j = half; j >= skills[i]; j--) {
            if(dp[j - skills[i]])
                dp[j] = 1;
        }
    }

    // Find closest sum to half
    int best = 0;
    for(int i = half; i >= 0; i--) {
        if(dp[i]) {
            best = i;
            break;
        }
    }

    int difference = total - 2 * best;
    if(difference < 0) difference = -difference;

    printf("%d\n", difference);

    return 0;
}
