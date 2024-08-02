package com.keyin.finalsprint.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.keyin.finalsprint.utils.Optionull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TreeNode {

    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void insert(int input) {
        if (input < this.value) {
            if (this.left == null) {
                this.left = new TreeNode(input);
            } else {
                this.left.insert(input);
            }
        } else if (input > this.value) {
            if (this.right == null) {
                this.right = new TreeNode(input);
            } else {
                this.right.insert(input);
            }
        }
    }

    public void getInorder(Consumer<TreeNode> operation) {
        if (this.left != null) this.left.getInorder(operation);
        operation.accept(this);
        if (this.right != null) this.right.getInorder(operation);
    }

    private static TreeNode balance(List<TreeNode> nodes, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode node = nodes.get(middle);
        node.left = balance(nodes, start, middle - 1);
        node.right = balance(nodes, middle + 1, end);
        return node;
    }

    public TreeNode balance() {
        List<TreeNode> nodes = new ArrayList<>();
        this.getInorder(nodes::add);
        return balance(nodes, 0, nodes.size() - 1);
    }

    public JsonNode asJson() {
        ObjectNode nodes = new ObjectNode(JsonNodeFactory.instance);
        nodes.put("value", this.value);
        nodes.putIfAbsent("left", Optionull.map(this.left, TreeNode::asJson));
        nodes.putIfAbsent("right", Optionull.map(this.right, TreeNode::asJson));
        return nodes;
    }
}
