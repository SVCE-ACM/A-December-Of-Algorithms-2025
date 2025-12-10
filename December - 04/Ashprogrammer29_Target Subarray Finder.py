def find_subarray(N, K, arr):
    prefix = 0
    seen = {0: -1} 

    for i in range(N):
        prefix += arr[i]

        if prefix - K in seen:
            return seen[prefix - K] + 1, i
        
        seen[prefix] = i

    return -1, -1
