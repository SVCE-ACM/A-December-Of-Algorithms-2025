import math
n=int(input())
count=0
for i in range(1,n+1):
  if math.sqrt(i)**2==i:
    print(i,end=" ")
    count+=1
print()
print(count)
