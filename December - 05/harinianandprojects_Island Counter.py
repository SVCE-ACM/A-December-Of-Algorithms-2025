def explore(matrix, row, col):
    if (
        row < 0 or col < 0 or
        row >= total_rows or col >= total_cols or
        matrix[row][col] == 0
    ):
        return

    matrix[row][col] = 0

    explore(matrix, row + 1, col)
    explore(matrix, row - 1, col)
    explore(matrix, row, col + 1)
    explore(matrix, row, col - 1)

total_rows, total_cols = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(total_rows)]

island_count = 0

for r in range(total_rows):
    for c in range(total_cols):
        if matrix[r][c] == 1:
            explore(matrix, r, c)
            island_count += 1
          
print(island_count)
