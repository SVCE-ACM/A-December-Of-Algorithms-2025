from collections import deque

def min_steps_to_treasure(maze, M, N):
    # Directions: up, down, left, right
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    # Find start position
    for i in range(M):
        for j in range(N):
            if maze[i][j] == 'S':
                start = (i, j)

    # visited[row][col][keys_mask]
    visited = [[[False] * (1 << 10) for _ in range(N)] for _ in range(M)]

    queue = deque()
    queue.append((start[0], start[1], 0, 0))  # row, col, keys_mask, steps
    visited[start[0]][start[1]][0] = True

    while queue:
        r, c, keys, steps = queue.popleft()

        # If treasure found
        if maze[r][c] == 'T':
            return steps

        for dr, dc in directions:
            nr, nc = r + dr, c + dc

            if 0 <= nr < M and 0 <= nc < N:
                cell = maze[nr][nc]
                new_keys = keys

                # Wall
                if cell == '#':
                    continue

                # Key
                if 'a' <= cell <= 'j':
                    new_keys |= (1 << (ord(cell) - ord('a')))

                # Door
                if 'A' <= cell <= 'J':
                    if not (keys & (1 << (ord(cell) - ord('A')))):
                        continue  # key not available

                if not visited[nr][nc][new_keys]:
                    visited[nr][nc][new_keys] = True
                    queue.append((nr, nc, new_keys, steps + 1))

    return -1


# ---------- INPUT ----------
print("Enter M and N:")
M, N = map(int, input().split())

print("Enter the maze:")
maze = []
for _ in range(M):
    maze.append(input().strip())

# ---------- OUTPUT ----------
result = min_steps_to_treasure(maze, M, N)
print(result)
