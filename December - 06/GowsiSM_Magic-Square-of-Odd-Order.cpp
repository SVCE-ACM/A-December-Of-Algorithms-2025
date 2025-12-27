#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n, row = 0, col = n / 2;
    cout << "Enter n: ";
    cin>> n;

    if (n % 2 == 0) {
        cout << "Magic square is only possible for odd values of n.";
        return 0;
    }
    int M = (n * (n * n + 1)) / 2;
    cout << "Magic constant: " << M << endl;
    vector<vector<int>> arr(n, vector<int>(n, 0));

    for (int num = 1; num <= n * n; num++) {
        arr[row][col] = num;
        int nextRow = (row - 1 + n) % n, nextCol = (col + 1) % n;

        if (arr[nextRow][nextCol] != 0) {
            row = (row + 1) % n; 
        } else {
            row = nextRow;
            col = nextCol;
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << setw(4) <<arr[i][j];
        }
        cout << "\n";
    }
}
