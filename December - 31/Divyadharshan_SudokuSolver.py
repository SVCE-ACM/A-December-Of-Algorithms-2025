board = [input().split() for _ in range(9)]

def isValid(r, c, ch):
    for i in range(9):
        if board[r][i] == ch or board[i][c] == ch:
            return False
        if board[3*(r//3)+i//3][3*(c//3)+i%3] == ch:
            return False
    return True

def solve():
    for i in range(9):
        for j in range(9):
            if board[i][j] == '.':
                for ch in '123456789':
                    if isValid(i, j, ch):
                        board[i][j] = ch
                        if solve():
                            return True
                        board[i][j] = '.'
                return False
    return True

solve()

for row in board:
    print(" ".join(row))