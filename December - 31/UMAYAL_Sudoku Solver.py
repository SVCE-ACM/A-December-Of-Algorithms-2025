# December 31 - Sudoku Solver

board = [input().split() for _ in range(9)]

def valid(r, c, ch):
    # row & column check
    for i in range(9):
        if board[r][i] == ch: return False
        if board[i][c] == ch: return False

    # 3x3 box check
    br = (r // 3) * 3
    bc = (c // 3) * 3
    for i in range(br, br + 3):
        for j in range(bc, bc + 3):
            if board[i][j] == ch:
                return False
    return True


def solve():
    for r in range(9):
        for c in range(9):
            if board[r][c] == '.':
                for ch in "123456789":
                    if valid(r, c, ch):
                        board[r][c] = ch
                        if solve():
                            return True
                        board[r][c] = '.'
                return False
    return True


solve()

for row in board:
    print(*row)
