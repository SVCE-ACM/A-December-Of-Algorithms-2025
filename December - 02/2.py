#code for converting integer to bin, oct, hex
def convert_n(n):
    width = len(bin(n)[2:])
    for i in range(1, n+1):
        print(f"{str(i).rjust(width)}\t"
              f"{oct(i)[2:].rjust(width)}\t"
              f"{hex(i)[2:].upper().rjust(width)}\t"
              f"{bin(i)[2:].rjust(width)}\t"
              )
n = int(input().strip())
convert_n(n)
