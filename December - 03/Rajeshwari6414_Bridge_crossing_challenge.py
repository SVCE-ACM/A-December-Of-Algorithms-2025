def can_reach_last(stones):
    max_reach = 0
    n = len(stones)

    for i in range(n):
        # If current index is beyond reachable range
        if i > max_reach:
            return False
        
        # Update the farthest index we can reach
        max_reach = max(max_reach, i + stones[i])

        # If we can reach or pass the last index
        if max_reach >= n - 1:
            return True

    return False
stones = [2, 3, 1, 1, 4]
print(can_reach_last(stones))  

stones = [3, 2, 1, 0, 4]
print(can_reach_last(stones))  