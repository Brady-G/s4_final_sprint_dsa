package com.keyin.finalsprint;

import com.keyin.finalsprint.data.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeTests {

    @Test
    public void testInsert() {
        TreeNode root = new TreeNode(10);
        root.insert(50);
        root.insert(25);
        root.insert(75);

        Assertions.assertEquals(root.getValue(), 10);
        Assertions.assertNull(root.getLeft());
        Assertions.assertEquals(root.getRight().getValue(), 50);
        Assertions.assertEquals(root.getRight().getLeft().getValue(), 25);
        Assertions.assertEquals(root.getRight().getRight().getValue(), 75);
    }

    @Test
    public void testGetInorder() {
        TreeNode root = new TreeNode(10);
        root.insert(50);
        root.insert(25);
        root.insert(75);

        List<Integer> values = new ArrayList<>();
        root.getInorder(node -> values.add(node.getValue()));

        Assertions.assertEquals(values, List.of(10, 25, 50, 75));
    }

    @Test
    public void testBalance() {
        TreeNode root = new TreeNode(10);
        root.insert(50);
        root.insert(25);
        root.insert(75);

        root = root.balance();

        Assertions.assertEquals(root.getValue(), 25);
        Assertions.assertEquals(root.getLeft().getValue(), 10);
        Assertions.assertEquals(root.getRight().getValue(), 50);
        Assertions.assertEquals(root.getRight().getRight().getValue(), 75);
    }
}
