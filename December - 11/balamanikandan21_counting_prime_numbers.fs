open System

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    let n = 
        if line.Contains(":") then
            let raw = line.Split(':') |> Array.last
            let filtered = raw |> Seq.filter Char.IsDigit |> Seq.toArray |> String
            int filtered
        else
            int line
    
    let mutable count = 0
    if n > 2 then
        let isPrime = Array.create n true
        isPrime.[0] <- false
        isPrime.[1] <- false
        
        let limit = int (Math.Sqrt(float (n - 1)))
        for i in 2 .. limit do
            if isPrime.[i] then
                let mutable j = i * i
                while j < n do
                    isPrime.[j] <- false
                    j <- j + i
        
        for i in 2 .. n - 1 do
            if isPrime.[i] then count <- count + 1
            
    printfn "The count of prime numbers less than %d is: %d" n count
    0
