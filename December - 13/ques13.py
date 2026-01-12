n=int(input("enter no. of elements"))
l= list(map(int, input("enter elements").split()))
l1=[]
for i in range(1,n-1):
    if l[i]>l[i-1] and l[i]>l[i+1]:
        l1.append(i)
for i in l1:
    print(i,end=" ")
