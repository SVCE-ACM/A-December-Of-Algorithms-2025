n=int(input("enter a number: "))

for i in range(n):
    b= bin(i)
    o= oct(i)
    h= hex(i)
    print( f"{i}\t\t{o[2:]}\t\t{h[2:].upper()}\t\t{b[2:]}" )