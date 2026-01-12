input <- file("stdin", "r")
line <- readLines(input, n = 1)
n <- as.integer(line)
i <- 1
squares <- c()
while (i * i <= n) {
  squares <- c(squares, i * i)
  i <- i + 1
}
cat(paste(squares, collapse = " "), "\n", sep = "")
cat(length(squares), "\n", sep = "")
