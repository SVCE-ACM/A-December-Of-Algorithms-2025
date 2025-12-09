n = int(input())
arr = list(map(int, input().split()))
res = []
for i in range(1, n-1):
    if arr[i] > arr[i-1] and arr[i] > arr[i+1]:
        res.append(i)   
if res:
    print(*res)
else:
    print(-1)