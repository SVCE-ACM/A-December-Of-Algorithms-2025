n=int(input())
for i in range(1, n+1):
    d=str(i)
    o=oct(i)[2:]
    h=hex(i)[2:].upper()
    b=bin(i)[2:]
    print(d,o,h,b)