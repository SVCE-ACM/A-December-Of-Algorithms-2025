print("Enter N:", end=" ")
n = int(input())

print("Enter node values:", end=" ")
arr = list(map(int, input().split()))

res = []
i, j = 0, n-1

while i <= j:
    if i == j:
        res.append(arr[i])
    else:
        res.append(arr[i])
        res.append(arr[j])
    i += 1
    j -= 1

print(*res)