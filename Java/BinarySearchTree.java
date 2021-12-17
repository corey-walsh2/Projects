class BinarySearchTree { 
  
    //node class
    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
    
    Node root; 

    BinarySearchTree() {  
        root = null;  
    } 
    
    //Insert method
    void insert(int key) { 
       root = recIns(root, key); 
    } 
    //recursively insert
    Node recIns(Node root, int key) { 
  
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        if (key < root.key){
            root.left = recIns(root.left, key); 
        }
        else if (key > root.key){
            root.right = recIns(root.right, key); 
        }
        return root; 
    } 
    
    //Delete method
    void delete(int key) 
    { 
        root = recDel(root, key); 
    }  
    //recursively delete a node
    Node recDel(Node root, int key) 
    { 
               
        if (root == null){ 
            return root; 
        }     
        if (key < root.key){
            root.left = recDel(root.left, key);
        } 
        else if (key > root.key){
            root.right = recDel(root.right, key); 
        }     
        else{ 
            if (root.left == null){ 
                return root.right; 
            }
            else if (root.right == null) {
                return root.left;  
            }
            root.key = minVal(root.right); 
            root.right = recDel(root.right, root.key); 
        }  
        return root; 
    } 
    
    //find the min value ( for delete )
    int minVal(Node root) 
    { 
        int val = root.key; 
        while (root.left != null) 
        { 
            val = root.left.key; 
            root = root.left; 
        } 
        return val; 
    } 
    
    //dumptree method
    void dumpTree() 
    { 
        recDump(root); 
        System.out.println();
    } 
    //recursively print tree
    void recDump(Node root){ 
        if (root != null) 
        { 
            
            recDump(root.left); 
            System.out.print(root.key + " "); 
            recDump(root.right);                  
        } 
    }    
  
    public static void main(String[] args) { 
        BinarySearchTree t = new BinarySearchTree(); 
  
        t.insert(20); 
        t.insert(10); 
        t.insert(30); 
        t.insert(5); 
        t.insert(7); 
        t.insert(21); 
        t.dumpTree(); 
        t.delete(20); 
        t.delete(21);
        t.dumpTree();
        t.delete(35);   
        t.dumpTree(); 
    } 
} 