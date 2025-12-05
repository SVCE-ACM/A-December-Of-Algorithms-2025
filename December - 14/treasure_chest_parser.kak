define-command treasure-chest-parser %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        {
            s=$0
            gsub(/^"|"$/, "", s)
            print "echo " s
        }'
    }
}
