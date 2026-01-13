# December 23 - Shortest Path in a Warehouse Grid
from collections import deque

# Read dimensions
m, n = map(int, input().split())

# Read grid
grid = [list(map(int, input().split())) for _ in range(m)]

# If start or end blocked → unreachable
if grid[0][0] == 1 or grid[m-1][n-1] == 1:
    print(-1)
else:
    # BFS queue → (row, col, distance)
    q = deque([(0, 0, 0)])
    visited = set([(0, 0)])

    dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    ans = -1

    while q:
        r, c, d = q.popleft()

        # If goal reached
        if r == m - 1 and c == n - 1:
            ans = d
            break

        # Explore neighbors
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n:
                if grid[nr][nc] == 0 and (nr, nc) not in visited:
                    visited.add((nr, nc))
                    q.append((nr, nc, d + 1))

    print(ans)
