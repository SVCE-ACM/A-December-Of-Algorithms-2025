#include <iostream>
#include <vector>
#include <string>

bool isValid(const std::vector<std::vector<char>>& board, int r, int c, char k) {
    for (int i = 0; i < 9; ++i) {
        if (board[r][i] == k) return false;
        if (board[i][c] == k) return false;
        if (board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == k) return false;
    }
    return true;
}

bool solve(std::vector<std::vector<char>>& board) {
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            if (board[i][j] == '.' || board[i][j] == '0') {
                for (char k = '1'; k <= '9'; ++k) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (solve(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
    }
    return true;
}

int main() {
    std::vector<std::vector<char>> board(9, std::vector<char>(9));
    bool meaningful_input = false;
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            std::cin >> board[i][j];
            if (board[i][j] != '.' && board[i][j] != '0') meaningful_input = true;
        }
    }
    
    if (meaningful_input) {
         solve(board);
    }
    
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            std::cout << board[i][j] << (j == 8 ? "" : " ");
        }
        std::cout << std::endl;
    }
    
    return 0;
}
