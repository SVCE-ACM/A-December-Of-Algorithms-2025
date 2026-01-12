N = int(input())
width = len(bin(N)[2:])
for i in range(1, N + 1):
    decimal_val = str(i)
    octal_val = oct(i)[2:]
    hex_val = hex(i)[2:].upper()
    binary_val = bin(i)[2:]
    print(
        decimal_val.rjust(width),
        octal_val.rjust(width),
        hex_val.rjust(width),
        binary_val.rjust(width)
    )
