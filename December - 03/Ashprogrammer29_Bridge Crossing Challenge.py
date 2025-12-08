def canReachLastStone(stones):
    reach = 0 
    
    for i in range(len(stones)):
        if i > reach:
            return False
        reach = max(reach, i + stones[i])
    
    return reach >= len(stones) - 1
