input <- file("stdin", "r")
lines <- readLines(input)

l1 <- sub(".*=\\s*", "", lines[1])
n <- as.integer(l1)

if (n == 0) {
  cat("The necklace is empty.\n")
} else {
  l2 <- sub(".*=\\s*", "", lines[2])
  beads <- as.integer(unlist(strsplit(l2, "\\s+")))
  beads <- beads[!is.na(beads)]
  
  if (length(beads) > 0 && all(beads == rev(beads))) {
    cat("The necklace is mirrored.\n")
  } else {
    cat("The necklace is not mirrored.\n")
  }
}
