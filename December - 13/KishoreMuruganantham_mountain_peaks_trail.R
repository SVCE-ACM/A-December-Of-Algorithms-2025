input <- file("stdin", "r")
lines <- readLines(input)
n <- as.integer(lines[1])
arr <- as.integer(unlist(strsplit(lines[2], "\\s+")))

p <- integer(0)
if (n >= 3) {
  for (i in 2:(n - 1)) {
    if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
      p <- c(p, i - 1)
    }
  }
}

if (length(p) == 0) {
  cat("-1\n")
} else {
  cat(paste(p, collapse = " "), "\n", sep = "")
}
