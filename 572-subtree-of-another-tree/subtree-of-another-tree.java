class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) return false ;
        if(check(root,subRoot)) return true ;
        return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot) ;
    }
    public boolean check(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null) return true ;
        if(root1 == null || root2 == null) return false ;
        if(root1.val != root2.val) return false ;
        boolean r1 = check(root1.left,root2.left) ;
        boolean r2 = check(root1.right,root2.right);
        return r1 && r2 ;
    }
}