package com.deepak.pincode.Trie;

import com.deepak.pincode.entities.Pincode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrieNode implements Serializable {
    private char c;
    private boolean end;
    private List<Pincode> commonPincodes;
    private TrieNode[] children;

    public TrieNode(char c) {
        this.c = c;
        commonPincodes = new ArrayList<>();
        this.end = false;
        children = new TrieNode[26];
    }

    public TrieNode(char c, boolean end, List<Pincode> commonPincodes, TrieNode[] children) {
        this.c = c;
        this.end = end;
        this.commonPincodes = commonPincodes;
        this.children = children;
    }

    public List<Pincode> getCommonPincodes() {
        return commonPincodes;
    }

    public void setCommonPincodes(List<Pincode> commonPincodes) {
        this.commonPincodes = commonPincodes;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

}
