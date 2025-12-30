word = str(input("Enter a word: "))
flag = 0
for i in word:
    if word.count(i) == 1:
        print("The first non-repeating character is: ",i)
        flag = 1
        break
if flag == 0:
    print("No non-repeating characters found")
