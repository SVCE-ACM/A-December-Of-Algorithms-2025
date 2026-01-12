N = int(input())
arr = list(map(int, input().split()))

duplicate = -1
missing = -1


for i in range(N):
    idx = abs(arr[i]) - 1
    if arr[idx] < 0:
        duplicate = abs(arr[i])
    else:
        arr[idx] = -arr[idx]


for i in range(N):
    if arr[i] > 0:
        missing = i + 1
        break

print("Missing Number:", missing)
print("Duplicate Number:", duplicate)
