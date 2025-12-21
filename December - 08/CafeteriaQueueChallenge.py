students = [int(i) for i in input().split()]
sandwiches = [int(i) for i in input().split()]
d={}
for i in students:
    if i not in d:
        d[i]=1
    else:
        d[i]+=1
k=len(students)
for i in sandwiches:
    if d[i]>0:
        k-=1
        d[i]-=1
    else:
        print(k)
        exit()
print(k)