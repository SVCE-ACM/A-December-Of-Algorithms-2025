def findSubarrayWithSum(arr, K):
    prefix_sum = 0
    seen = {0: -1}  

    for i in range(len(arr)):
        prefix_sum += arr[i]

        if (prefix_sum - K) in seen:
            start = seen[prefix_sum - K] + 1
            end = i
            return start, end

        
        if prefix_sum not in seen:
            seen[prefix_sum] = i

    return -1, -1
N, K = 7, 15
arr = [1, 2, 3, 7, 5, 1, 2]
print(findSubarrayWithSum(arr, K))