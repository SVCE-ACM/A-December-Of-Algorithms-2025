def find_first_unique_char(s):
    char_count = {}
    for char in s:
        char_count[char] = char_count.get(char, 0) + 1
    for char in s:
        if char_count[char] == 1:
            return f"The first non-repeating character is: {char}"
    
    return "No non-repeating character found."

user_input = input()
print(find_first_unique_char(user_input))