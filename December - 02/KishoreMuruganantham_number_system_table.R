input <- file("stdin", "r")
line <- readLines(input, n = 1)
n <- as.integer(line)

to_bin <- function(x) {
  if (x == 0) return("0")
  bits <- as.integer(intToBits(x)) 
  s <- paste(rev(bits), collapse="")
  s <- sub("^0+", "", s)
  if (s == "") return("0")
  return(s)
}

for (i in 1:n) {
  b <- to_bin(i)
  cat(sprintf("%5d %5o %5X %5s", i, i, i, b), "\n", sep = "")
}
