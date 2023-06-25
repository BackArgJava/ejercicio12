package com.example.Ejercicio4;

import com.example.Ejercicio4.entities.Laptop;

import com.example.Ejercicio4.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio7Application {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(Ejercicio7Application.class, args);
		LaptopRepository repository= context.getBean(LaptopRepository.class);


		//Creamos el crud
		//creamos las laptops
		Laptop laptop1 = new Laptop(null,"Asus","XT115",15,60.00,false);
		Laptop laptop2 = new Laptop(null,"Vaio","Z",20,400.00,true);


        //Almacenar las laptops

		System.out.println("Numeros de laptops en base de datos:  " + repository.findAll().size());
		repository.save(laptop1);
		repository.save(laptop2);

	}

}
