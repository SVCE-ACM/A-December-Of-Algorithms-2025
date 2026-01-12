input <- file("stdin", "r")
line <- readLines(input, n = 1)

parts <- strsplit(line, "n\\s*=")[[1]]
head_str <- parts[1]
n_str <- parts[2]

head_str <- sub(".*=\\s*", "", head_str)
head_str <- gsub("\\[|\\]", "", head_str)
head_str <- gsub(",\\s*$", "", head_str)
vals <- as.integer(unlist(strsplit(head_str, ",")))
if (length(vals) == 1 && is.na(vals[1])) vals <- integer(0)

n <- as.integer(n_str)

sz <- length(vals)
remove_idx <- sz - n + 1

if (remove_idx >= 1 && remove_idx <= sz) {
  vals <- vals[-remove_idx]
}

cat("[", paste(vals, collapse = ","), "]\n", sep = "")
