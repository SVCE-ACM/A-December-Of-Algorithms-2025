n=int(input())
arr=list(map(int,input().split()))
sweets=0
for i in range(len(arr)):
    sweets+=1
    if i==0:
        if arr[i]>arr[i+1]:
            sweets+=1
    elif i==n-1:
        if arr[i]>arr[i-1]:
            sweets+=1
    elif arr[i]>arr[i+1] or arr[i]>arr[i-1]:
        sweets+=1
print(sweets)
