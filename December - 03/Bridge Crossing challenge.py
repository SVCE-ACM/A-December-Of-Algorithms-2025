def canReachLastStone(stones):
    max_reach = 0
    n = len(stones)
    for i in range(n):
        if i > max_reach:
            return False
        max_reach = max(max_reach, i + stones[i])
        if max_reach >= n - 1:
            return True
    return True
stones = [2, 3, 1, 1, 4]
print(canReachLastStone(stones))
stones = [3, 2, 1, 0, 4]
print(canReachLastStone(stones))
