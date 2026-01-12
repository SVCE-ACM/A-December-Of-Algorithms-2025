open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let n = int line1
        let line2 = Console.ReadLine()
        if String.IsNullOrWhiteSpace(line2) then
             printfn "0"
             0
        else
            let nums = line2.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
            let counts = Dictionary<int, int>()
            for x in nums do
                if counts.ContainsKey(x) then counts.[x] <- counts.[x] + 1
                else counts.[x] <- 1
                
            let sum = 
                counts 
                |> Seq.filter (fun kv -> kv.Value = 1) 
                |> Seq.sumBy (fun kv -> kv.Key)
            printfn "%d" sum
            0
