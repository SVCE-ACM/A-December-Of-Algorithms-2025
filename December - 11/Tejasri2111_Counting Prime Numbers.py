def countPrimes(N):
    if N <= 2:
        return 0
    
    # Initialize a list to mark prime numbers
    is_prime = [True] * N
    is_prime[0] = is_prime[1] = False  # 0 and 1 are not prime
    
    for i in range(2, int(N**0.5) + 1):
        if is_prime[i]:
            for j in range(i*i, N, i):
                is_prime[j] = False
    
    # Count primes
    return sum(is_prime)

# Input
N = int(input("Enter a non-negative integer N: "))
result = countPrimes(N)
print("The count of prime numbers less than", N, "is:", result)
