s = input().strip()
count = {}

# count occurrences
for ch in s:
    if ch in count:
        count[ch] += 1
    else:
        count[ch] = 1

# find first non-repeating
found = False
for ch in s:
    if count[ch] == 1:
        print("The first non-repeating character is:", ch)
        found = True
        break

if not found:
    print("No non-repeating character found.")
