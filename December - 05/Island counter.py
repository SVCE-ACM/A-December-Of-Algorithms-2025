R, C = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(R)]
def flood(i, j):
    if i < 0 or i >= R or j < 0 or j >= C or grid[i][j] == 0:
        return
    grid[i][j] = 0
    flood(i+1, j)
    flood(i-1, j)
    flood(i, j+1)
    flood(i, j-1)
ans = 0
for i in range(R):
    for j in range(C):
        if grid[i][j] == 1:
            ans += 1
            flood(i, j)

print(ans)

