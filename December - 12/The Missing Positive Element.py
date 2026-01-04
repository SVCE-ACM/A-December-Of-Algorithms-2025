N = int(input("Enter N: "))
arr = list(map(int, input("Enter the elements: ").split()))

sum_n = N * (N + 1) // 2
sum_sq_n = N * (N + 1) * (2 * N + 1) // 6

sum_arr = 0
sum_sq_arr = 0

for x in arr:
    sum_arr += x
    sum_sq_arr += x * x

diff = sum_n - sum_arr
diff_sq = sum_sq_n - sum_sq_arr

sum_md = diff_sq // diff

missing = (diff + sum_md) // 2
duplicate = sum_md - missing

print("Missing Number:", missing)
print("Duplicate Number:", duplicate)
