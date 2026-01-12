n=int(input())
peak=False
arr=list(map(int,input().split()))
for i in range(n):
    if i==0:
        if arr[i]>arr[i+1]:
            print(i,end=" ")
            peak=True
    elif i==n-1:
        if arr[i]>arr[i-1]:
            print("-1",end=" ")
            peak=True
    elif arr[i]>arr[i+1] and arr[i]>arr[i-1]:
        print(i,end=" ")
        peak=True
if peak==False:
    print("-1")
