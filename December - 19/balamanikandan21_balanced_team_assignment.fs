open System

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
            let skills = line2.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
            let sum = Array.sum skills
            let target = sum / 2
            
            let dp = Array.create (target + 1) false
            dp.[0] <- true
            
            for s in skills do
                for j in target .. -1 .. s do
                    if dp.[j - s] then
                        dp.[j] <- true
            
            let found = 
                seq { target .. -1 .. 0 }
                |> Seq.tryFind (fun j -> dp.[j])
                
            match found with
            | Some s1 -> 
                let s2 = sum - s1
                printfn "%d" (Math.Abs(s1 - s2))
            | None -> printfn "%d" sum 
            0
