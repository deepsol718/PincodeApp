package com.deepak.pincode;

import com.deepak.pincode.Serialize.Serialization;
import com.deepak.pincode.Serialize.SerializeTrie;
import com.deepak.pincode.Trie.TrieClass;
import com.deepak.pincode.Trie.TrieNode;
import com.deepak.pincode.dao.PincodeDao;
import com.deepak.pincode.dao.PincodeDaoImpl;
import com.deepak.pincode.entities.Pincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PincodeApplication implements CommandLineRunner {

	@Autowired
	private PincodeDao pincodeDao;

	public static void main(String[] args) {
		System.out.println("main started");
		SpringApplication.run(PincodeApplication.class, args);
		System.out.println("main ended");
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("run started");

		PincodeDaoImpl pincodeDao1 = new PincodeDaoImpl();

//		List<Pincode> list = pincodeDao.getListBypPincode(203393);

		Scanner scan = new Scanner(System.in);
//
//		String city;
//
//		while(true){
//			System.out.println("search pincode for city: ");
//
//			city = scan.nextLine();
//			List<Pincode> list = pincodeDao.getListByOfficeName(city);
//
//			for (Pincode p: list){
//				System.out.println(p);
//			}
//		}

//		List<Pincode> list = pincodeDao.getAll();

//		Serialization sr = new Serialization();

//		sr.SerializeToFile();

//		List<Pincode> list1 = sr.DeserializeToObject();

//		TrieClass trieClass = new TrieClass();

//		for (int i = 0; i < 10; i++){
////			System.out.println(list1.get(i));
//		}

//		while(true){
//			System.out.println("search city by pincode: ");
//
//			int pincode = new Scanner(System.in).nextInt();
//
//			for (Pincode pin: list1){
//				if (pin.getPincode() == pincode){
//					System.out.println(pin);
//				}
//			}
//		}

//		Pincode p1 = new Pincode(1,"debai","sdf","sdsf");
//		Pincode p2 = new Pincode(1,"aligarh","sdf","sdsf");
//		Pincode p3 = new Pincode(1,"jalandhar","sdf","sdsf");
//		Pincode p4 = new Pincode(1,"shimla","sdf","sdsf");
//		Pincode p5 = new Pincode(1,"shimlg","sdf","sdsf");
//		Pincode p6 = new Pincode(1,"z","sdf","sdsf");
//		Pincode p7 = new Pincode(1,"b","sdf","sdsf");
//
//
//
//		trieClass.add(p1);
//		trieClass.add(p2);
//		trieClass.add(p3);
//		trieClass.add(p4);
//		trieClass.add(p5);
//		trieClass.add(p6);
//		trieClass.add(p7);

//		trieClass.print();

//		for (Pincode p: list1){
//			trieClass.add(p);
//		}

//		TrieSerializer(trieClass.getRoot());
		TrieDeserializer();

//		System.out.println("tries is completed");

//		while(true){
//			System.out.println("search pincode data by city");
//			String cityName = scan.nextLine();
//			List<Pincode> listPincodeData = trieClass.searchByCity(cityName);
//			if(listPincodeData == null) continue;
//			for (Pincode pins: listPincodeData){
//				System.out.println(pins);
//			}
//		}

	}

	public void TrieSerializer(TrieNode root){
		SerializeTrie serializeTrie = new SerializeTrie(root);

		serializeTrie.serializeToFile();

		TrieNode root1 = serializeTrie.DeserializeToTrie();

		TrieClass trieClass = new TrieClass(root1);

		while(true){
			System.out.println("search pincode data by city");
			String cityName = new Scanner(System.in).nextLine();
			List<Pincode> listPincodeData = trieClass.searchByCity(cityName);
			if(listPincodeData == null) continue;
			for (Pincode pins: listPincodeData){
				System.out.println(pins);
			}
		}
	}

	public void TrieDeserializer(){
		SerializeTrie serializeTrie = new SerializeTrie();

		TrieNode root = serializeTrie.DeserializeToTrie();

		TrieClass trieClass = new TrieClass(root);

		while(true){
			System.out.println("search pincode data by city");
			String cityName = new Scanner(System.in).nextLine();
			List<Pincode> listPincodeData = trieClass.searchByCity(cityName);
			if(listPincodeData == null) continue;
			for (Pincode pins: listPincodeData){
				System.out.println(pins);
			}
		}
	}

}
