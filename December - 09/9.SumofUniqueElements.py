N = int(input("Enter the size of the array: "))
arr = list(map(int, input("Enter the array elements separated by space: ").split()))
freq = {}
for num in arr:
    if num in freq:
        freq[num] += 1
    else:
        freq[num] = 1
unique_sum = 0
for key in freq:
    if freq[key] == 1:
        unique_sum += key
print("Sum of unique elements:", unique_sum)
