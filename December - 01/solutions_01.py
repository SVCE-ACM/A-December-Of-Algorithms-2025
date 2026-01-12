num = int(input("Enter the number: "))
count = 0
for i in range (1,num):
  if i*i < num:
    print(num, end=" ")
    count += 1
print()
print(count)
