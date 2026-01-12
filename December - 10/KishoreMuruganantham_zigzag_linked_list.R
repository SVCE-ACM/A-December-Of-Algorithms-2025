input <- file("stdin", "r")
lines <- readLines(input)
nums_lines <- grep("[0-9]", lines)
if (length(nums_lines) >= 2) {
  line_v <- lines[nums_lines[2]]
  if (grepl(":", line_v)) line_v <- sub(".*:\\s*", "", line_v)
  vals <- as.integer(unlist(strsplit(line_v, "\\s+")))
} else {
  vals <- as.integer(unlist(strsplit(lines[2], "\\s+")))
}

res <- integer(0)
l <- 1
r <- length(vals)
while (l <= r) {
  res <- c(res, vals[l])
  if (l != r) {
    res <- c(res, vals[r])
  }
  l <- l + 1
  r <- r - 1
}

cat(paste(res, collapse = " "), "\n", sep = "")
