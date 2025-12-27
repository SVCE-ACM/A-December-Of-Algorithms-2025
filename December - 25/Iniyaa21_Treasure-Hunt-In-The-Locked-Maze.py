import collections

def func():
    M,N = [int(i) for i in input().split()]

    grid = [input().strip() for _ in range(M)]
    
    start_pos = None
    target_pos = None
    all_keys = {}
    key_count = 0
    
    for r in range(M):
        for c in range(N):
            char = grid[r][c]
            if char == 'S':
                start_pos = (r, c)
            elif char == 'T':
                target_pos = (r, c)
            elif 'a' <= char <= 'j':
                if char not in all_keys:
                    all_keys[char] = key_count
                    key_count += 1

    queue = collections.deque([(start_pos[0], start_pos[1], 0, 0)])
    visited = set([(start_pos[0], start_pos[1], 0)])
    
    while queue:
        r, c, keys_mask, dist = queue.popleft()
        
        if (r, c) == target_pos:
            print(dist)
            return
            
        for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            nr, nc = r + dr, c + dc
            
            if 0 <= nr < M and 0 <= nc < N:
                char = grid[nr][nc]
                
                if char == '#':
                    continue
                
                new_keys_mask = keys_mask
                if 'a' <= char <= 'j':
                    new_keys_mask |= (1 << all_keys[char])
                
                if 'A' <= char <= 'J':
                    key_needed = char.lower()
                    if key_needed not in all_keys or not (keys_mask & (1 << all_keys[key_needed])):
                        continue
                
                if (nr, nc, new_keys_mask) not in visited:
                    visited.add((nr, nc, new_keys_mask))
                    queue.append((nr, nc, new_keys_mask, dist + 1))
                    
    print("-1")

func()