package com.deepak.pincodehibernate;

import com.deepak.pincodehibernate.Entity.Pincode;
import com.deepak.pincodehibernate.dao.PincodeRepository;
import com.deepak.pincodehibernate.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PincodehibernateApplication implements CommandLineRunner {

	@Autowired
	private PincodeRepository pincodeRepository;

	@Autowired
	private PincodeService pincodeService;

	public static void main(String[] args) {
		SpringApplication.run(PincodehibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Pincode> list = pincodeRepository.findByCity("debai %");
		System.out.println("log: inside run method");
		System.out.println("log: the size of list is: " + list.size());
		for (Pincode p: list){
			System.out.println(p);
		}

		Pincode p = pincodeRepository.findById(21).orElse(null);
		System.out.println(p);

		Pincode p1 = pincodeService.getPincodeDataById(1);

		System.out.println(p1);
	}
}
