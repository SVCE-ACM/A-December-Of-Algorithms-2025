#include <iostream>
#include <vector>
#include <numeric>
using namespace std;

int main() {
    int N;
    cout << "Enter number of employees: ";
    cin >> N;

    vector<int> skills(N);
    cout << "Enter skill levels: ";
    for (int i = 0; i < N; i++) cin >> skills[i];
    int totalSum = accumulate(skills.begin(), skills.end(), 0);

    vector<bool> dp(totalSum + 1, false);
    dp[0] = true;

    for (int skill : skills) {
        for (int j = totalSum; j >= skill; j--) {
            dp[j] = dp[j] || dp[j - skill];
        }
    }

    int diff = totalSum;

    for (int s = 0; s <= totalSum / 2; s++) {
        if (dp[s]) {
            diff = min(diff, totalSum - 2 * s);
        }
    }
    cout << "Minimum difference: " <<diff << endl;
}
