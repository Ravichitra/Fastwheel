/*package com.fastwheel.fastwheelbackend;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastwheel.fastwheelbackend.DALayer.UserDetailsDAO;
import com.fastwheel.fastwheelbackend.model.UserDetails;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = dbconfig.class)
public class UserDetailsTest {
	@Autowired
	UserDetailsDAO userDAOImpl;

	 UserDetails u;

	@Before
	public void setUp() throws Exception {
		u = new UserDetails();
		u.setUser_Name("pa7an");
		u.setPhno("9788960608");
		u.setEmailid("ravipvan0@gmail.com");
		u.setUser_Password("pjvanchitra@408");
	}

	@After
	public void tearDown() throws Exception {

		userDAOImpl.DeleteUserDetails(u);
	}

	@Test
	public void test() {
		assertEquals("success", true, userDAOImpl.CreateUserDetails(u));

	}

}*/
