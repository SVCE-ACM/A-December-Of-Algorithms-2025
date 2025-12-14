n = int(input())

# width based on binary length of N
width = len(bin(n)[2:])

for i in range(1, n + 1):
    print(
        str(i).rjust(width),
        oct(i)[2:].rjust(width),
        hex(i)[2:].upper().rjust(width),
        bin(i)[2:].rjust(width)
    )
