N = int(input())
arr = list(map(int, input().split()))

duplicate = -1
missing = -1
for x in arr:
    idx = abs(x) - 1
    if arr[idx] < 0:
        duplicate = abs(x)
    else:
        arr[idx] *= -1

for i in range(N):
    if arr[i] > 0:
        missing = i + 1
        break

print(f"Missing Number: {missing}")
print(f"Duplicate Number: {duplicate}")
