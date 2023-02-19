package com.deepak.pincode.Controller;

import com.deepak.pincode.Trie.TrieClass;
import com.deepak.pincode.Trie.TrieNode;
import com.deepak.pincode.entities.Pincode;
import com.deepak.pincode.service.PincodeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PincodeController {

    @Autowired
    private PincodeService pincodeService;

    private TrieClass trieClass;

    @PostConstruct
    public void setTrieClass(){
        TrieNode trieNode = pincodeService.getTrieNode();
        this.trieClass = new TrieClass(trieNode);
    }

    @GetMapping("/getpincode")
    public List<Pincode> getList(@RequestParam(name="city") String cityName){
        return this.trieClass.searchByCity(cityName);
    }
}
