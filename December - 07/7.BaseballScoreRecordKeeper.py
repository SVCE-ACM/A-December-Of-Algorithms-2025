def calPoints(operations):
scores = []
for op in operations:
if op == "C":
scores.pop()
elif op == "D":
scores.append(2 * scores[-1])
elif op == "+":
scores.append(scores[-1] + scores[-2])
else:
scores.append(int(op))
return sum(scores)
operations = input("Enter operations separated by spaces: ").split()
total = calPoints(operations)
print("Total score:", total)
