#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> heights(N);
    for (int i = 0; i < N; i++) {
        cin >> heights[i];
    }
    vector<int> peaks;
    for (int i = 1; i < N - 1; i++) {
        if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
            peaks.push_back(i);
        }
    }
    if (peaks.empty()) {
        cout << -1;
    } else {
        for (int idx : peaks) {
            cout << idx << " ";
        }
    }
    return 0;
}
