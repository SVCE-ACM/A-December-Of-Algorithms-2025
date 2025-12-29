#include <bits/stdc++.h>
using namespace std;

int main() {
    long long N;
    cin >> N;
    vector<long long> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    long long S = 0, S2 = 0;
    for (long long x : arr) {
        S += x;
        S2 += x * x;
    }
    long long Sn = N * (N + 1) / 2;
    long long S2n = N * (N + 1) * (2 * N + 1) / 6;
    long long diff = S - Sn;              
    long long diffSq = S2 - S2n;           
    long long sum = diffSq / diff;         
    long long duplicate = (diff + sum) / 2;
    long long missing = duplicate - diff;
    cout << "Missing Number: " << missing << "\n";
    cout << "Duplicate Number: " << duplicate << "\n";
    return 0;
}
