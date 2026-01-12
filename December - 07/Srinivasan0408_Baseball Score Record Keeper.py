arr=input("ops = ").strip()
arr=arr[1:-1]
p=arr.split(',')
ops=[l.strip().strip('"') for l in p]
s=[]
for o in ops:
    if o.lstrip('-').isdigit():
        s.append(int(o))
    elif o=='C':
        s.pop()
    elif o=='D':
        s.append(s[-1]*2)
    elif o=='+':
        s.append(s[-1]+s[-2])
print(sum(s))