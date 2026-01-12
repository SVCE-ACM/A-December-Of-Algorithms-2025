c=input()
for i in c:
    if c.count(i)==1:
        print("The first non-repeating character is :",i)
        break
else:
    print("No non-repeating character found.")
