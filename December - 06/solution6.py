n=int(input("enter n:"))
if n%2==0:
  print("magic square is only posible for odd values of n")
else:
  square=[[0]*n for _ in range(n)]
  row=0
  col=n//2
  for num in range(1,n*n+1):
    new_row=(row-1)%n
    new_col=(col+1)%n
    if square[new_row][new_col]!=0:
      row=(row+1)%n
    else:
      row=new_row
      col=new_col
    square[row][col] = num # Assign the number to the current position
  M=n*(n*n+1)//2
  print("magic constant:",M)
  for r in square:
    print(*r)


[9]
4s
n=int(input("enter n:"))
if n%2==0:
  print("magic square is only posible for odd values of n")
else:
  square=[[0]*n for _ in range(n)]
  row=0
  col=n//2
  for num in range(1,n*n+1):
    new_row=(row-1)%n
    new_col=(col+1)%n
    if square[new_row][new_col]!=0:
      row=(row+1)%n
    else:
      row=new_row
      col=new_col
    square[row][col] = num # Assign the number to the current position
  M=n*(n*n+1)//2
  print("magic constant:",M)
  for r in square:
    print(*r)

enter n:7
magic constant: 175
29 38 47 7 9 18 27
37 46 6 8 17 26 35
45 5 14 16 25 34 36
4 13 15 24 33 42 44
12 21 23 32 41 43 3
20 22 31 40 49 2 11
28 30 39 48 1 10 19
