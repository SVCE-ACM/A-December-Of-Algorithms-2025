program royal_family_seating;

struct Node {
    val: u32,
    left: u32,
    right: u32,
}

function main(tree: [Node; 1000], root_idx: u32, size: u32) -> bool {
    if size == 0u32 {
        return true;
    }

    let mut queue: [u32; 1000] = [0u32; 1000];
    let mut front: u32 = 0u32;
    let mut rear: u32 = 1u32;
    queue[0u32] = root_idx;
    let mut flag: bool = false;

    while front < rear {
        let curr: u32 = queue[front];
        front = front + 1u32;
        
        let left_idx: u32 = tree[curr].left;
        let right_idx: u32 = tree[curr].right;

        if left_idx != 999999u32 {
            if flag {
                return false;
            }
            queue[rear] = left_idx;
            rear = rear + 1u32;
        } else {
            flag = true;
        }

        if right_idx != 999999u32 {
            if flag {
                return false;
            }
            queue[rear] = right_idx;
            rear = rear + 1u32;
        } else {
            flag = true;
        }
    }

    return true;
}
