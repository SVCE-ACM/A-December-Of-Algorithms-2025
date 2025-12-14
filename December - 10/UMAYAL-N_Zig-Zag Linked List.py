n = int(input())
arr = list(map(int, input().split()))

res = []
l, r = 0, n - 1

while l <= r:
    if l == r:
        res.append(arr[l])
    else:
        res.append(arr[l])
        res.append(arr[r])
    l += 1
    r -= 1

print(*res)
