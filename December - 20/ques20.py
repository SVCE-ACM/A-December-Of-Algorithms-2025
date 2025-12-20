n=int(input("enter no. of towers"))
l= list(map(int, input("enter heights").split()))
l1=[]
s1=""
for i in range(n):
    for j in range(i+1,n):
        if l[j]>l[i]:
            l1.append(l[j])
            break
    else:
        l1.append(-1)
for i in l1:
    s1+=str(i)+" "
print(s1)
