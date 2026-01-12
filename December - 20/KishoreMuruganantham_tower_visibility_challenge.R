input <- file("stdin", "r")
lines <- readLines(input)
n <- as.integer(lines[1])
h <- as.integer(unlist(strsplit(lines[2], "\\s+")))

res <- integer(n)
stack_arr <- integer(n)
top <- 0

for (i in n:1) {
  val <- h[i]
  while (top > 0 && stack_arr[top] <= val) {
    top <- top - 1
  }
  
  if (top > 0) {
    res[i] <- stack_arr[top]
  } else {
    res[i] <- -1
  }
  
  top <- top + 1
  stack_arr[top] <- val
}

cat(paste(res, collapse = " "), "\n", sep = "")
