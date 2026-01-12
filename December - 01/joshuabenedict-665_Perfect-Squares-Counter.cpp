#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;

    int count = 0;

    for (int i = 1; i * i <= N; i++) {
        cout << i * i << " ";
        count++;
    }

    cout << endl << count;
    return 0;
}
