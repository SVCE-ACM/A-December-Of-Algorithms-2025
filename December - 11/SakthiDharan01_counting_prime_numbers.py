import sys

def count_primes(n):
    if n <= 2:
        return 0
    sieve = [True] * n
    sieve[0] = sieve[1] = False
    p = 2
    while p * p < n:
        if sieve[p]:
            step = p
            start = p * p
            sieve[start:n:step] = [False] * len(range(start, n, step))
        p += 1
    return sum(sieve)

def solve():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    print(f"The count of prime numbers less than {n} is: {count_primes(n)}")

if __name__ == "__main__":
    solve()
