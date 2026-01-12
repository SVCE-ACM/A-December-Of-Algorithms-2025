n = int(input("Enter the size: "))
arr =[]
count = [0]*999

for i in range(n):
    v = int(input("Enter the value: "))
    arr.append(v)
  
for i in range(len(arr)):
    count[arr[i]] += 1 

sum1 = 0
for i in range(len(count)):
    if count[i] == 1:
        sum1 += i
print(sum1)



