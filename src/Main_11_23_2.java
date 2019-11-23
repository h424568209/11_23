

import java.util.Stack;

public class Main_11_23_2 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    public void Mirrors(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){

            TreeNode node = stack.pop();
            TreeNode T = root.left;
            node.left = root.right;
            node.right = T;
            if(node.left !=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
    }
}

