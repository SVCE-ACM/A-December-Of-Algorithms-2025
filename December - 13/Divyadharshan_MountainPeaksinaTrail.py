n = int(input())
m = [int(i) for i in input().split()]
ind = []
for i in range(1,n-1):
    if m[i-1]<m[i] and m[i]>m[i+1]:
        ind.append(i)
if ind:
    print(*ind)
else:
    print(-1)