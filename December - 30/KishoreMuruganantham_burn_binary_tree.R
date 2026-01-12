input <- file("stdin", "r")
lines <- readLines(input)

root_idx <- grep("root", lines)
target_idx <- grep("Target", lines)

if (length(root_idx) > 0) {
  root_line <- lines[root_idx[1]]
  line_r <- sub(".*=\\s*", "", root_line)
  line_r <- gsub("\\[|\\]", "", line_r)
  vals <- unlist(strsplit(line_r, ","))
  vals <- gsub("\\s+", "", vals)
} else {
  vals <- character(0)
}

if (length(target_idx) > 0) {
  t_line <- lines[target_idx[1]]
  target <- as.integer(sub(".*=\\s*", "", t_line))
} else {
  target <- 0
}

adj <- new.env(hash = TRUE)

if (length(vals) > 0 && vals[1] != "null") {
  root_val <- as.integer(vals[1])
  q <- list(root_val)
  head <- 1
  idx <- 2
  
  while (head <= length(q) && idx <= length(vals)) {
    curr <- q[[head]]
    head <- head + 1
    
    add_edge <- function(u, v) {
      if (is.null(adj[[as.character(u)]])) adj[[as.character(u)]] <- c()
      adj[[as.character(u)]] <- c(adj[[as.character(u)]], v)
      if (is.null(adj[[as.character(v)]])) adj[[as.character(v)]] <- c()
      adj[[as.character(v)]] <- c(adj[[as.character(v)]], u)
    }
    
    if (idx <= length(vals)) {
      val <- vals[idx]
      idx <- idx + 1
      if (val != "null") {
        v <- as.integer(val)
        add_edge(curr, v)
        q <- c(q, list(v))
      }
    }
    
    if (idx <= length(vals)) {
      val <- vals[idx]
      idx <- idx + 1
      if (val != "null") {
        v <- as.integer(val)
        add_edge(curr, v)
        q <- c(q, list(v))
      }
    }
  }
}

visited <- new.env(hash = TRUE)
q <- list(target)
visited[[as.character(target)]] <- TRUE

while (length(q) > 0) {
  level <- integer(0)
  sz <- length(q)
  
  new_q <- list()
  
  for (item in q) {
    u <- item
    level <- c(level, u)
    
    nbs <- adj[[as.character(u)]]
    for (nb in nbs) {
      if (is.null(visited[[as.character(nb)]])) {
        visited[[as.character(nb)]] <- TRUE
        new_q <- c(new_q, list(nb))
      }
    }
  }
  cat(paste(level, collapse = ", "), "\n", sep = "")
  q <- new_q
}
