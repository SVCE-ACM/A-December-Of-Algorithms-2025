n = int(input())
width = len(bin(n)[2:])  

for i in range(1, n+1):
    decimal = str(i).rjust(width)
    octal = oct(i)[2:].rjust(width)
    hexa = hex(i)[2:].upper().rjust(width)
    binary = bin(i)[2:].rjust(width)
    print(decimal, octal, hexa, binary)