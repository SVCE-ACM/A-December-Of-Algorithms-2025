def baseball_score(ops):
    
    new_ops=[]
    
    for j in range (len(ops)):
        op = ops[j]
        
        if op.lstrip("-").isdigit():
            new_ops.append(int(op))
            
        elif op == "C" or op == "c":
            if new_ops:
                new_ops.pop()
                
        elif op == "D" or op == "d":
            new_ops.append(2*new_ops[-1])
            
        elif op == "+":
            if len(new_ops) >= 2:
                new_ops.append(new_ops[-1] + new_ops[-2])
                
    print(sum(new_ops))
    
n = int(input("Enter the number of elements: "))
ops = []

for i in range(n):
  v = str(input("Enter the value: "))
  ops.append(v)

reference = ["D","C","+"]

if ops[0] in reference or ops[1] == "+":
    print("Invalid entry at first or second position")

else:
    baseball_score(ops)
  
