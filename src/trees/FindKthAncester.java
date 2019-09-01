package trees;

public class FindKthAncester {

	static int k = 2;

	
	public static void main(String[] args){
		Node root = new Node(1); 
	    root.left = new Node(2); 
	    root.right = new Node(3); 
	    root.left.left = new Node(4); 
	    root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        int node = 3;
	    // print kth ancestor of given node
	    Node parent = kthAncestorDFS(root, node);
	      
	    // check if parent is not NULL, it means 
	    // there is no Kth ancestor of the node 
	    if (parent != null)
	        System.out.println("-1");
	}

	private static Node kthAncestorDFS(Node root, int node) {
		
		if(root == null){
			return null;
		}
		
		if(((root.val == node)
				|| (kthAncestorDFS(root.left, node)!=null)
				|| (kthAncestorDFS(root.right, node)!=null))){
			if(k>0){
				k--;
				return root;
			}
			else if(k==0){
				System.out.println("found: "+root.val);
			}
		}
		return null;
	}
}
