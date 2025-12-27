#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    int width = log2(N) + 1;
    for (int i = 1; i <= N; i++) {
        cout << setw(width) << dec << i << " ";
        cout << setw(width) << oct << i << " ";
        cout << setw(width) << uppercase << hex << i << " ";
        cout << setw(width) << bitset<8>(i).to_string().substr(8 - width) << endl;
    }
    return 0;
}
