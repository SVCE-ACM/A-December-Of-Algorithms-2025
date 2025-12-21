n = int(input())
skills = [int(i) for i in input().split()]
total = sum(skills)
dp = [[False] * (total + 1) for _ in range(n + 1)]
dp[0][0] = True
for i in range(1, n + 1):
    for j in range(total + 1):
        dp[i][j] = dp[i - 1][j]
        if j >= skills[i - 1]:
            dp[i][j] |= dp[i - 1][j - skills[i - 1]]
ans = float('inf')
for j in range(total // 2 + 1):
    if dp[n][j]:
        ans = min(ans, total - 2 * j)
print(ans)