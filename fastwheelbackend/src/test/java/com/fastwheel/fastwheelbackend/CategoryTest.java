/*package com.fastwheel.fastwheelbackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastwheel.fastwheelbackend.DALayer.CategoryDAO;
import com.fastwheel.fastwheelbackend.model.Category;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=dbconfig.class)
public class CategoryTest
{
	@Autowired
	CategoryDAO  categoryDAOImpl;
	
	Category c;

	@Before
	public void setUp() throws Exception {
		 c=new Category();
		 c.setCategory_Name("hercules");
		 c.setCategoryDesc("nicecycle");
	}

	@After
	public void tearDown() throws Exception {
		categoryDAOImpl.DeleteCategory("bmx");
		
	}
	@Test
	
	public void test() {
		//assertEquals("success", true, categoryDAOImpl.CreateCategory(c));
		categoryDAOImpl.CreateCategory(c);
		List<Category>list=categoryDAOImpl.ViewAllCategory();
		 Category k=categoryDAOImpl.ViewOneCategory("hercules");
		assertTrue("sucess", list.size()>0);
		assertTrue("sucesss", c!=null);
		k.setCategory_Name("good");
		categoryDAOImpl.UpdateCategory(c);
		Category c1=cate33goryDAOImpl.ViewOneCategory("good");
		assertTrue("sucess", c1.getCategory_Name()=="good");
	}

	}

 
*/