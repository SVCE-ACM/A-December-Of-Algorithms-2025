def find(l):
    m= 0
    for i in range(len(l)):
        if i >m:
            return False
        m= max(m,i+l[i])
    return True
l=eval(input("enter the list"))
print(find(l))
