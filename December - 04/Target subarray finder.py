def subarray_sum_indices(arr, K):
    prefix_map = {}
    current_sum = 0
    for i in range(len(arr)):
        current_sum += arr[i]
        if current_sum == K:
            return 0, i
        if current_sum - K in prefix_map:
            return prefix_map[current_sum - K] + 1, i
        if current_sum not in prefix_map:
            prefix_map[current_sum] = i
    return -1, -1
N, K = map(int, input().split())
arr = list(map(int, input().split()))
start, end = subarray_sum_indices(arr, K)
print(start, end)
