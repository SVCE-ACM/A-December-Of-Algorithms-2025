from collections import Counter

# Input
N = int(input("Enter size of array: "))
arr = list(map(int, input("Enter array elements separated by space: ").split()))

# Count frequency of each element
freq = Counter(arr)

# Sum elements that appear exactly once
unique_sum = sum(num for num, count in freq.items() if count == 1)

print("Sum of unique elements:", unique_sum)
