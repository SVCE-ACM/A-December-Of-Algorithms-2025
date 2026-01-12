open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    let line2 = Console.ReadLine()
    
    let parseValues (s:string) = 
        let clean = 
            if s.Contains(":") then s.Split(':') |> Array.last
            else s
        clean.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
        
    let nums = parseValues line2
    let n = nums.Length
    let mutable left = 0
    let mutable right = n - 1
    let mutable first = true
    
    while left <= right do
        if not first then printf " "
        printf "%d" nums.[left]
        left <- left + 1
        first <- false
        
        if left <= right then
            printf " %d" nums.[right]
            right <- right - 1
            
    printfn ""
    0
