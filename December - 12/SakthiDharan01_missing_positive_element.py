import sys

def solve():
    data = list(map(int, sys.stdin.read().strip().split()))
    if not data:
        return
    n = data[0]
    arr = data[1:1+n]
    expected_sum = n * (n + 1) // 2
    expected_sq = n * (n + 1) * (2 * n + 1) // 6
    actual_sum = sum(arr)
    actual_sq = sum(x * x for x in arr)
    diff = expected_sum - actual_sum  # missing - duplicate
    diff_sq = expected_sq - actual_sq  # missing^2 - duplicate^2 = (m-d)(m+d)
    sum_md = diff_sq // diff  # missing + duplicate
    missing = (diff + sum_md) // 2
    duplicate = missing - diff
    print(f"Missing Number: {missing}")
    print(f"Duplicate Number: {duplicate}")

if __name__ == "__main__":
    solve()
