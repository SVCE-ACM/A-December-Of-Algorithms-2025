from collections import Counter

s = input().strip()
freq = Counter(s)

for ch in s:
    if freq[ch] == 1:
        print(f"The first non-repeating character is: {ch}")
        break
else:
    print("No non-repeating character found.")
