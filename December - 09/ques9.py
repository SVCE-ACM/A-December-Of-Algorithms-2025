n=int(input("enter number of elements"))
l= list(map(int, input("enter elements").split()))
l1=[]
for i in l:
    if l.count(i)==1:
        l1.append(i)
if l1==[]:
    print(0)
else:
    print(sum(l1))
