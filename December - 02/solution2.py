n=int(input("enter a number:"))
width=len(bin(n))-2
for i in range(1,n+1):
    print(str(i).rjust(width),
    hex(i)[2: ].upper().rjust(width),
    oct(i)[2: ].rjust(width),
    bin(i)[2: ].rjust(width))

enter a number:10
   1    1    1    1
   2    2    2   10
   3    3    3   11
   4    4    4  100
   5    5    5  101
   6    6    6  110
   7    7    7  111
   8    8   10 1000
   9    9   11 1001
  10    A   12 1010