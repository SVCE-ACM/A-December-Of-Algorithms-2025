def shortest_path_in_warehouse(m, n, grid):
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        return -1
    directions = [(-1,0),(1,0),(0,-1),(0,1)]
    visited = [[False]*n for _ in range(m)]
    visited[0][0] = True
    queue = [(0, 0, 0)]
    while queue:
        r, c, steps = queue.pop(0)
        if r == m-1 and c == n-1:
            return steps
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc] and grid[nr][nc] == 0:
                visited[nr][nc] = True
                queue.append((nr, nc, steps + 1))
    return -1
m, n = input("Enter number of rows and columns (m n): ").split()
m = int(m)
n = int(n)
print(f"Enter the grid rows (each row has {n} integers, 0 for empty, 1 for obstacle), separated by spaces:")
grid = []
for _ in range(m):
    while True:
        row_input = input().split()
        if len(row_input) != n:
            print(f"Each row must have exactly {n} integers. Try again:")
            continue
        row = []
        valid = True
        for val in row_input:
            if val not in ('0','1'):
                print("Only 0 and 1 are allowed. Try again:")
                valid = False
                break
            row.append(int(val))
        if valid:
            grid.append(row)
            break
result = shortest_path_in_warehouse(m, n, grid)
print("Minimum number of steps:", result)
