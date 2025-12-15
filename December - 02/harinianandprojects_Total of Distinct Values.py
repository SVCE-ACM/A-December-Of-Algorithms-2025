def convert_base(value, base_value):
    symbols = "0123456789ABCDEF"
    result_str = ""
    
    while value > 0:
        digit = value % base_value
        result_str = symbols[digit] + result_str
        value //= base_value
    return result_str or "0"
    
limit = int(input())
width = len(convert_base(limit, 2))

for number in range(1, limit + 1):
    print(
        convert_base(number, 10).rjust(width),
        convert_base(number, 8).rjust(width),
        convert_base(number, 16).rjust(width),
        convert_base(number, 2).rjust(width)
    )
