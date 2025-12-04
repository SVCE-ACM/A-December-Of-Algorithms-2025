num = int(input("Enter the number: "))
count = 0
for i in range (num):
  if i*i < num:
    print(num, end=" ")
    count += 1
print()
print(count)
