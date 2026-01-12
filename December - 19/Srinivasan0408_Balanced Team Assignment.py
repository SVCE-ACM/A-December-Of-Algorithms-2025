n = int(input())
arr = list(map(int, input().split()))

total = sum(arr)
half = total // 2
dp = [False] * (half + 1)
dp[0] = True

for val in arr:
    for s in range(half, val - 1, -1):
        if dp[s - val]:
            dp[s] = True

best = 0
for s in range(half, -1, -1):
    if dp[s]:
        best = s
        break

print(total - 2 * best)