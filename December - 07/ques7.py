l=eval(input("enter list"))
rec=[]
def push(a):
    rec.append(a)
def pope(a):
    rec.pop(a)
for i in range(len(l)):
    if l[i]=='+':
        rec.append(rec[-1]+rec[-2])
    elif l[i]=='C':
        rec.pop()
    elif l[i]=='D':
        rec.append(2*rec[-1])
    else:
        rec.append(int(l[i]))
print(sum(rec))
