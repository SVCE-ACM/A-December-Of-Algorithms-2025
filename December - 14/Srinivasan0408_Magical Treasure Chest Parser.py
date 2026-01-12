s = input().strip()
if s[0]=='"' and s[-1]=='"':
    s=s[1:-1]
if s[0] != '[':
    print(int(s))
    exit()
stack = []
num = ""
neg = False
for ch in s:
    if ch == '[':
        stack.append([])
    elif ch == '-':
        neg = True
    elif ch.isdigit():
        num += ch
    elif ch in ',]':
        if num != "":
            val = int(num) if not neg else -int(num)
            stack[-1].append(val)
            num = ""
            neg = False
        if ch == ']' and len(stack) > 1:
            val = stack.pop()
            stack[-1].append(val)
print(stack[0])