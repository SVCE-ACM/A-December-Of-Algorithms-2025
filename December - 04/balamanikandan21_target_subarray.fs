open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let parts = line1.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int64
        let n = int parts.[0]
        let k = parts.[1]
        
        let line2 = Console.ReadLine()
        let nums = 
            if String.IsNullOrWhiteSpace(line2) then [||]
            else line2.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int64
            
        let map = Dictionary<int64, int>()
        map.[0L] <- -1
        let mutable currentSum = 0L
        let mutable found = false
        let mutable i = 0
        
        while i < n && not found do
            currentSum <- currentSum + nums.[i]
            if map.ContainsKey(currentSum - k) then
                printfn "%d %d" (map.[currentSum - k] + 1) i
                found <- true
            else
                if not (map.ContainsKey(currentSum)) then
                    map.[currentSum] <- i
            i <- i + 1
            
        if not found then
            printfn "-1 -1"
        0
