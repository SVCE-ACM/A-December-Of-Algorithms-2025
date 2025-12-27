#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> skills(N);
    int totalSum = 0;

    for (int i = 0; i < N; i++) {
        cin >> skills[i];
        totalSum += skills[i];
    }

    vector<bool> dp(totalSum + 1, false);
    dp[0] = true;

    for (int skill : skills) {
        for (int s = totalSum; s >= skill; s--) {
            dp[s] = dp[s] || dp[s - skill];
        }
    }

    int minDiff = INT_MAX;

    for (int s = 0; s <= totalSum / 2; s++) {
        if (dp[s]) {
            minDiff = min(minDiff, abs(totalSum - 2 * s));
        }
    }

    cout << minDiff;
    return 0;
}
