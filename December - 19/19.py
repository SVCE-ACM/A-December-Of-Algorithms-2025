#DP
def min_difference_partition(skills):
    total = sum(skills)
    n = len(skills)
    dp = [[False] * (total + 1) for _ in range(n + 1)]
    dp[0][0] = True
    for i in range(1, n + 1):
        for j in range(total + 1):
            dp[i][j] = dp[i-1][j] or (j >= skills[i-1] and dp[i-1][j - skills[i-1]])
    for j in range(total // 2, -1, -1):
        if dp[n][j]:
            return total - 2*j

if __name__ == "__main__":
    N = int(input())
    skills = list(map(int, input().split()))
    result = min_difference_partition(skills)
    print(result)
