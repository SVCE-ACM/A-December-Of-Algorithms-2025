open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let n = int line1
        let line2 = Console.ReadLine()
        let nums = line2.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
        
        let mutable i = 0
        while i < nums.Length do
            let correctIdx = nums.[i] - 1
            if nums.[i] <> nums.[correctIdx] then
                let temp = nums.[i]
                nums.[i] <- nums.[correctIdx]
                nums.[correctIdx] <- temp
            else
                i <- i + 1
        
        let mutable missing = -1
        let mutable duplicate = -1
        
        for j in 0 .. nums.Length - 1 do
            if nums.[j] <> j + 1 then
                duplicate <- nums.[j]
                missing <- j + 1
                
        printfn "Missing Number: %d" missing
        printfn "Duplicate Number: %d" duplicate
        0
