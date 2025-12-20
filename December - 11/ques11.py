n=int(input("enter n"))
l=[]
for i in range(2,n):
    c=0
    for j in range(2,i+1):
        if (i%j==0):
            c+=1
    if c==1:
        l.append(i)
print("the count of prime numbers less than N is:",len(l))
