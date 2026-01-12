stones = [int(i) for i in input().split()]
p = 0
for i in range(len(stones)-1):
    if p>=i:
        p=max(p,i+stones[i])

if p>=len(stones)-1:
    print(True)
else:
    print(False)