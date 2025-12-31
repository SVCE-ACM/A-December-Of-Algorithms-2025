print("Enter N and K:")
N, K = map(int, input().split())

print("Enter the array:")
arr = list(map(int, input().split()))

prefix_sum = 0
seen = {0: -1}

start = end = -1

for i in range(N):
    prefix_sum += arr[i]
    if prefix_sum - K in seen:
        start = seen[prefix_sum - K] + 1
        end = i
        break
    seen[prefix_sum] = i

if start == -1:
    print("-1 -1")
else:
    print(start, end)
