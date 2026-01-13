let rec to_binary n =
  if n = 0 then ""
  else (to_binary (n / 2)) ^ (string_of_int (n mod 2))

let binary_string n =
  if n = 0 then "0" else to_binary n

let () =
  try
    let n = read_int () in
    for i = 1 to n do
      let bin = binary_string i in
      Printf.printf "%5d %5o %5X %5s\n" i i i bin
    done
  with End_of_file -> ()
