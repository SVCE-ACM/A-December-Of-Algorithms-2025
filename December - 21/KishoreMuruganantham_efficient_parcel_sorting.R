input <- file("stdin", "r")
lines <- readLines(input)
vals <- as.integer(unlist(strsplit(lines[2], "\\s+")))
cat(paste(sort(vals), collapse = " "), "\n", sep = "")
