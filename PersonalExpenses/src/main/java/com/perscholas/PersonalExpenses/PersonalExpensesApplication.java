package com.perscholas.PersonalExpenses;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import com.perscholas.PersonalExpenses.entity.Category;
import com.perscholas.PersonalExpenses.repository.CategoryRepository;

implements CommandLineRunner */

@SpringBootApplication
public class PersonalExpensesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PersonalExpensesApplication.class, args);
	}

/*	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public void run(String... args)throws Exception{
		Category category1 = new Category("Milk", "Food");
		categoryRepo.save(category1);
				
				
	}*/
}
