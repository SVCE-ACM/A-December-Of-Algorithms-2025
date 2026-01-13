#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, c0 = 0, c1 = 0;
    cin >> n;
    vector<int> stud(n), arr(n);

    for (int i = 0; i < n; i++) cin >> stud[i];
    for (int i = 0; i < n; i++) cin >> arr[i];

    for (int s : stud) {
        if (s == 0) c0++;
        else c1++;
    }

    for (int s : arr) {
        if (s == 0) {
            if (c0 == 0) break;
            c0--;
        } else {
            if (c1 == 0) break;
            c1--;
        }
    }
    cout << c0 + c1;
}
