
class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}


class BinarySearchTree{

   Node root;


   /**
    * inserts a node into the tree
    * @param value wich is the valud that the node will hold
    */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;

         while(true){
            parent = current;

            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
         }//closing while

      }//closing main if-else
   }


   /**
    * pre-order traversal
    * @param root the root of the tree will be use in the method
    */
   public void preOrderTraversal(Node root){
      //base case
      if(root == null){return;}

      System.out.print(root.value+" ");
      //go left recursively
      preOrderTraversal(root.left);
      //go right recursively
      preOrderTraversal(root.right);
   }


   /**
    * in-order traversal
    * @param root the root of the tree will be use in the method
    */
   public void inOrderTraversal(Node root){
      //base case
      if(root == null){return;}

      //go left recursively
      inOrderTraversal(root.left);
      //process the root
      System.out.print(root.value+" ");
      //go right recursively
      inOrderTraversal(root.right);
   }


   /**
    * post-order traversal
    * @param root the root of the tree will be use in the method
    */
   public void postOrderTraversal(Node root){
      //base case
       if(root == null){return;}

      //go left recursively
      postOrderTraversal(root.left);
      //go right recursively
      postOrderTraversal(root.right);
      //process the root
      System.out.print(root.value+" ");
   }


   /**
    *   a method to find the node in the tree
    *   with a specific value
     * @param root the root of the tree will be use in the method
    * @param key the vaiue we need to find
    * @return  true if the key found in the tree, and false if the key not in the tree
    */
   public boolean find(Node root, int key){
      //base case
      if(root == null){return false;}

      if(root.value == key){
         return true;
      }else if(key < root.value){
         return find(root.left, key);
      }else{
         return find(root.right, key);
      }
   }
   


   /**
    *  a method to find the node in the tree with a smallest key
    * @param root  the root of the tree will be use in the method
    * @return value of the smalest value in the tree
    */
   public int getMin(Node root){
      if(root.left == null){return root.value;}
      return getMin(root.left);
   }


   /**
    *  a method to find the node in the tree with a largest key
    * @param root the root of the tree will be use in the method
    * @return value of the largest value in the tree
    */
   public int getMax(Node root){
      if(root.right == null){return root.value;}
      return getMax(root.right);
   }
   
   
   
   /*

   */

   /**
    * delet a node from the tree, this method will not compile until getMax is implemented
    * @param root the root of the tree will be use in the method
    * @param key  the vlaue need to be found to get deleted
    * @return value of the largest value in the tree
    */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}


public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert( 24);
      t1.insert( 80);
      t1.insert( 18);
      t1.insert( 9);
      t1.insert( 90);
      t1.insert(22);

      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();


   }
}

