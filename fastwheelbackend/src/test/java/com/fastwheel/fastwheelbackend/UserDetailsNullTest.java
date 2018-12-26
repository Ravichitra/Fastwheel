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
@SpringJUnitConfig(classes=dbconfig.class)
public class UserDetailsNullTest {
	@Autowired
	UserDetailsDAO UserDetailsDAOImpl;
UserDetails u;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		u=new UserDetails();
		assertEquals("success",true,UserDetailsDAOImpl.CreateUserDetails(u));
	}

}
*/