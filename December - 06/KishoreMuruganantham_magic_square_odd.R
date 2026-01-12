input <- file("stdin", "r")
line <- readLines(input, n = 1)
n_str <- sub(".*Enter n:\\s*", "", line)
n <- as.integer(n_str)

if (n %% 2 == 0) {
  cat("Magic square is only possible for odd values of n.\n")
} else {
  magic_const <- (n * (n^2 + 1)) / 2
  cat("Magic constant: ", magic_const, "\n", sep = "")
  
  grid <- matrix(0, nrow = n, ncol = n)
  r <- 1
  c <- (n + 1) / 2
  
  for (num in 1:(n^2)) {
    grid[r, c] <- num
    next_r <- r - 1
    next_c <- c + 1
    
    if (next_r < 1) next_r <- n
    if (next_c > n) next_c <- 1
    
    if (grid[next_r, next_c] != 0) {
      r <- r + 1
      if (r > n) r <- 1
    } else {
      r <- next_r
      c <- next_c
    }
  }
  
  for (i in 1:n) {
    cat(paste(grid[i, ], collapse = " "), "\n", sep = "")
  }
}
