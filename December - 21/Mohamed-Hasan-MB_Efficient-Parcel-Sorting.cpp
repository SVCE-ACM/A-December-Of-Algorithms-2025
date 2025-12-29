#include <bits/stdc++.h>
using namespace std;

int main() {
    int N; cin >> N;
    deque<int> parcels(N);
    for (int i = 0; i < N; i++) cin >> parcels[i];
    vector<int> sorted_output;
    sorted_output.reserve(N);
    while (!parcels.empty()) {
        int min_val = INT_MAX;
        int min_idx = -1;
        for (int i = 0; i < (int)parcels.size(); i++) {
            if (parcels[i] < min_val) {
                min_val = parcels[i];
                min_idx = i;
            }
        }
        int left_rotations = min_idx;
        int right_rotations = (int)parcels.size() - min_idx;
        if (left_rotations <= right_rotations) {
            for (int i = 0; i < left_rotations; i++) {
                int front = parcels.front();
                parcels.pop_front();
                parcels.push_back(front);
            }
        } else {
            for (int i = 0; i < right_rotations; i++) {
                int back = parcels.back();
                parcels.pop_back();
                parcels.push_front(back);
            }
        }
        sorted_output.push_back(parcels.front());
        parcels.pop_front();
    }
    for (int val : sorted_output) {
        cout << val << " ";
    }
    cout << "\n";
    return 0;
}
