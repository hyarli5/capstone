package com.perscholas.PersonalExpenses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.perscholas.PersonalExpenses.entity.Category;
import com.perscholas.PersonalExpenses.service.CategoryServiceImpl;

@SpringBootTest
public class CategoryServiceImplTest {
	@Autowired
	private CategoryServiceImpl categoryServImpl;
	
	@Test
	public void testGetCategoryById()
	{
		final Long ID1 = (long) 10;
		
		Category expectedCategory = new Category("Groceries", "milk");
		Category actualCategory = categoryServImpl.getCategoryById(ID1);
		System.out.println(actualCategory.getCategoryName() + " " +actualCategory.getDescription());
		Assertions.assertNotNull(actualCategory);
		
	}
	
	

}
