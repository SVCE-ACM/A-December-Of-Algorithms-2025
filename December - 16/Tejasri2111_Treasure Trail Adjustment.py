# taking input for linked list
elements = list(map(int, input("Enter the linked list elements: ").split()))

# taking input for n
n = int(input("Enter n: "))

length = len(elements)

# index to remove from start
remove_index = length - n

# removing the element
if 0 <= remove_index < length:
    elements.pop(remove_index)

# printing updated linked list
print("Updated linked list:")
for i in elements:
    print(i, end=" ")
