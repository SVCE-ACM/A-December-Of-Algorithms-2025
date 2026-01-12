N = int(input("Enter the number: "))
arr = list(map(int, input("Enter values: ").split()))

flag = 0
for i in range(1,N-1):
    if arr[i]>arr[i-1] and arr[i]>arr[i+1]:
        print(i,end=" ")
        flag = 1
if flag==0:
    print(-1)
