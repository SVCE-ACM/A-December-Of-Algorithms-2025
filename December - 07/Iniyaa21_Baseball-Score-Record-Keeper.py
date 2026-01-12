ops = eval(input()) 
records = [] 

for op in ops:
    if op == "C":
        records.pop() 
    elif op == "+":
        first = records[-1]
        second = records[-2] 
        records.append(first + second)  
    elif op == "D":
        previous = records[-1]
        records.append(previous * 2)
    else:
        records.append(int(op))
print(sum(records))

