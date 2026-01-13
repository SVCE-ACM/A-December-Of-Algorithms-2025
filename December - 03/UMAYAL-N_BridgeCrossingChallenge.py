def canReachLast(stones):
    max_reach = 0
    for i in range(len(stones)):
        if i > max_reach:
            return False
        max_reach = max(max_reach, i + stones[i])
    return True


stones = list(map(int, input().strip("[]").split(",")))
print(str(canReachLast(stones)).lower())
