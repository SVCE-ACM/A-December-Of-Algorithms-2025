n=int(input())
l=list(map(int,input().split()))
start=1
seen={}
dup=-1
for i in range(1,n+1):
    if i not in l:
        start=i
        break
for i in l:
    seen[i]=seen.get(i,0)+1
    if seen.get(i)>1:
        dup=i
print("Missing Number: ",start)
print("Duplicate Number: ",dup)