input <- file("stdin", "r")
s <- readLines(input, n = 1)
chars <- strsplit(s, "")[[1]]
tbl <- table(chars)

found <- FALSE
res <- ""
for (c in chars) {
  if (tbl[c] == 1) {
    found <- TRUE
    res <- c
    break
  }
}

if (found) {
  cat("The first non-repeating character is: ", res, "\n", sep = "")
} else {
  cat("No non-repeating character found.\n")
}
