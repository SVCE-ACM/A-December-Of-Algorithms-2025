n=eval(input("ops="))
record=0
score=[]
for i in range(len(n)):
    try:
        record+=int(n[i])
        score.append(int(n[i]))
        
    except ValueError:
        if n[i]=='C':
            record-=score[-1]
            score.pop()
           
        elif n[i]=='D':
            last_element=score[-1]
            record+=last_element*2
            score.append(last_element*2)
    
        elif n[i]=='+':
            summ=score[-1]+score[-2]
            record+=summ
            score.append(summ)
            
print(record)
