#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int main() {
    long long n, k, prefixSum = 0;
    cin >> n>>k;

    vector<long long> arr(n);
    for (int i = 0; i <n; i++) cin >> arr[i];

    unordered_map<long long, int> prefixIndex;
    prefixIndex[0] = -1;

    for (int i = 0; i <n; i++) {
        prefixSum += arr[i];

        if (prefixIndex.count(prefixSum - k)) {
            cout << prefixIndex[prefixSum - k] + 1 << " " << i;
            return 0;
        }
        if (!prefixIndex.count(prefixSum)) prefixIndex[prefixSum] = i;
    }

    cout<< "-1 -1";
    return 0;
}
