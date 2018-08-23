import java.lang.invoke.SerializedLambda;

public class TreeNodeTestCasesMain {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(8);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(20);
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(9);
//
//        root.right.left.right = new TreeNode(14);
//        root.right.right.left = new TreeNode(17);

        //System.out.println(new IsBST().isBSTIterative(root);

//        TreeSerialization serial = new TreeSerialization();
//        String s = serial.serialize(root);
//        System.out.println(s);

//        TreeNode newRoot = serial.deserialize(s);
//        System.out.println(root.isIdentical(root, newRoot));
//        new PostOrderTraversal().postorderTraversalIter(newRoot);

//        new Traversal().preorderTraversalIter(root);
//        new Traversal().inorderTraversalIter(root);
//        // Test case for Delete in BST
//        String s = new TreeSerialization().serialize(root);
//        System.out.println(s);
//        System.out.println(new TreeSerialization().serialize(new RemoveInBST().delete(root, 10)));
        // // Test case for Delete in BST
        // TreeNode root = new TreeSerialization().deserialize("-1,-2,-6,-3,-4,#,#,-7,#,-5");
        // System.out.println(new MaxPathSum().maxPathSum(root));
//        // Test case for TargetPathSumVerticalPath
//        TreeNode root = new TreeSerialization().deserialize("3,-8,9,4,10,2,-5,1,-2");
//        System.out.println(new TargetPathSumVerticalPath().exist(root, 8));
//        // Test case for TargetPathSumVerticalPath
////        TreeNode root = new TreeSerialization().deserialize("3,-8,9,4,10,2,-5,1,-2");
////        System.out.println(new TargetPathSumVerticalPath().exist(root, 8));
//        int[] t = new int[] {1,4,3,11,8,5};
//        System.out.println(new TreeSerialization().serialize(new DeserializationBSTWithPost().reconstruct(t)));

        // Test case for Binary Tree Upside Down
        TreeSerialization TS = new TreeSerialization();
        BinaryTreeUpsideDown BD = new BinaryTreeUpsideDown();
        TreeNode root = TS.deserialize("4,2,#,1,3");
        System.out.println("The root is: " + TS.serialize(root));
        TreeNode upsideDown = BD.reverse(root);
        System.out.println("The result is: " + TS.serialize(upsideDown));
    }
}
