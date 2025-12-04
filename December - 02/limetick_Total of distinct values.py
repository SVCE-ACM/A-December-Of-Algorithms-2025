n=int(input("Enter the number: "))
for i in range(1,n+1):
    values=[
    str(i),
    oct(i)[2:],
    hex(i)[2:].upper(),
    bin(i)[2:]
   ]
    for j in values:
        print(j.rjust(5),end=" ")

    print()
