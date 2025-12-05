input <- scan("stdin", quiet = TRUE)
N <- input[1]
K <- input[2]
arr <- input[3:length(input)]

prefix <- 0
map <- new.env(hash = TRUE)

assign("0", 0, envir = map)

start <- -1
end <- -1

for(i in 1:N){
  prefix <- prefix + arr[i]
  key <- as.character(prefix - K)
  if(exists(key, envir = map)){
    start <- get(key, envir = map)
    end <- i - 1
    break
  }
  assign(as.character(prefix), i, envir = map)
}

cat(start, end)
