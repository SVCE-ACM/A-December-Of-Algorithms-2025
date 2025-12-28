n = int(input())
arr = [int(i) for i in input().split()]
d = {}
c = 0
for i in arr:
    if i not in d:
        d[i]=1
    else:
        d[i]+=1
for i in d:
    if d[i]==1:
        c+=i
print(c)