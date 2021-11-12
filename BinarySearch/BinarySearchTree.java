
public class BinarySearchTree {

	class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			right = null;
			left = null;
		}
	}
	Node root;
	BinarySearchTree(){
		this.root = null;
	}

	
	void insert(int n) {
		this.root  = insertRec(this.root, n);
	}
	Node insertRec(Node root, int n) {

		if(root == null) {
			root = new Node(n);
			return root;
		}
		if(n>root.data) 
			root.right = insertRec(root.right, n);
			
		
		if(n<root.data)
			root.left = insertRec(root.left, n);
		return root;
	}
	
	void inorder() {
		inorderRec(this.root);
	}
	
	void inorderRec(Node root) {
		if(root != null) {
			inorderRec(root.left);
			System.out.println(root.data);
			inorderRec(root.right);
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree tree = new BinarySearchTree();
		 
       
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);


        tree.inorder();

	}

}
