package com.keyin.finalsprint.models;

import jakarta.persistence.*;

@Entity
public class TreeEntry {

    @Id
    @SequenceGenerator(name = "tree_sequence", sequenceName = "tree_sequence", allocationSize = 1)
    @GeneratedValue(generator = "tree_sequence")
    private long id;

    private String numbers;
    @Column(length = Short.MAX_VALUE)
    private String json;

    public TreeEntry() {}

    public TreeEntry(String numbers, String json) {
        this.numbers = numbers;
        this.json = json;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getJson() {
        return json;
    }
}
