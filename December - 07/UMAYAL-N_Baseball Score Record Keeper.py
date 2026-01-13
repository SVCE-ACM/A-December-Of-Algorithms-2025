ops = input().strip("[]").replace('"', '').split(",")

stack = []

for op in ops:
    if op == "C":
        stack.pop()
    elif op == "D":
        stack.append(2 * stack[-1])
    elif op == "+":
        stack.append(stack[-1] + stack[-2])
    else:
        stack.append(int(op))

print(sum(stack))
