input_str = input().strip()
n = int(input_str.split("=")[1].strip())

if n == 0:
    print("The necklace is empty.")
else:
    input_str = input().strip()
    beads_str = input_str.split("=")[1].strip()
    beads = list(map(int, beads_str.split()))
    
    is_palindrome = True
    left = 0
    right = n - 1
    
    while left < right:
        if beads[left] != beads[right]:
            is_palindrome = False
            break
        left += 1
        right -= 1
    
    if is_palindrome:
        print("The necklace is mirrored.")
    else:
        print("The necklace is not mirrored.")