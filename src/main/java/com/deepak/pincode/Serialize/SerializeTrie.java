package com.deepak.pincode.Serialize;

import com.deepak.pincode.Trie.TrieNode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTrie {
    private TrieNode root;

    private String fileName = "triePincode.txt";

    public SerializeTrie(TrieNode root){
        this.root = root;
    }

    public SerializeTrie(){
        //nothing
    }

    public void serializeToFile(){
        System.out.println("Trie Serialization Started");

        try{
            FileOutputStream file = new FileOutputStream(this.fileName);
            ObjectOutputStream ob = new ObjectOutputStream(file);

            ob.writeObject(root);

            file.close();
            System.out.println("Trie Serialization Ended");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public TrieNode DeserializeToTrie(){
        System.out.println("Deserialization of trie Stated");

        TrieNode rootOut = null;

        try{
            FileInputStream file = new FileInputStream(this.fileName);
            ObjectInputStream ob = new ObjectInputStream(file);

            rootOut = (TrieNode) ob.readObject();

            if (rootOut != null)
                System.out.println("Deserialization of trie ended");

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return  rootOut;
    }
}
