#include <iostream>
#include <vector>
using namespace std;
bool canReachLastStone(const vector<int>& stones) {
    int n = stones.size();
    int farthest = 0;  
    for (int i = 0; i < n; i++) {
        if (i > farthest) {
            return false;
        }
        farthest = max(farthest, i + stones[i]);
        if (farthest >= n - 1) {
            return true;
        }
    }
    return false;
}
int main() {
    int n;
    cout << "Enter number of stones: ";
    cin >> n;
    vector<int> stones(n);
    cout << "Enter stones array: ";
    for (int i = 0; i < n; i++) {
        cin >> stones[i];
    }
    if (canReachLastStone(stones)) {
        cout << "true" << endl;
    } else {
        cout << "false" << endl;
    }
    return 0;
}
