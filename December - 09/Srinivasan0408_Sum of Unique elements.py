int(input())
arr=list(map(int,input().split()))
freq={}
for x in arr:
    if x not in freq:
        freq[x]=1
    else:
        freq[x]+=1
a=0
for x in arr:
    if freq[x]==1:
        a+=x
print(a) 