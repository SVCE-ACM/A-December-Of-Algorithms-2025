s=input("enter string")
c=0
for i in s:
    if s.count(i)==1:
        print("first non repeating character is:",i)
        c=1
        break
if c==0:
    print("no non repeating character found")
