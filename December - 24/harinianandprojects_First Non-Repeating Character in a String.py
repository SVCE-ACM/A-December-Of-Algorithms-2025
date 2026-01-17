s = input().strip()
freq = {}
for ch in s:
    if ch in freq:
        freq[ch] += 1
    else:
        freq[ch] = 1
found = False
for ch in s:
    if freq[ch] == 1:
        print("The first non-repeating character is:", ch)
        found = True
        break
if not found:
    print("No non-repeating character found.")
