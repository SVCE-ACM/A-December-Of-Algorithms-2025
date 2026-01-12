def check_valid(grid, num, pos):
    r, c = pos
    
    for i in range(9):
        if grid[r][i] == num and c != i:
            return False
    
    for i in range(9):
        if grid[i][c] == num and r != i:
            return False
    
    box_r = (r // 3) * 3
    box_c = (c // 3) * 3
    
    for i in range(box_r, box_r + 3):
        for j in range(box_c, box_c + 3):
            if grid[i][j] == num and (i, j) != pos:
                return False
    
    return True

def find_empty(grid):
    for i in range(9):
        for j in range(9):
            if grid[i][j] == '.':
                return (i, j)
    return None

def solve_puzzle(grid):
    empty = find_empty(grid)
    
    if not empty:
        return True
    
    r, c = empty
    
    for num in ['1', '2', '3', '4', '5', '6', '7', '8', '9']:
        if check_valid(grid, num, (r, c)):
            grid[r][c] = num
            
            if solve_puzzle(grid):
                return True
            
            grid[r][c] = '.'
    
    return False

print("Enter the Sudoku grid (use '.' for empty cells):")
grid = []
for i in range(9):
    line = input().split()
    grid.append(line)

solve_puzzle(grid)

for row in grid:
    print(' '.join(row))
