package org.generation.italy.main;

import org.generation.italy.main.pojo.Category;
import org.generation.italy.main.pojo.Photo;
import org.generation.italy.main.pojo.Role;
import org.generation.italy.main.pojo.User;
import org.generation.italy.main.service.CategoryService;
import org.generation.italy.main.service.PhotoService;
import org.generation.italy.main.service.RoleService;
import org.generation.italy.main.service.UserService;
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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Role adminRole = new Role("ADMIN");
		Role userRole = new Role("USER");
		roleService.save(adminRole);
		roleService.save(userRole);
		
		User user1 = new User("user1", "{noop}user", userRole);
		User admin = new User("admin", "{noop}admin", adminRole);
		
		userService.save(user1);
		userService.save(admin);
		
		Category funny = new Category("funny");
		Category animal = new Category("animal");
		Category portrait = new Category("portrait");
		Category landscape = new Category("landscape");
		Category sport = new Category("sport");
		
		categoryService.save(funny);
		categoryService.save(animal);
		categoryService.save(portrait);
		categoryService.save(landscape);
		categoryService.save(sport);
		
		Photo p1 = new Photo("photo1", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia ititiis ipsam vero asperiores dolore voluptate. Nobis tenetur facilis atque deserunt eligendi.", 
				"https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bGFuZHNjYXBlfGVufDB8fDB8fA%3D%3D&w=1000&q=80",
				"awesome", true, landscape);
		Photo p2 = new Photo("photo2", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia itaque perferendis recausandae molestias, totam illum, facere voluptatibus esse blanditiis ipsam vero asperiores dolore voluptate. Nobis tenetur facilis atque deserunt eligendi.", 
				"https://media.wired.com/photos/593261cab8eb31692072f129/master/pass/85120553.jpg",
				"hilarious", true, animal, funny);
		Photo p3 = new Photo("photo3", "desc", 
				"https://rcsacademy.corriere.it/wp-content/uploads/2022/04/PT_Management-dello-Sport_schiarita_O-1.jpg?v=1651144010",
				"sport", true, sport);
		Photo p4 = new Photo("photo4", "desc", 
				"https://rcsacademy.corriere.it/wp-content/uploads/2022/04/PT_Management-dello-Sport_schiarita_O-1.jpg?v=1651144010",
				"sport", true, sport);
		Photo p5 = new Photo("photo5", "desc", 
				"https://rcsacademy.corriere.it/wp-content/uploads/2022/04/PT_Management-dello-Sport_schiarita_O-1.jpg?v=1651144010",
				"sport", true, sport);
		Photo p6 = new Photo("photo6", "desc", 
				"https://rcsacademy.corriere.it/wp-content/uploads/2022/04/PT_Management-dello-Sport_schiarita_O-1.jpg?v=1651144010",
				"sport", true, sport);
		Photo p7 = new Photo("photo7", "desc", 
				"https://rcsacademy.corriere.it/wp-content/uploads/2022/04/PT_Management-dello-Sport_schiarita_O-1.jpg?v=1651144010",
				"sport", true, sport);
		Photo p8 = new Photo("photo8", "desc", 
				"https://rcsacademy.corriere.it/wp-content/uploads/2022/04/PT_Management-dello-Sport_schiarita_O-1.jpg?v=1651144010",
				"sport", true, sport);
		
		
		photoService.save(p1);
		photoService.save(p2);
		photoService.save(p3);
		photoService.save(p4);
		photoService.save(p5);
		photoService.save(p6);
		photoService.save(p7);
		photoService.save(p8);
		
	}

}
