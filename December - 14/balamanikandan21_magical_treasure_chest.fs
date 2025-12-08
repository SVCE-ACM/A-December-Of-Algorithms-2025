open System
open System.Text

type NestedChest = 
    | Treasure of int
    | Compartment of NestedChest list
    
    override this.ToString() =
        match this with
        | Treasure v -> string v
        | Compartment list -> 
            "[" + (list |> List.map (fun t -> t.ToString()) |> String.concat ",") + "]"

[<EntryPoint>]
let main _ =
    let input = Console.ReadLine() 
    if String.IsNullOrWhiteSpace(input) then 0
    else
        let s = input.Trim().Replace("\"", "")
        
        let mutable i = 0
        let rec parseNested () : NestedChest =
            if i >= s.Length then Treasure 0 // Should not happen
            else if s.[i] = '[' then
                i <- i + 1 
                let items = ResizeArray<NestedChest>()
                while i < s.Length && s.[i] <> ']' do
                    items.Add(parseNested())
                    if i < s.Length && s.[i] = ',' then
                        i <- i + 1 
                i <- i + 1 
                Compartment (items |> Seq.toList)
            else
                let start = i
                if s.[i] = '-' then i <- i + 1
                while i < s.Length && Char.IsDigit(s.[i]) do
                    i <- i + 1
                if i > start then
                    let numStr = s.Substring(start, i - start)
                    Treasure (int numStr)
                else
                    // Handling weird case like empty string
                    Treasure 0

        if s.Length > 0 then
            let chest = parseNested()
            printfn "%s" (chest.ToString())
        0
