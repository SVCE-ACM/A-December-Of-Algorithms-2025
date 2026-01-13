#include <iostream>
#include <vector>
#include <iomanip>

int main() {
    int n;
    if (!(std::cin >> n)) {
        std::cin.clear();
        std::string junk;
        std::cin >> junk;
        std::cin >> junk;
        std::cin >> n;
    }

    if (n % 2 == 0) {
        std::cout << "Magic square is only possible for odd values of n." << std::endl;
    } else {
        std::vector<std::vector<int>> magic(n, std::vector<int>(n, 0));
        int row = 0;
        int col = n / 2;
        int num = 1;
        while (num <= n * n) {
            magic[row][col] = num;
            num++;
            int new_row = (row - 1 + n) % n;
            int new_col = (col + 1) % n;
            if (magic[new_row][new_col] != 0) {
                row = (row + 1) % n;
            } else {
                row = new_row;
                col = new_col;
            }
        }

        long long M = (long long)n * (n * n + 1) / 2;
        std::cout << "Magic constant: " << M << std::endl;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                std::cout << magic[i][j] << (j == n - 1 ? "" : "   ");
            }
            std::cout << std::endl;
        }
    }
    return 0;
}
