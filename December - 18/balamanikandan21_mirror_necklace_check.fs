open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let n = 
            line1.Split('=') |> Array.last |> fun s -> s.Trim() |> int
            
        if n = 0 then
             printfn "The necklace is empty."
        else
             let line2 = Console.ReadLine()
             let beads = 
                 line2.Split('=') |> Array.last 
                 |> fun s -> s.Split([|' '|], StringSplitOptions.RemoveEmptyEntries) 
                 |> Array.map int
             
             let mutable mirrored = true
             for i in 0 .. n / 2 do
                 if beads.[i] <> beads.[n - 1 - i] then
                     mirrored <- false
                     
             if mirrored then
                 printfn "The necklace is mirrored."
             else
                 printfn "The necklace is not mirrored."
        0
