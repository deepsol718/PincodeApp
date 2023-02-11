package com.deepak.pincode.Serialize;

import com.deepak.pincode.entities.Pincode;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class Serialization {
    private List<Pincode> list;

    private String fileName = "pincodelist.txt";

    public Serialization(List<Pincode> list){
        this.list = list;
    }

    public Serialization(){
        //hey I am empty
    }
    public void SerializeToFile(){

        try{

            System.out.println("log: serialisation started");

            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream ob = new ObjectOutputStream(file);

            ob.writeObject(this.list);
            file.close();
            System.out.println("log: serialisation ended");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Pincode> DeserializeToObject(){
        List<Pincode> outPutList = null;

        try{
            System.out.println("Log: deserialisation started");

            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream oj = new ObjectInputStream(file);

            outPutList = (List<Pincode>) oj.readObject();

            if(outPutList != null)
            System.out.println("Log: Text file converted to object");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return outPutList;
    }

}
