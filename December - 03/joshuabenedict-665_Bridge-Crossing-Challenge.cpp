#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> stones(n);
    for (int i = 0; i < n; i++)
        cin >> stones[i];
    int maxReach = 0;
    for (int i = 0; i < n; i++) {
        if (i > maxReach) {
            cout << "false";
            return 0;
        }
        maxReach = max(maxReach, i + stones[i]);
        if (maxReach >= n - 1) {
            cout << "true";
            return 0;
        }
    }
    cout << "true";
    return 0;
}
