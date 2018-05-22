package ru.kpfu.itis.maletskov.hometask.aisd;

public class Treap<X extends Comparable<X>, Y extends Comparable<Y>> {
   private Node<X, Y> root;

   public Treap() {
      this.root = null;
   }

   private class Node<X extends Comparable<X>, Y extends Comparable<Y>> implements Comparable<Node<X, Y>> {
      private X x;
      private Y y;
      private Node<X, Y> left, right, parent;

      public Node(X x, Y y) {
         this.x = x;
         this.y = y;
         this.left = null;
         this.right = null;
         this.parent = null;
      }

      public void setLeft(Node<X, Y> left) {
         this.left = left;
      }

      public void setRight(Node<X, Y> right) {
         this.right = right;
      }

      public void setParent(Node<X, Y> parent) {
         this.parent = parent;
      }

      public Node<X, Y> getLeft() {
         return left;
      }

      public Node<X, Y> getRight() {
         return right;
      }

      public Node<X, Y> getParent() {
         return parent;
      }

      public X getX() {
         return x;
      }

      public Y getY() {
         return y;
      }

      @Override
      public int compareTo(Node<X, Y> o) {
         return o.getY().compareTo(getY());
      }
   }
}
