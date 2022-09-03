/*https://leetcode.com/problems/binary-tree-level-order-traversal/

102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal
of its nodes' values. (i.e., from left to right, level by level).
*/

package leetcode;

import java.util.*;

public class Leet102_BinaryTree_LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodeValues = new ArrayList<>();

        Queue<Queue<TreeNode>> nodesToVisit = new LinkedList<>();

        if (root != null){
            Queue<TreeNode> start = new LinkedList<>();
            start.add(root);
            nodesToVisit.add(start);
        }

        while (!nodesToVisit.isEmpty()){
            Queue<TreeNode> currentLevel = nodesToVisit.remove();
            List<Integer> currentValues = new ArrayList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();

            while (!currentLevel.isEmpty()){
                TreeNode currentNode = currentLevel.remove();
                if (currentNode.left != null){
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null){
                    nextLevel.add(currentNode.right);
                }
                currentValues.add(currentNode.val);
            }
            if (!nextLevel.isEmpty()){
                nodesToVisit.add(nextLevel);
            }
            if (!currentValues.isEmpty()){
                nodeValues.add(currentValues);
            }
        }
        return nodeValues;
    }
}
