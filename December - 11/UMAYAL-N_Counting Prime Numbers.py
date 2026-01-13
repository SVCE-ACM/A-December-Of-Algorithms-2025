n = int(input())

if n <= 2:
    print(f"The count of prime numbers less than {n} is: 0")
else:
    sieve = [True] * n
    sieve[0] = sieve[1] = False

    for i in range(2, int(n**0.5) + 1):
        if sieve[i]:
            for j in range(i*i, n, i):
                sieve[j] = False

    print(f"The count of prime numbers less than {n} is:", sum(sieve))
