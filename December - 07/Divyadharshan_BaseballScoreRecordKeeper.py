ops = [i for i in input().split()]

k=[]
for i in ops:
    if i=="+":
        k.append(k[-1]+k[-2])
    elif i=="C":
        k.pop(-1)
    elif i=="D":
        k.append(k[-1]*2)
    else:
        k.append(int(i))

print(sum(k) if k!=[] else 0)