open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let s = Console.ReadLine()
    if String.IsNullOrWhiteSpace(s) then 0
    else
        let counts = Dictionary<char, int>()
        for c in s do
            if counts.ContainsKey(c) then counts.[c] <- counts.[c] + 1
            else counts.[c] <- 1
            
        let mutable found = '\000'
        let mutable done_ = false
        
        for c in s do
            if not done_ && counts.[c] = 1 then
                found <- c
                done_ <- true
                
        if done_ then
            printfn "The first non-repeating character is: %c" found
        else
            printfn "No non-repeating character found."
        0
