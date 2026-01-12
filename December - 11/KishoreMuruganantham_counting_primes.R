input <- file("stdin", "r")
line <- readLines(input, n = 1)
n_str <- sub(".*Enter N:\\s*", "", line)
n <- as.integer(n_str)

count <- 0
if (n > 2) {
  limit <- n - 1
  is_prime <- rep(TRUE, limit)
  is_prime[1] <- FALSE
  
  max_i <- floor(sqrt(limit))
  for (i in 2:max_i) {
    if (is_prime[i]) {
      mults <- seq(i * i, limit, by = i)
      is_prime[mults] <- FALSE
    }
  }
  count <- sum(is_prime)
}

cat("The count of prime numbers less than ", n, " is: ", count, "\n", sep = "")
