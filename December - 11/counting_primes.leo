program counting_primes;

function main(n: u32) -> u32 {
    if n <= 2u32 {
        return 0u32;
    }

    let mut sieve: [bool; 1000000] = [true; 1000000];
    sieve[0u32] = false;
    sieve[1u32] = false;

    let mut i: u32 = 2u32;
    while i * i < n {
        if sieve[i] {
            let mut j: u32 = i * i;
            while j < n {
                sieve[j] = false;
                j = j + i;
            }
        }
        i = i + 1u32;
    }

    let mut count: u32 = 0u32;
    let mut k: u32 = 2u32;
    while k < n {
        if sieve[k] {
            count = count + 1u32;
        }
        k = k + 1u32;
    }

    return count;
}
