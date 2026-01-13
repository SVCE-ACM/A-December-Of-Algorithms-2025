# First Non-Repeating Character
s = input().strip()
freq = {}

for ch in s:
    freq[ch] = freq.get(ch, 0) + 1

ans = None
for ch in s:
    if freq[ch] == 1:
        ans = ch
        break

if ans:
    print(f"The first non-repeating character is: {ans}")
else:
    print("No non-repeating character found.")
