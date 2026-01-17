n = int(input())
a = list(map(int, input().split()))
ans = []
while a:
    m = min(a)
    i = a.index(m)
    for _ in range(i):
        a.append(a.pop(0))
    ans.append(a.pop(0))
print(*ans)
