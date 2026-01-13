let () =
  try
    let n = read_int () in
    let rec aux i acc =
      let sq = i * i in
      if sq > n then acc
      else aux (i + 1) (sq :: acc)
    in
    let squares = List.rev (aux 1 []) in
    let rec print_list = function
      | [] -> ()
      | [x] -> Printf.printf "%d" x
      | x :: xs -> Printf.printf "%d " x; print_list xs
    in
    print_list squares;
    print_newline ();
    Printf.printf "%d\n" (List.length squares)
  with End_of_file -> ()
