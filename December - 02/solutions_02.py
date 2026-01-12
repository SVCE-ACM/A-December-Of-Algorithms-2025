limit = int(input("Enter the limit: "))

for i in range (1,limit+1):
  print(i, end=" ")
  print(oct(i)[2:], end=" ")
  print(hex(i)[2:], end=" ")
  print(bin(i)[2:])
  print()
