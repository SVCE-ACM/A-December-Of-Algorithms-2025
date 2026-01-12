N = int(input())
skills = list(map(int, input().split()))

total = sum(skills)
half = total // 2

# dp[i] = True if sum i can be formed using some subset
dp = [False] * (half + 1)
dp[0] = True

for s in skills:
    for i in range(half, s - 1, -1):
        if dp[i - s]:
            dp[i] = True

# find the largest possible sum <= half
for i in range(half, -1, -1):
    if dp[i]:
        team1 = i
        break

team2 = total - team1
print(abs(team2 - team1))
