n,target=map(int,input().split())
arr=list(map(int,input().split()))
left=0
sum=0
for right in range(n):
    sum+=arr[right]
    while sum>target and left<=right:
        sum-=arr[left]
        left+=1
    if sum==target:
        print(left,right)
        break
else:
    print(-1,-1)