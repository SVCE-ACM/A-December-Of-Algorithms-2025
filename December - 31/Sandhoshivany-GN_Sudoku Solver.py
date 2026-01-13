def is_valid(board, row, col, num):
    for j in range(9):
        if board[row][j] == num:
            return False

    
    for i in range(9):
        if board[i][col] == num:
            return False

    start_row, start_col = 3 * (row // 3), 3 * (col // 3)
    for i in range(start_row, start_row + 3):
        for j in range(start_col, start_col + 3):
            if board[i][j] == num:
                return False

    return True


def solve_sudoku(board):
    for i in range(9):
        for j in range(9):
            if board[i][j] == '.':
                for num in map(str, range(1, 10)):
                    if is_valid(board, i, j, num):
                        board[i][j] = num
                        if solve_sudoku(board):
                            return True
                        board[i][j] = '.'  
                return False
    return True


board = [input().split() for _ in range(9)]

solve_sudoku(board)

for row in board:
    print(" ".join(row))
