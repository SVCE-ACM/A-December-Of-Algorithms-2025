N = int(input())
arr = list(map(int, input().split()))

sum_n = N * (N + 1) // 2
sum_sq_n = N * (N + 1) * (2 * N + 1) // 6

sum_arr = sum(arr)
sum_sq_arr = sum(x * x for x in arr)

diff = sum_n - sum_arr          # missing - duplicate
diff_sq = sum_sq_n - sum_sq_arr # missing² - duplicate²

missing_plus_duplicate = diff_sq // diff

missing = (diff + missing_plus_duplicate) // 2
duplicate = missing - diff

print(f"Missing Number: {missing}")
print(f"Duplicate Number: {duplicate}")
