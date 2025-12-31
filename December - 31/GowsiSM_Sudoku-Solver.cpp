#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool isValid(vector<vector<char>>& board, int row, int col, char ch) {
    for (int j = 0; j < 9; j++)
        if (board[row][j] == ch) return false;

    for (int i = 0; i < 9; i++)
        if (board[i][col] == ch) return false;

    int boxRow = (row / 3) * 3, boxCol = (col / 3) * 3;

    for (int i = boxRow; i < boxRow + 3; i++)
        for (int j = boxCol; j < boxCol + 3; j++)
            if (board[i][j] == ch) return false;

    return true;
}

bool solveSudoku(vector<vector<char>>& board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(board, i, j, ch)) {
                        board[i][j] = ch;
                        if (solveSudoku(board))
                            return true;
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
    vector<vector<char>> board(9, vector<char>(9));

    for (int i = 0; i < 9; i++)
        for (int j = 0; j < 9; j++)
            cin >> board[i][j];

    solveSudoku(board);

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++)
            cout << board[i][j] << " ";
        cout << endl;
    }
}
