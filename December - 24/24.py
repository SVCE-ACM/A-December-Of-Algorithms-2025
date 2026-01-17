from collections import Counter
def first_non_repeating_char(s):
    freq = Counter(s)
    for ch in s:
        if freq[ch] == 1:
            return f"The first non-repeating character is: {ch}"
    return "No non-repeating character found."
if __name__ == "__main__":
    s = input().strip()
    result = first_non_repeating_char(s)
    print(result)
