package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet589_Nary_Tree_Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<>();

        if (root != null){
            output.add(root.val);
            for (Node node : root.children){
                output.addAll(preorder(node));
            }
        }

        return output;
    }
}
