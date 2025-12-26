N=int(input())
arr=list(map(int,input().split()))
for i in range(N):
    next_greater=-1
    for j in range(i+1,N):
        if arr[j]>arr[i]:
            next_greater=arr[j]
            break
    print(next_greater,end=" ")  
