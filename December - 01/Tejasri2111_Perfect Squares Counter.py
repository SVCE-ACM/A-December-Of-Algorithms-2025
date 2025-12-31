n=int(input("Enter the upper bound:"))
arr,sum,i=[],0,1
while(i*i<=n):
    arr.append(i*i)
    i += 1
print(arr)
print(i-1)
