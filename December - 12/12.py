def find_missing_and_duplicate(arr, n):
    duplicate = -1
    missing = -1
    for i in range(n):
        while arr[i] != i+1 and arr[arr[i]-1] != arr[i]:
            arr[arr[i]-1], arr[i] = arr[i], arr[arr[i]-1]

    for i in range(n):
        if arr[i] != i+1:
            duplicate = arr[i]
            missing = i+1
            break
    print("Missing Number:", missing)
    print("Duplicate Number:", duplicate)
N =int(input())
arr =list(map(int,input().split()))
find_missing_and_duplicate(arr, N)
