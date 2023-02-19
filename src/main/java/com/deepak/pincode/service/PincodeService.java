package com.deepak.pincode.service;

import com.deepak.pincode.Serialize.SerializeTrie;
import com.deepak.pincode.Trie.TrieNode;
import org.springframework.stereotype.Service;

@Service
public class PincodeService {

    private TrieNode trieNode;

    PincodeService(){
        this.trieNode = new SerializeTrie().DeserializeToTrie();
    }

    public TrieNode getTrieNode(){
        return this.trieNode;
    }
}
