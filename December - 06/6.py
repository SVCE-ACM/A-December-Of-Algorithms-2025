#Magic square of odd number
"""You are given a positive odd integer n (1, 3, 5, 7, …). Your task is to generate a magic
square of order n × n.

A magic square is a grid filled with numbers from 1 to n² such that:
- Every row,
- Every column, and
- Both main diagonals
have the same sum, known as the magic constant (M).

The magic constant for an odd-order magic square is:
M = (n(n² + 1)) / 2

If the user enters an even value for n, the program should output:
"Magic square is only possible for odd values of n."
Input Format:
Enter the value of n (order of the magic square): An odd integer.
If n is odd, compute M and construct the magic square.
If n is even, display the error message.
Output Format:
If n is even:
Magic square is only possible for odd values of n.

If n is odd:
Magic constant: M
<n × n magic square grid>"""

def generate_magic_square(n):
    if n % 2 == 0:
        return "Magic square is only possible for odd values of n."
    magic_square = [[0] * n for _ in range(n)]
    i, j = 0, n // 2
    for num in range(1, n*n + 1):
        magic_square[i][j] = num
        new_i, new_j = (i - 1) % n, (j + 1) % n
        if magic_square[new_i][new_j]:
            i = (i + 1) % n
        else:
            i, j = new_i, new_j

    M = n * (n**2 + 1) // 2
  
    print("Magic constant:", M)
    for row in magic_square:
        print(" ".join(str(x).rjust(2) for x in row))

n = int(input())
generate_magic_square(n)
