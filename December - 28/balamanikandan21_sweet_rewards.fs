open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let n = int line1
        let line2 = Console.ReadLine()
        let scores = line2.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
        
        let candies = Array.create n 1
        
        for i in 1 .. n - 1 do
            if scores.[i] > scores.[i-1] then
                candies.[i] <- candies.[i-1] + 1
        
        for i in n - 2 .. -1 .. 0 do
            if scores.[i] > scores.[i+1] then
                candies.[i] <- Math.Max(candies.[i], candies.[i+1] + 1)
                
        let total = Array.sum candies
        printfn "%d" total
        0
