open System

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line) then 0
    else
        let parts = line.Split([|','; '['; ']'; '='; ' '|], StringSplitOptions.RemoveEmptyEntries) 
        let allInts = 
            parts 
            |> Array.choose (fun s -> 
                match System.Int32.TryParse(s) with
                | true, v -> Some v
                | _ -> None)
                
        if allInts.Length < 2 then 0
        else
            let nVal = allInts.[allInts.Length - 1]
            let listVals = allInts.[0 .. allInts.Length - 2]
            
            let len = listVals.Length
            let removeIdx = len - nVal
            
            printf "["
            let mutable printedCount = 0
            for i in 0 .. len - 1 do
                if i <> removeIdx then
                    if printedCount > 0 then printf ","
                    printf "%d" listVals.[i]
                    printedCount <- printedCount + 1
            printfn "]"
            0
