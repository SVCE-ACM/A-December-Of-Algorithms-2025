input <- file("stdin", "r")
line <- readLines(input, n = 1)
if (grepl("^\".*\"$", line)) {
  line <- substr(line, 2, nchar(line) - 1)
}
line <- gsub(" ", "", line)

chars <- strsplit(line, "")[[1]]
pos <- 1

parse_recursive <- function() {
  if (pos > length(chars)) return(NULL)
  
  if (chars[pos] == '[') {
    pos <<- pos + 1
    lst <- list()
    if (chars[pos] == ']') {
      pos <<- pos + 1
      return(lst)
    }
    
    repeat {
      elem <- parse_recursive()
      lst <- c(lst, list(elem))
      
      if (pos > length(chars)) break
      if (chars[pos] == ']') {
        pos <<- pos + 1
        break
      } else if (chars[pos] == ',') {
        pos <<- pos + 1
      }
    }
    return(lst)
  } else {
    start <- pos
    while (pos <= length(chars) && grepl("[0-9-]", chars[pos])) {
      pos <<- pos + 1
    }
    num_str <- paste(chars[start:(pos - 1)], collapse = "")
    return(as.integer(num_str))
  }
}

stringify <- function(obj) {
  if (is.list(obj)) {
    if (length(obj) == 0) return("[]")
    inner <- sapply(obj, stringify)
    return(paste0("[", paste(inner, collapse = ","), "]"))
  } else {
    return(as.character(obj))
  }
}

res <- parse_recursive()
cat(stringify(res), "\n", sep = "")
