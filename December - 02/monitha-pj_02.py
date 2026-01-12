n=int(input())
for i in range(1,n+1):
  print(i,oct(i)[2:],hex(i)[2:].upper(),bin(i)[2:],sep=" ")
  print()
