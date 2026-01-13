def first_non_repeating_char(s):
    freq = {}

  
    for ch in s:
        freq[ch] = freq.get(ch, 0) + 1

   
    for ch in s:
        if freq[ch] == 1:
            print(f"The first non-repeating character is: {ch}")
            return

    print("No non-repeating character found.")



s = input().strip()
first_non_repeating_char(s)
