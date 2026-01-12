# input sudoku grid
grid = []
print("Enter the Sudoku grid row by row (use '.' for empty cells):")
for _ in range(9):
    row = input().split()
    grid.append(row)

# check if it's valid to place num at grid[r][c]
def is_valid(r, c, num):
    for i in range(9):
        if grid[r][i] == num or grid[i][c] == num:
            return False
    sr, sc = 3*(r//3), 3*(c//3)
    for i in range(sr, sr+3):
        for j in range(sc, sc+3):
            if grid[i][j] == num:
                return False
    return True

# backtracking solver
def solve():
    for r in range(9):
        for c in range(9):
            if grid[r][c] == '.':
                for num in '123456789':
                    if is_valid(r, c, num):
                        grid[r][c] = num
                        if solve():
                            return True
                        grid[r][c] = '.'
                return False
    return True

# solve and print
if solve():
    print("Solved Sudoku:")
    for row in grid:
        print(' '.join(row))
else:
    print("No solution exists")
