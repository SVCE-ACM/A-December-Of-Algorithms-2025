# Input
N = int(input("Enter N: "))
arr = list(map(int, input("Enter array elements separated by space: ").split()))

duplicate = -1
missing = -1

# Use index marking
for i in range(N):
    index = abs(arr[i]) - 1
    if arr[index] < 0:
        duplicate = abs(arr[i])
    else:
        arr[index] = -arr[index]

# Find the missing number
for i in range(N):
    if arr[i] > 0:
        missing = i + 1
        break

print("Missing Number:", missing)
print("Duplicate Number:", duplicate)
