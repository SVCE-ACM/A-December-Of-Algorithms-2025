#include <iostream>
#include <vector>
#include <string>
#include <iomanip>

int main() {
    std::string word;
    int n = 0;
    while (std::cin >> word) {
        try {
            size_t idx;
            int val = std::stoi(word, &idx);
            n = val; 
            break; 
        } catch (...) {
            std::string num_str = "";
            for(char c : word) {
                if(isdigit(c)) num_str += c;
            }
            if(!num_str.empty()) {
                n = std::stoi(num_str);
                break;
            }
        }
    }

    if (n % 2 == 0) {
        std::cout << "Magic square is only possible for odd values of n." << std::endl;
    } else {
        long long M = (long long)n * (n * n + 1) / 2;
        std::cout << "Magic constant: " << M << std::endl;

        std::vector<std::vector<int>> magic(n, std::vector<int>(n, 0));
        int num = 1;
        int i = 0, j = n / 2;

        while (num <= n * n) {
            magic[i][j] = num;
            num++;
            int new_i = (i - 1 + n) % n;
            int new_j = (j + 1) % n;
            if (magic[new_i][new_j]) {
                i = (i + 1) % n;
            } else {
                i = new_i;
                j = new_j;
            }
        }

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                std::cout << magic[r][c] << (c == n - 1 ? "" : "   ");
            }
            std::cout << std::endl;
        }
    }
    return 0;
}
