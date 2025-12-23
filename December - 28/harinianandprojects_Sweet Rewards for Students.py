n = int(input())
a = list(map(int, input().split()))

c = [1]*n

for i in range(1, n):
    if a[i] > a[i-1]:
        c[i] = c[i-1] + 1

for i in range(n-2, -1, -1):
    if a[i] > a[i+1]:
        c[i] = max(c[i], c[i+1] + 1)

print(sum(c))
