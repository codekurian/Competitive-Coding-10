/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//https://leetcode.com/problems/find-leaves-of-binary-tree/

class FindLeavesInATree {
    List<List<Integer>>  result ;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        //result.add(new ArrayList<>());
        dfsHelper(root);
        return result;
    }
    //TC:O(N)
    //SC: O(N)
    public int  dfsHelper(TreeNode node){

        //base condition
        if(node == null){
            return 0;
        }




        int left = dfsHelper(node.left);
        int right = dfsHelper(node.right);

        //

        int height = 1 + Math.max(left,right);

        if(result.size() < height){
            List<Integer> newList = new ArrayList<>();
            result.add(newList);
        }
        List<Integer> heightList = result.get(height-1);
        int nodeVal = node.val;
        heightList.add(nodeVal);
        //result.add(heightList);

        return height;

    }
}