input <- file("stdin", "r")
line <- readLines(input, n = 1)
line <- sub(".*=\\s*", "", line)
line <- gsub("\\[|\\]", "", line)
line <- gsub("\\s+", "", line)
parts <- unlist(strsplit(line, ","))
vals <- ifelse(parts == "null", NA, as.integer(parts))

valid <- TRUE
seen_null <- FALSE
for (v in vals) {
  if (is.na(v)) {
    seen_null <- TRUE
  } else {
    if (seen_null) {
      valid <- FALSE
      break
    }
  }
}
cat(tolower(as.character(valid)), "\n", sep = "")
