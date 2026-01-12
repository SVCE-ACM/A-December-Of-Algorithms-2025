input <- file("stdin", "r")
lines <- readLines(input)
n <- as.integer(lines[1])
scores <- as.integer(unlist(strsplit(lines[2], "\\s+")))

if (n == 0) {
  cat("0\n")
} else {
  candies <- rep(1, n)
  
  if (n > 1) {
    for (i in 2:n) {
      if (scores[i] > scores[i - 1]) {
        candies[i] <- candies[i - 1] + 1
      }
    }
    
    for (i in (n - 1):1) {
      if (scores[i] > scores[i + 1]) {
        candies[i] <- max(candies[i], candies[i + 1] + 1)
      }
    }
  }
  cat(sum(candies), "\n", sep = "")
}
