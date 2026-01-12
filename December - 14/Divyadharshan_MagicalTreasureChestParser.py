def parse(s):
    if s[0] != '[':
        return int(s)
    stack = []
    num = ""
    negative = False
    for ch in s:
        if ch == '[':
            stack.append([])
        elif ch == '-':
            negative = True
        elif ch.isdigit():
            num += ch
        elif ch == ',' or ch == ']':
            if num:
                value = int(num)
                if negative:
                    value = -value
                stack[-1].append(value)
                num = ""
                negative = False
            if ch == ']':
                completed = stack.pop()
                if stack:
                    stack[-1].append(completed)
                else:
                    return completed
print(parse(input().strip()))