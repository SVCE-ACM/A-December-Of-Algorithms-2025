#include <iostream>
#include <vector>
#include <string>
#include <variant>

struct NestedChest {
    bool is_int;
    int val;
    std::vector<NestedChest> children;
    
    NestedChest(int v) : is_int(true), val(v) {}
    NestedChest() : is_int(false), val(0) {}
    
    void print() const {
        if (is_int) {
            std::cout << val;
        } else {
            std::cout << "[";
            for(size_t i=0; i<children.size(); ++i) {
                children[i].print();
                if (i < children.size() - 1) std::cout << ",";
            }
            std::cout << "]";
        }
    }
};

NestedChest parse(const std::string& s, int& pos) {
    if (s[pos] == '[') {
        NestedChest comp;
        pos++; 
        while (pos < s.length() && s[pos] != ']') {
            comp.children.push_back(parse(s, pos));
            if (s[pos] == ',') pos++;
        }
        pos++; 
        return comp;
    } else {
        int start = pos;
        while(pos < s.length() && (isdigit(s[pos]) || s[pos] == '-')) {
            pos++;
        }
        std::string num_str = s.substr(start, pos - start);
        return NestedChest(std::stoi(num_str));
    }
}

int main() {
    std::string s;
    if (std::cin >> s) {
        if (s.size() >= 2 && s.front() == '"' && s.back() == '"') {
            s = s.substr(1, s.size()-2);
        }
        
        int pos = 0;
        NestedChest result = parse(s, pos);
        result.print();
        std::cout << std::endl;
    }
    return 0;
}
