print("Enter N:", end=" ")
N = int(input())

def is_prime(x):
    if x < 2:
        return False
    i = 2
    while i * i <= x:
        if x % i == 0:
            return False
        i += 1
    return True

count = 0
for num in range(2, N):
    if is_prime(num):
        count += 1

print(f"The count of prime numbers less than {N} is: {count}")