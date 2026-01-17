import sys

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if not data:
        return
    n = data[0]
    arr = data[1:1+n]
    total = sum(arr)
    target = total // 2
    dp = [False]*(target+1)
    dp[0]=True
    for num in arr:
        for s in range(target, num-1, -1):
            dp[s] = dp[s] or dp[s-num]
    best = max(i for i in range(target+1) if dp[i])
    diff = total - 2*best
    print(diff)

if __name__ == "__main__":
    solve()
