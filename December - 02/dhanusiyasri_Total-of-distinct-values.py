n = int(input())
width = len(bin(n)) - 2
for i in range(1, n + 1):
        dec = str(i)
        octal = oct(i)[2:]        
        hexa = hex(i)[2:].upper() 
        binary = bin(i)[2:]       
        print(f"{dec:>{width}} {octal:>{width}} {hexa:>{width}} {binary:>{width}}")

