n=int(input())
j=0
for i in range(1,n):
    if(i*i<n):
        print((i*i),end=" ")
        j+=1
    else:
        break
print(f"\n{j}")
