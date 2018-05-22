package ru.kpfu.itis.maletskov.hometask.aisd;


public class BinaryTree<T extends Comparable<T>> {
   private Node<T> head;

   public void add(T value) {
      if (this.contains(value) != null) {
         System.out.println("The Node is in the tree");
      }
      Node<T> node = new Node<>(null, null, null, value);
      if (head == null) {
         head = node;
      } else {
         this.addTo(node, head);
      }
   }

   private void addTo(Node node, Node other) {
      if (node.compareTo(other) > 0) {
         if (other.right == null) {
            other.setRight(node);
            node.setParent(other);
         } else {
            this.addTo(node, other.right);
         }
      } else {
         if (other.left == null) {
            other.setLeft(node);
            node.setParent(other);
         } else {
            this.addTo(node, other.left);
         }
      }
   }

   public boolean remove(T value) {
      Node<T> removeN = this.contains(value);
      Node<T> parentN = removeN.parent;
      if (removeN == null) {
         return false;
      }
      if (removeN.right == null) {
         if (parentN == null) {
            head = removeN.left;
            return true;
         } else {
            parentN.setLeft(removeN.left);
            return true;
         }
      } else {
         Node<T> minRight = removeN.right;
         while (minRight.left != null) {
            minRight = minRight.left;
         }
         if (minRight.parent.left == minRight) {
            minRight.parent.left = null;
         } else {
            minRight.parent.right = null;
         }
         minRight.setLeft(removeN.getLeft());
         minRight.setRight(removeN.getRight());
         minRight.setParent(removeN.getParent());
         removeN.parent.setLeft(minRight);
         return true;
      }
   }

   public void printTree() {
      this.printTree(head);
   }

   public void printTree(Node head) {
      System.out.println("  head = " + head.value
              + "\nleft = " + (head.left != null ? head.left.value : null)
              + " right = " + (head.right != null ? head.right.value : null));
      if (head.left != null) {
         this.printTree(head.left);
      }
      if (head.right != null) {
         this.printTree(head.right);
      }
   }

   public Node<T> contains(T value) {
      Node<T> contain = this.head;
      while (contain != null) {
         if (contain.getValue().compareTo(value) == 0 || contain == null) {
            return contain;
         }
         contain = contain.getValue().compareTo(value) < 0 ?
                 contain.getRight() : contain.getLeft();
      }
      return contain;
   }

   private class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
      private Node left, right, parent;
      private T value;

      public Node(Node left, Node right, Node parent, T value) {
         this.left = left;
         this.right = right;
         this.parent = parent;
         this.value = value;
      }

      public Node getLeft() {
         return left;
      }

      public void setLeft(Node left) {
         this.left = left;
      }

      public Node getRight() {
         return right;
      }

      public void setRight(Node right) {
         this.right = right;
      }

      public T getValue() {
         return value;
      }

      public void setValue(T value) {
         this.value = value;
      }

      public Node getParent() {
         return parent;
      }

      public void setParent(Node parent) {
         this.parent = parent;
      }

      @Override
      public int compareTo(Node<T> other) {
         return this.value.compareTo(other.getValue());
      }
   }
}
