n = int(input("Enter N: "))
arr = list(map(int, input("Enter node values: ").split()))

i, j = 0, n - 1
res = []

while i <= j:
    if i == j:
        res.append(arr[i])
    else:
        res.append(arr[i])
        res.append(arr[j])
    i += 1
    j -= 1

print(*res)
