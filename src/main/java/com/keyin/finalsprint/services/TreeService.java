package com.keyin.finalsprint.services;

import com.keyin.finalsprint.data.TreeNode;
import com.keyin.finalsprint.models.TreeEntry;
import com.keyin.finalsprint.repositories.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository repository;

    public List<TreeEntry> get() {
        return repository.findAll();
    }

    public TreeNode create(int[] numbers) {
        TreeNode root = new TreeNode(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            root.insert(numbers[i]);
        }
        root = root.balance();
        repository.save(new TreeEntry(Arrays.toString(numbers), root.asJson().toPrettyString()));
        return root;
    }
}
