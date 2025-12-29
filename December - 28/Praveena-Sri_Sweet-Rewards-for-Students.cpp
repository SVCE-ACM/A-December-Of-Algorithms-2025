#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> score(n);
    for (int i = 0; i < n; i++) {
        cin >> score[i];
    }
    vector<int> sweets(n, 1);
    for (int i = 1; i < n; i++) {
        if (score[i] > score[i - 1]) {
            sweets[i] = sweets[i - 1] + 1;
        }
    }
    for (int i = n - 2; i >= 0; i--) {
        if (score[i] > score[i + 1]) {
            sweets[i] = max(sweets[i], sweets[i + 1] + 1);
        }
    }
    long long total = 0;
    for (int x : sweets) total += x;
    cout << total;
    return 0;
}
