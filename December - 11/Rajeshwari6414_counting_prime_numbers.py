N = int(input())

if N <= 2:
    print(f"The count of prime numbers less than {N} is: 0")
else:
    is_prime = [True] * N
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(N ** 0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, N, i):
                is_prime[j] = False

    print(f"The count of prime numbers less than {N} is: {sum(is_prime)}")
