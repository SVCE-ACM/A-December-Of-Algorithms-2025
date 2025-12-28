n,k=[int(i) for i in input().split()]
arr=[int(i) for i in input().split()]
l,s=0,0
for i in range(n):
    s+=arr[i]
    while s>k:
        s-=arr[l]
        l+=1
    if s==k:
        print(l,i)
        break 
else:
    print(-1,-1)