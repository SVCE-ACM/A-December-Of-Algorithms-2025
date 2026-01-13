N = int(input())

# Width is based on the binary representation of N
width = len(bin(N)) - 2

for i in range(1, N + 1):
    dec = str(i).rjust(width)
    octal = oct(i)[2:].rjust(width)
    hexa = hex(i)[2:].upper().rjust(width)
    binary = bin(i)[2:].rjust(width)

    print(dec, octal, hexa, binary)
