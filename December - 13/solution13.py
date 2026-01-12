n=int(input("enter the number of checkpoints:"))
heights=list(map(int,input().split()))
peaks=[]
for i in range(1,n-1):
  left=heights[i-1]
  mid=heights[i]
  right=heights[i+1]
  if(mid>left and mid>right):
    peaks.append(i)
    
if peaks:   
    print(*peaks)
else:
    print(-1)

enter the number of checkpoints:8
Enter the elevation of checkpoints:1 3 2 4 5 3 2 1
1 4

