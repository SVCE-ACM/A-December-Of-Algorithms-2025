input <- file("stdin", "r")
lines <- readLines(input)
vals <- as.integer(unlist(strsplit(lines[2], "\\s+")))
tbl <- table(vals)
uniques <- as.integer(names(tbl)[tbl == 1])
if (length(uniques) == 0) {
  cat("0\n")
} else {
  cat(sum(uniques), "\n", sep = "")
}
