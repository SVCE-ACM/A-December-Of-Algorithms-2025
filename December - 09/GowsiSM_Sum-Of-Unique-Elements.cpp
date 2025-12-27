#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int main() {
    int N;
    long long sum = 0;
    unordered_map<long long, int> freq;
    cin >> N;
    vector<long long> arr(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
    
    for (long long x : arr) freq[x]++;

    for (auto &p : freq) {
        if (p.second == 1) {
            sum += p.first;
        }
    }
    cout << sum;
}
