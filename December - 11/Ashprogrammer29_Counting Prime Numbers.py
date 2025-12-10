def count_primes(n):
    if n <= 2:
        return 0

    sieve = [True] * n
    sieve[0] = sieve[1] = False

    p = 2
    while p * p < n:
        if sieve[p]:
            for i in range(p * p, n, p):
                sieve[i] = False
        p += 1

    return sum(sieve)


N = int(input())
result = count_primes(N)
print(f"The count of prime numbers less than {N} is: {result}")
