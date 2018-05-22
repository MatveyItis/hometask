package ru.kpfu.itis.maletskov.hometask.aisd;

import java.util.logging.Logger;

public class Tree {
   private Node root;
   private Logger log = Logger.getLogger(Tree.class.getName());

   public Tree(Node root) {
      this.root = root;
   }

   public void add(Node node, int value) {
      Node n = new Node(node, value);
      node.addChild(n);
   }
}