#include <iostream>
#include <vector>
#include <string>

struct NestedChest {
    bool is_value;
    int value;
    std::vector<NestedChest> children;

    NestedChest() : is_value(false), value(0) {}
    NestedChest(int val) : is_value(true), value(val) {}
};

NestedChest parse(const std::string& s, size_t& pos) {
    if (s[pos] == '[') {
        NestedChest chest;
        pos++; 
        while (pos < s.length() && s[pos] != ']') {
            chest.children.push_back(parse(s, pos));
            if (s[pos] == ',') {
                pos++;
            }
        }
        pos++; 
        return chest;
    } else {
        size_t start = pos;
        while (pos < s.length() && (isdigit(s[pos]) || s[pos] == '-')) {
            pos++;
        }
        int val = std::stoi(s.substr(start, pos - start));
        return NestedChest(val);
    }
}

void print(const NestedChest& chest) {
    if (chest.is_value) {
        std::cout << chest.value;
    } else {
        std::cout << "[";
        for (size_t i = 0; i < chest.children.size(); ++i) {
            print(chest.children[i]);
            if (i < chest.children.size() - 1) {
                std::cout << ",";
            }
        }
        std::cout << "]";
    }
}

int main() {
    std::string s;
    if (std::getline(std::cin, s)) {
        if (s.size() >= 2 && s.front() == '"' && s.back() == '"') {
            s = s.substr(1, s.size() - 2);
        }
        
        size_t pos = 0;
        NestedChest result = parse(s, pos);
        print(result);
        std::cout << std::endl;
    }
    return 0;
}
