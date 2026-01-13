n = int(input())
arr = list(map(int, input().split()))

for i in range(n):
    while arr[i] != arr[arr[i] - 1]:
        arr[arr[i] - 1], arr[i] = arr[i], arr[arr[i] - 1]

for i in range(n):
    if arr[i] != i + 1:
        print("Missing Number:", i + 1)
        print("Duplicate Number:", arr[i])
        break
