N = int(input())

w_dec = len(str(N))
w_oct = len(oct(N)[2:])
w_hex = len(hex(N)[2:].upper())
w_bin = len(bin(N)[2:])

for i in range(1, N + 1):
    dec = str(i)
    octal = oct(i)[2:]
    hexa = hex(i)[2:]
    binary = bin(i)[2:]
    
    print(
        dec.rjust(w_dec + 4),
        octal.rjust(w_oct + 4),
        hexa.rjust(w_hex + 4),
        binary.rjust(w_bin + 4)
    )
