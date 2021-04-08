package com.heap.heap_project;

import com.heap.heap_project.models.ActivityType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeapProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeapProjectApplication.class, args);
		System.out.println(ActivityType.Coiffeur.getServices());
		System.out.println(ActivityType.Estheticienne.getServices());
		System.out.println(ActivityType.Estheticienne.getServices());
	}

}
