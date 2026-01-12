input <- file("stdin", "r")
lines <- readLines(input)

parse_line <- function(l) {
  l <- sub(".*=\\s*", "", l)
  l <- gsub("\\[|\\]", "", l)
  as.integer(unlist(strsplit(l, ",")))
}

students <- parse_line(lines[1])
sandwiches <- parse_line(lines[2])

count1 <- sum(students == 1)
count0 <- sum(students == 0)

for (s in sandwiches) {
  if (s == 0) {
    if (count0 > 0) {
      count0 <- count0 - 1
    } else {
      break
    }
  } else {
    if (count1 > 0) {
      count1 <- count1 - 1
    } else {
      break
    }
  }
}

cat(count0 + count1, "\n", sep = "")
