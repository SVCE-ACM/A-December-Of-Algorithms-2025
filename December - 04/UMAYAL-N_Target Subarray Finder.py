n, k = map(int, input().split())
arr = list(map(int, input().split()))

prefix_sum = 0
index_map = {0: -1}

for i in range(n):
    prefix_sum += arr[i]
    if prefix_sum - k in index_map:
        print(index_map[prefix_sum - k] + 1, i)
        break
    index_map[prefix_sum] = i
else:
    print(-1, -1)
