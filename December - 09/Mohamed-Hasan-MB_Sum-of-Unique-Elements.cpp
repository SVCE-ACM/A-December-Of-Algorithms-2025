#include <bits/stdc++.h>
using namespace std;

int main() {
    int N; 
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
    unordered_map<int, int> freq;
    for (int x : arr) freq[x]++;
    long long sum = 0;
    for (auto &p : freq) {
        if (p.second == 1) {
            sum += p.first;
        }
    }
    cout << sum << "\n";
    return 0;
}
