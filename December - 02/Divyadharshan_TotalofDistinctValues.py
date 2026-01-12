N = int(input())

for i in range(1,N+1):
    print(i, oct(i)[2:], hex(i).upper()[2:], bin(i)[2:])