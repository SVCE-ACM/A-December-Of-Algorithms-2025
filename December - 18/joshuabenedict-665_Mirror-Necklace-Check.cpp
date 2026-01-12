#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;

    if (N == 0) {
        cout << "The necklace is empty.";
        return 0;
    }

    vector<int> beads(N);
    for (int i = 0; i < N; i++) {
        cin >> beads[i];
    }

    int left = 0, right = N - 1;

    while (left < right) {
        if (beads[left] != beads[right]) {
            cout << "The necklace is not mirrored.";
            return 0;
        }
        left++;
        right--;
    }

    cout << "The necklace is mirrored.";
    return 0;
}
