package com.deepak.pincode.Trie;


import com.deepak.pincode.entities.Pincode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieClass implements Serializable {
    private TrieNode root;

    public TrieClass(){
        root = new TrieNode('\0');
    }

    public TrieClass(TrieNode root) {
        this.root = root;
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public void add(Pincode pincodeData){
//        System.out.println("adding the city: "+pincodeData.getOffice());
        String cityName = pincodeData.getOffice();

        cityName = checkCityName(cityName);
        if(cityName.length()==0) return;

        add(cityName,root, pincodeData);
    }


    public void add(String cityName, TrieNode root, Pincode pincodeData){
        int i = cityName.charAt(0) - 'a';

        if (root.getChildren()[i] == null){
            root.getChildren()[i] = new TrieNode(cityName.charAt(0));
        }

        if(cityName.length() == 1){
            root.getChildren()[i].getCommonPincodes().add(pincodeData);
            root.getChildren()[i].setEnd(true);
//            System.out.println("city Added: "+ pincodeData.getOffice()+", last character: "+cityName.charAt(0));
            return;
        }

        add(cityName.substring(1),root.getChildren()[i], pincodeData );
    }
    
    public List<Pincode> searchByCity(String cityName){
        cityName = checkCityName(cityName);
        if(cityName == null || cityName.length() == 0){
            return Arrays.asList(new Pincode[]{new Pincode(0,"NA","NA","NA")});
        }
        return searchByCity(cityName, root);
    }
    
    public List<Pincode> searchByCity(String cityName, TrieNode root){
//        System.out.println("checking for "+cityName.charAt(0));
        int i = cityName.charAt(0) - 'a';

        if(root.getChildren()[i] == null){
            System.out.println("Pincode data not found");
            return null;
        }

        if(cityName.length() == 1 && root.getChildren()[i].isEnd()){
            System.out.println(root.getChildren()[i].getC());
            return root.getChildren()[i].getCommonPincodes();
        }

        if(cityName.length() == 1 && !root.getChildren()[i].isEnd()){
            System.out.println("searched city does not exist");
            return null;
        }

        List<Pincode> list = new ArrayList<>();

        list = searchByCity(cityName.substring(1),root.getChildren()[i]);

        return list;
    }

    public String checkCityName(String cityName){
        cityName = cityName.toLowerCase();

        for (int i = 0; i < cityName.length(); i++){
            if( cityName.charAt(i) == ' '){
                cityName = cityName.substring(0,i);
                break;
            }
        }

        for (int i = 0; i < cityName.length(); i++){
            int ascii = cityName.charAt(i) - 'a';
            if(ascii < 0 || ascii > 25){
                cityName = cityName.substring(0,i);
                break;
            }
        }

        return cityName;
    }

    public void print(){
        print(root);
    }

    public void print(TrieNode root){

        if(root.isEnd()){
            System.out.println(root.getCommonPincodes());
        }

        for (int i = 0; i<26; i++){
            if(root.getChildren()[i] != null){
                int ascii = i + 'a';
                char c = (char) ascii;
//                System.out.print(c);
                print(root.getChildren()[i]);
            }
        }

//        System.out.println();
    }
}
