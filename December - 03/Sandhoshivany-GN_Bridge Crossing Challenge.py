def canReachLastStone(stones):
    maxReach = 0
    n = len(stones)
    
    for i in range(n):
        if i > maxReach:  
            return False
        maxReach = max(maxReach, i + stones[i])
        if maxReach >= n - 1:  
            return True
    
    return False
stones = [2,3,1,1,4]
print(canReachLastStone(stones))
