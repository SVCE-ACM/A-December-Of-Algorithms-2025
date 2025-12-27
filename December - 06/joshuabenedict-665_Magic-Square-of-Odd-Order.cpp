#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    if (n % 2 == 0) {
        cout << "Magic square is only possible for odd values of n.";
        return 0;
    }
    vector<vector<int>> magic(n, vector<int>(n, 0));
    int num = 1;
    int i = 0;
    int j = n / 2;
    while (num <= n * n) {
        magic[i][j] = num++;

        int next_i = (i - 1 + n) % n;
        int next_j = (j + 1) % n;

        if (magic[next_i][next_j] != 0) {
            i = (i + 1) % n;
        } else {
            i = next_i;
            j = next_j;
        }
    }
    int magicConstant = n * (n * n + 1) / 2;
    cout << "Magic constant: " << magicConstant << "\n";

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            cout << setw(3) << magic[r][c] << " ";
        }
        cout << "\n";
    }
    return 0;
}
