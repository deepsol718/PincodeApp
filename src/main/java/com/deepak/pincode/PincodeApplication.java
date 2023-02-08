package com.deepak.pincode;

import com.deepak.pincode.dao.PincodeDao;
import com.deepak.pincode.entities.Pincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

//		PincodeDaoImpl pincodeDao1 = new PincodeDaoImpl();

//		List<Pincode> list = pincodeDao.getListBypPincode(203393);

		Scanner scan = new Scanner(System.in);

		String city;

		while(true){
			System.out.println("search pincode for city: ");

			city = scan.nextLine();
			List<Pincode> list = pincodeDao.getListByOfficeName(city);

			for (Pincode p: list){
				System.out.println(p);
			}
		}


	}
}
