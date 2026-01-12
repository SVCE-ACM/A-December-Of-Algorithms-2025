board = []
for _ in range(9):
    row = input().split()
    board.append(row)
def is_valid(r, c, num):
    for j in range(9):
        if board[r][j] == num:
            return False
    for i in range(9):
        if board[i][c] == num:
            return False
    sr = (r // 3) * 3
    sc = (c // 3) * 3
    for i in range(3):
        for j in range(3):
            if board[sr + i][sc + j] == num:
                return False
    return True
def solve():
    for i in range(9):
        for j in range(9):
            if board[i][j] == '.':       
                for num in '123456789':
                    if is_valid(i, j, num):
                        board[i][j] = num
                        if solve():
                            return True
                        board[i][j] = '.'  
                return False             
    return True
solve()
for row in board:
    print(" ".join(row))