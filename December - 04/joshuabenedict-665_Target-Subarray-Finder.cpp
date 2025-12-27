#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    long long K;
    cin >> N >> K;
    vector<long long> arr(N);
    for (int i = 0; i < N; i++)
        cin >> arr[i];
    unordered_map<long long, int> mp;
    long long sum = 0;

    for (int i = 0; i < N; i++) {
        sum += arr[i];
        if (sum == K) {
            cout << 0 << " " << i;
            return 0;
        }
        if (mp.find(sum - K) != mp.end()) {
            cout << mp[sum - K] + 1 << " " << i;
            return 0;
        }
        if (mp.find(sum) == mp.end())
            mp[sum] = i;
    }
    cout << "-1 -1";
    return 0;
}
