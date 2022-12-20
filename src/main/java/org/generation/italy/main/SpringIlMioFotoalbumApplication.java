package org.generation.italy.main;

import org.generation.italy.main.pojo.Photo;
import org.generation.italy.main.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Autowired
	private PhotoService photoService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Photo p1 = new Photo("photo1", "photo1 desc", 
				"https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bGFuZHNjYXBlfGVufDB8fDB8fA%3D%3D&w=1000&q=80",
				"landscape", true);
		Photo p2 = new Photo("photo2", "photo2 desc", 
				"https://media.wired.com/photos/593261cab8eb31692072f129/master/pass/85120553.jpg",
				"animal", true);
		
		photoService.save(p1);
		photoService.save(p2);
		
	}

}
