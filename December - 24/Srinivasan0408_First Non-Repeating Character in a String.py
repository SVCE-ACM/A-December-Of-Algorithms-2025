s = input()
freq = {}
for ch in s:
    if ch not in freq:
        freq[ch] = 1
    else:
        freq[ch] += 1
ans = None
for ch in s:
    if freq[ch] == 1:
        ans = ch
        break

if ans is None:
    print("No non-repeating character found")
else:
    print("The first non-repeating character is:", ans)