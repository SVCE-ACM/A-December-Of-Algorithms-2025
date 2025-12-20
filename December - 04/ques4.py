n, ts = map(int, input("enter number of elements and target").split())
l= list(map(int, input("enter elements").split()))

c=0
for i in range(n):
    s=0
    for j in range(i,n):
        s+=l[j]
        if s==ts:
            c=1
            print(i,j)
            break
    if c==1:
        break
    s=0
else:
    print(-1,-1)
