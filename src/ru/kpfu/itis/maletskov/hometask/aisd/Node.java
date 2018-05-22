package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.ArrayList;
import java.util.List;

public class Node {
   private Node parent;
   private int value;
   private List<Node> children;

   public Node(int value) {
      this.value = value;
      this.parent = null;
      this.children = new ArrayList<>();
   }

   public Node(Node parent, int value) {
      this.value = value;
      this.parent = parent;
      this.children = new ArrayList<>();
   }

   public void addChild(Node node) {
      this.children.add(node);
   }

   public int getValue() {
      return value;
   }

   public Node getParent() {
      return parent;
   }

   public List<Node> getChildren() {
      return children;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return value == node.value;
   }
}