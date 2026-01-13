#include <iostream>
#include <vector>

int main() {
    int n;
    if (std::cin >> n) {
        std::vector<int> squares;
        for (int i = 1; ; ++i) {
            int sq = i * i;
            if (sq > n) break;
            squares.push_back(sq);
        }
        for (size_t i = 0; i < squares.size(); ++i) {
            std::cout << squares[i] << (i == squares.size() - 1 ? "" : " ");
        }
        std::cout << "\n" << squares.size() << std::endl;
    }
    return 0;
}
