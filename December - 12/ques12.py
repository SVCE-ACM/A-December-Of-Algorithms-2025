n=int(input("enter no. of elements"))
l= list(map(int, input("enter elements").split()))
for i in l:
    if l.count(i)>1:
        print("duplicate number:",i)
        break
for i in range(n):
    if i+1 not in l:
        print("missing number: ",i+1)
        break
