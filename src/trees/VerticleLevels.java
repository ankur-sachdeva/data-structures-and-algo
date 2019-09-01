package binary.tree;

/**
 * Created by ansachdeva on 11/27/18.
 */
public class VerticleLevels {

    static int prev = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(4);
        root.left.right.left = new Node(6);

        int level = -1;
        int currentLevel = 0;

        if(checkIfGivenLevelSorted(root, level, currentLevel)){
            System.out.print("sorted");
        }else{
            System.out.print("Unsorted");
        }
    }

    private static boolean checkIfGivenLevelSorted(Node root, int level, int currentLevel) {
        if(root == null)
            return true;

        if(currentLevel == level){
            if(root.val >= prev){
                prev = root.val;
            }else{
                return false;
            }
        }

        checkIfGivenLevelSorted(root.left, level, currentLevel-1);
        checkIfGivenLevelSorted(root.right, level, currentLevel+1);
        return false;
    }
}
