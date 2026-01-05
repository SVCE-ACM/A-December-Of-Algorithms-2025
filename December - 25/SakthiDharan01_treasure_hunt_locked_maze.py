import sys
from collections import deque

def solve():
    data = sys.stdin.read().splitlines()
    if not data:
        return
    m, n = map(int, data[0].split())
    grid = [list(line.strip()) for line in data[1:1+m]]
    start = None
    target = None
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 'S':
                start = (i, j)
            if grid[i][j] == 'T':
                target = (i, j)
    if start is None or target is None:
        print(-1)
        return
    dirs = [(1,0),(-1,0),(0,1),(0,-1)]
    visited = [[[False]* (1<<10) for _ in range(n)] for _ in range(m)]
    q = deque()
    q.append((start[0], start[1], 0, 0))  # x,y,keys,dist
    visited[start[0]][start[1]][0] = True
    while q:
        x,y,keys,dist = q.popleft()
        if (x,y) == target:
            print(dist)
            return
        for dx,dy in dirs:
            nx, ny = x+dx, y+dy
            if 0 <= nx < m and 0 <= ny < n:
                cell = grid[nx][ny]
                if cell == '#':
                    continue
                new_keys = keys
                if 'a' <= cell <= 'j':
                    new_keys |= 1 << (ord(cell) - ord('a'))
                if 'A' <= cell <= 'J':
                    if (new_keys >> (ord(cell) - ord('A'))) & 1 == 0:
                        continue
                if not visited[nx][ny][new_keys]:
                    visited[nx][ny][new_keys] = True
                    q.append((nx, ny, new_keys, dist + 1))
    print(-1)

if __name__ == "__main__":
    solve()
