open System

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line) then 0
    else
        let parts = 
            line
                .Replace("stones", "")
                .Replace("=", "")
                .Replace("[", "")
                .Replace("]", "")
                .Split([|','; ' '|], StringSplitOptions.RemoveEmptyEntries)
                |> Array.map int
        
        let n = parts.Length
        let mutable maxReach = 0
        let mutable possible = true
        let mutable i = 0
        
        while i < n && possible do
             if i > maxReach then
                 possible <- false
             else
                 maxReach <- Math.Max(maxReach, i + parts.[i])
                 if maxReach >= n - 1 then i <- n
                 else i <- i + 1
                 
        if possible && maxReach >= n - 1 then
            printfn "true"
        else
            printfn "false"
        0
