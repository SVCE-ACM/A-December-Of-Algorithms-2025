def solve_sudoku(board):
    def is_valid(r, c, ch):
        for j in range(9):
            if board[r][j] == ch:
                return False
       
      
        for i in range(9):
            if board[i][c] == ch:
                return False
        
       
        box_r = (r // 3) * 3
        box_c = (c // 3) * 3
        for i in range(box_r, box_r + 3):
            for j in range(box_c, box_c + 3):
                if board[i][j] == ch:
                    return False
        
        return True

    def backtrack():
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    for ch in '123456789':
                        if is_valid(i, j, ch):
                            board[i][j] = ch
                            if backtrack():
                                return True
                            board[i][j] = '.' 
                    return False  
        return True 
    
    backtrack()



board = [
    ["5","3",".",".","7",".",".",".","."],
    ["6",".",".","1","9","5",".",".","."],
    [".","9","8",".",".",".",".","6","."],
    ["8",".",".",".","6",".",".",".","3"],
    ["4",".",".","8",".","3",".",".","1"],
    ["7",".",".",".","2",".",".",".","6"],
    [".","6",".",".",".",".","2","8","."],
    [".",".",".","4","1","9",".",".","5"],
    [".",".",".",".","8",".",".","7","9"]
]

solve_sudoku(board)
for row in board:
    print(" ".join(row))
