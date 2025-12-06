n=int(input("enter a number:"))
width=len(bin(n))-2
for i in range(1,n+1):
    print(str(i).rjust(width),
    hex(i)[2: ].upper().rjust(width),
    oct(i)[2: ].rjust(width),
    bin(i)[2: ].rjust(width))